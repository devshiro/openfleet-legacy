package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.pojo.SamplePieData;
import com.markbudai.openfleet.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DocumentService service;

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
            service.writeDocument(response.getOutputStream());
            response.flushBuffer();
        }catch (Exception e){
            //error
        }
    }
}
