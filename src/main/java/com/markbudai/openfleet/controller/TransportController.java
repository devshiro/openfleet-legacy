package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.services.TransferCostService;
import com.markbudai.openfleet.services.TransportService;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.framework.builder.TransferCostBuilder;
import com.markbudai.openfleet.framework.builder.TransportBuilder;
import com.markbudai.openfleet.model.TransferCost;
import com.markbudai.openfleet.model.Transport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 29..
 */
//TODO: Update transports feautre
@Controller
public class TransportController {

    private static Logger logger = LoggerFactory.getLogger(TransportController.class);

    private static String viewPrefix = "transport/";

    private TransportService transportService;

    @Autowired
    private TransferCostService costProvider;

    @Autowired
    private TransportBuilder builder;

    @Autowired
    public TransportController(TransportService provider){
        this.transportService = provider;
    }


    @RequestMapping("/transport/jobs/list")
    public String transportIndex(Model model){
        model.addAttribute("title","Transports");
        model.addAttribute("transports", transportService.getAllTransports());
        return viewPrefix+"listTransports";
    }

    @RequestMapping("/transport/new")
    public String newTransport(Model model){
        model.addAttribute("title","New Transport");
        return viewPrefix+"newTransport";
    }

    @RequestMapping("/transport/edit")
    public String editTransport(Model model, @RequestParam("id") long id){
        logger.trace("Providing form to edit transport with id: {}",id);
        Transport transport = transportService.getTransportById(id);
        if(transport == null) throw new NotFoundException(Transport.class);
        model.addAttribute("transport",transport);
        return newTransport(model);
    }

    @PostMapping("/transport/job/add")
    public String addTransport(Model model, WebRequest request){
        Transport t = builder.buildFromWebRequest(request);
        logger.debug("Build transport: {}",t);
        if(t.getId() != 0){
            transportService.updateTransport(t);
        } else {
            transportService.addTransport(t);
        }
        return transportIndex(model);
    }

    @RequestMapping("/transport/job")
    public String transportDetails(@RequestParam("id") long id, Model model){
        logger.trace("Serving details about transport job with id: {}",id);
        model.addAttribute("title","Transports");
        model.addAttribute("transport", transportService.getTransportById(id));
        return viewPrefix+"transportDetails";
    }

    @PostMapping("/transport/job/addCost")
    public String addCost(Model model, WebRequest request){
        logger.trace("Adding Costs...");
        long id = Long.parseLong(request.getParameter("transportId"));
        logger.debug("id: {}",id);
        TransferCost cost = TransferCostBuilder.buildFromWebRequest(request);
        logger.debug("cost: {}",cost);
        Transport transport = transportService.getTransportById(id);
        transport.addCost(cost);
        logger.debug("count: {}",transport.getCosts().size());
        transportService.updateTransport(transport);
        return transportDetails(id,model);
    }

    @RequestMapping("/transport/job/deleteCost")
    public String removeCost(Model model, WebRequest request, @RequestParam("id") long id, @RequestParam("transportId") long transportId){
        logger.trace("Remove cost with id {}",id);
        Transport transport = transportService.getTransportById(transportId);
        logger.debug("Found transport: {}",transport);
        List<TransferCost> costs = transport.getCosts();
        TransferCost cost = costs.stream().filter(c->c.getId() == id).collect(Collectors.toList()).get(0);
        logger.debug("Found cost: {}",cost);
        costs.remove(cost);
        transport.setCosts(costs);
        transportService.updateTransport(transport);
        costProvider.deleteCost(id);
        return transportDetails(transportId,model);
    }



    @RequestMapping(value = "/transports/api", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Transport> allTransports(){
        List<Transport> transports = transportService.getAllTransports();
        return transports;
    }
}