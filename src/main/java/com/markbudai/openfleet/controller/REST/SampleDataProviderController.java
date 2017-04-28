package com.markbudai.openfleet.controller.REST;

import com.markbudai.openfleet.pojo.SamplePieData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 04. 20..
 */
@RestController
public class SampleDataProviderController {

    @RequestMapping("/api/drivers")
    public List<SamplePieData> pieData() {
        List<SamplePieData> l = new ArrayList<>();
        l.add(new SamplePieData("Driver 1",300));
        l.add(new SamplePieData("Driver 2",200));
        l.add(new SamplePieData("Driver 3",1000));

        return l;
    }
}
