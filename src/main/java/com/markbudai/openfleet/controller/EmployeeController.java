package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mark on 2017. 04. 15..
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeProvider employeeProvider;

    @RequestMapping("/employee/list")
    public String listEmployees(Model model){
        model.addAttribute("employeeList",employeeProvider.getAllEmployees());
        model.addAttribute("path","/employee/list");
        model.addAttribute("title","Employees");
        return "listEmployees";
    }
}
