package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.framework.EmployeeBuilder;
import com.markbudai.openfleet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Mark on 2017. 04. 15..
 */
@Controller
public class EmployeeController {


    private EmployeeProvider employeeProvider;
    private EmployeeBuilder builder;

    @Autowired
    public EmployeeController(EmployeeProvider provider, EmployeeBuilder builder){
        this.employeeProvider = provider;
        this.builder = builder;
    }

    @RequestMapping("/employee/list")
    public String listEmployees(Model model){
        model.addAttribute("employeeList",employeeProvider.getAllEmployees());
        model.addAttribute("path","/employee/list");
        model.addAttribute("title","Employees");
        return "listEmployees";
    }

    @RequestMapping("/employee/new")
    public String newEmployeeForm(Model model){
        model.addAttribute("title","New Employee Form");
        return "employeeDetails";
    }

    @PostMapping("/employee/add")
    public String employeeSubmit(Model model, WebRequest request){
        Employee e = builder.build(request);
        if(e.getId() != 0){
            employeeProvider.updateEmployee(e);
        } else{
            employeeProvider.addEmployee(e);
        }
        return listEmployees(model);
    }

    @RequestMapping("/employee/edit")
    public String editEmployee(@RequestParam("id") long id, Model model){
        Employee e = employeeProvider.getEmployeeById(id);
        model.addAttribute("employee",e);
        model.addAttribute("title","Employee");
        return "employeeDetails";
    }

    @RequestMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("id") long id, Model model){
        employeeProvider.fireEmployee(id);
        return listEmployees(model);
    }

    @RequestMapping("/employee")
    public String employeeDetail(@RequestParam("id") long id, Model model){
        return editEmployee(id,model);
    }
}
