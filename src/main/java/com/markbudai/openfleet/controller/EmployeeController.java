package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.framework.builder.EmployeeBuilder;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Mark on 2017. 04. 15..
 */
@Controller
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeProvider employeeProvider;
    private EmployeeBuilder builder;
    private PaymentService paymentService;

    private static String viewPrefix = "employee/";

    @Autowired
    public EmployeeController(EmployeeProvider provider, EmployeeBuilder builder,PaymentService paymentService){
        this.employeeProvider = provider;
        this.builder = builder;
        this.paymentService = paymentService;
        logger.debug("{} created.",this.getClass());
    }

    @RequestMapping("/employee/list")
    public String listEmployees(Model model){
        logger.debug("Serving /employee/list");
        model.addAttribute("employeeList",employeeProvider.getAllEmployees());
        model.addAttribute("path","/employee/list");
        model.addAttribute("title","Employees");
        return viewPrefix+"listEmployees";
    }

    @RequestMapping("/employee/new")
    public String newEmployeeForm(Model model){
        logger.debug("Serving /employee/new");
        model.addAttribute("title","New Employee Form");
        return viewPrefix+"employeeDetails";
    }

    @PostMapping("/employee/add")
    public String employeeSubmit(Model model, WebRequest request){
        Employee e = builder.buildFromWebRequest(request);
        logger.debug("Adding Employee {} to the database.",e);
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
        logger.debug("Giving Employee {} for edit.",e);
        model.addAttribute("employee",e);
        model.addAttribute("title","Employee");
        return viewPrefix+"employeeDetails";
    }

    @RequestMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("id") long id, Model model){
        logger.debug("Removing Employee with id {}",id);
        employeeProvider.fireEmployee(id);
        return listEmployees(model);
    }

    @RequestMapping("/employee")
    public String employeeDetail(@RequestParam("id") long id, Model model){
        return editEmployee(id,model);
    }

    @RequestMapping("/employee/payment")
    public String employeePaymentsList(Model model){
        model.addAttribute("title","Payments");
        return viewPrefix+"employeePayments";
    }
}
