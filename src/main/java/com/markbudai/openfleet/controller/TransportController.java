package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.TransportProvider;
import com.markbudai.openfleet.model.Transport;
import org.apache.commons.collections4.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Controller
public class TransportController {

    private static Logger logger = LoggerFactory.getLogger(TransportController.class);

    private static String viewPrefix = "transport/";

    private TransportProvider transportProvider;

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

    @RequestMapping("/transport/job")
    public String transportDetails(@RequestParam("id") long id, Model model){
        model.addAttribute("title","Transports");
        model.addAttribute("transport",transportProvider.getTransportById(id));
        return viewPrefix+"transportDetails";
    }

    @RequestMapping(value = "/transports/api", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Transport> allTransports(){
        List<Transport> transports = transportProvider.getAllTransports();
        return transports;
    }
}