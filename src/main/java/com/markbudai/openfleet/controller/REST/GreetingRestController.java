package com.markbudai.openfleet.controller.REST;

import com.markbudai.openfleet.pojo.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Mark on 2017. 04. 14..
 */
@RestController
public class GreetingRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/api/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue = "OpenFleet") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}