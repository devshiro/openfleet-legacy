package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.*;
import com.markbudai.openfleet.model.*;
import com.markbudai.openfleet.pojo.SamplePieData;
import com.markbudai.openfleet.services.DocumentService;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    private static Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private DocumentService service;

    @Autowired
    private TransferCostProvider provider;

    @Autowired
    private TractorProvider tractorProvider;

    @Autowired
    private TrailerProvider trailerProvider;

    @Autowired
    private EmployeeProvider employeeProvider;

    @Autowired
    private LocationProvider locationProvider;

    @Autowired
    private TransportProvider transportProvider;

    @RequestMapping(value = "/drivers", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<SamplePieData> pieData() {
        List<SamplePieData> l = new ArrayList<>();
        l.add(new SamplePieData("Driver 1",300));
        l.add(new SamplePieData("Driver 2",200));
        l.add(new SamplePieData("Driver 3",1000));

        return l;
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public void getFile(HttpServletResponse response){
        try{
            //response.setContentType("");
            //TODO: Figure out why this isn't working!!!
            service.writeDocument(response.getOutputStream());
            response.flushBuffer();
        }catch (Exception e){
            //error
        }
    }

    @RequestMapping("/test")
    public String test(){
        List<Transport> list = transportProvider.getAllTransports();
        logger.debug("{}",list.get(0));
        return "index";
    }
}
