package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.pojo.SamplePieData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/drivers", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<SamplePieData> pieData() {
        List<SamplePieData> l = new ArrayList<>();
        l.add(new SamplePieData("Driver 1",300));
        l.add(new SamplePieData("Driver 2",200));
        l.add(new SamplePieData("Driver 3",1000));

        return l;
    }
}
