package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

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

    @PostMapping("/employee/add")
    public String employeeSubmit(Model model, WebRequest request){
        Employee e = new Employee();
        employeeProvider.addEmployee(e);
        return listEmployees(model);
    }
}
