package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.TransferCostProvider;
import com.markbudai.openfleet.dao.providers.TransportProvider;
import com.markbudai.openfleet.framework.builder.TransferCostBuilder;
import com.markbudai.openfleet.framework.builder.TransportBuilder;
import com.markbudai.openfleet.model.TransferCost;
import com.markbudai.openfleet.model.Transport;
import org.apache.commons.collections4.Get;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Controller
public class TransportController {

    private static Logger logger = LoggerFactory.getLogger(TransportController.class);

    private static String viewPrefix = "transport/";

    private TransportProvider transportProvider;

    @Autowired
    private TransferCostProvider costProvider;

    @Autowired
    private TransportBuilder builder;

    @Autowired
    public TransportController(TransportProvider provider){
        this.transportProvider = provider;
    }


    @RequestMapping("/transport/jobs/list")
    public String transportIndex(Model model){
        model.addAttribute("title","Transports");
        model.addAttribute("transports",transportProvider.getAllTransports());
        return viewPrefix+"listTransports";
    }

    @RequestMapping("/transport/new")
    public String newTransport(Model model){
        model.addAttribute("title","New Transport");
        return viewPrefix+"newTransport";
    }

    @PostMapping("/transport/job/add")
    public String addTransport(Model model, WebRequest request){
        Transport t = builder.buildFromWebRequest(request);
        logger.debug("Build transport: {}",t);
        transportProvider.addTransport(t);
        return transportIndex(model);
    }

    @RequestMapping("/transport/job")
    public String transportDetails(@RequestParam("id") long id, Model model){
        logger.trace("Serving details about transport job with id: {}",id);
        model.addAttribute("title","Transports");
        model.addAttribute("transport",transportProvider.getTransportById(id));
        return viewPrefix+"transportDetails";
    }

    @PostMapping("/transport/job/addCost")
    public String addCost(Model model, WebRequest request){
        logger.trace("Adding Costs...");
        long id = Long.parseLong(request.getParameter("transportId"));
        logger.debug("id: {}",id);
        TransferCost cost = TransferCostBuilder.buildFromWebRequest(request);
        logger.debug("cost: {}",cost);
        Transport transport = transportProvider.getTransportById(id);
        transport.addCost(cost);
        logger.debug("count: {}",transport.getCosts().size());
        transportProvider.updateTransport(transport);
        return transportDetails(id,model);
    }

    @RequestMapping("/transport/job/deleteCost")
    public String removeCost(Model model, WebRequest request, @RequestParam("id") long id, @RequestParam("transportId") long transportId){
        logger.trace("Remove cost with id {}",id);
        Transport transport = transportProvider.getTransportById(transportId);
        logger.debug("Found transport: {}",transport);
        List<TransferCost> costs = transport.getCosts();
        TransferCost cost = costs.stream().filter(c->c.getId() == id).collect(Collectors.toList()).get(0);
        logger.debug("Found cost: {}",cost);
        costs.remove(cost);
        transport.setCosts(costs);
        transportProvider.updateTransport(transport);
        costProvider.deleteCost(id);
        return transportDetails(transportId,model);
    }



    @RequestMapping(value = "/transports/api", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Transport> allTransports(){
        List<Transport> transports = transportProvider.getAllTransports();
        return transports;
    }
}