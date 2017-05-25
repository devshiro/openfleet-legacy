package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.services.EmployeeService;
import com.markbudai.openfleet.exception.IdException;
import com.markbudai.openfleet.exception.NullException;
import com.markbudai.openfleet.framework.builder.EmployeeBuilder;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.pojo.Payout;
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

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 04. 15..
 */
@Controller
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;
    private EmployeeBuilder builder;
    private PaymentService paymentService;

    private static String viewPrefix = "employee/";

    @Autowired
    public EmployeeController(EmployeeService provider, EmployeeBuilder builder, PaymentService paymentService){
        this.employeeService = provider;
        this.builder = builder;
        this.paymentService = paymentService;
        logger.debug("{} created.",this.getClass());
    }

    @RequestMapping("/employee/list")
    public String listEmployees(Model model){
        logger.debug("Serving /employee/list");
        model.addAttribute("employeeList", employeeService.getAllEmployees());
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
            employeeService.updateEmployee(e);
        } else{
            employeeService.addEmployee(e);
        }
        return listEmployees(model);
    }

    @RequestMapping("/employee/edit")
    public String editEmployee(@RequestParam("id") long id, Model model){
        Employee e = employeeService.getEmployeeById(id);
        logger.debug("Giving Employee {} for edit.",e);
        model.addAttribute("employee",e);
        model.addAttribute("title","Employee");
        return viewPrefix+"employeeDetails";
    }

    @RequestMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("id") long id, Model model){
        logger.debug("Removing Employee with id {}",id);
        employeeService.fireEmployee(id);
        return listEmployees(model);
    }

    @RequestMapping("/employee")
    public String employeeDetail(@RequestParam("id") long id, Model model){
        return editEmployee(id,model);
    }

    @RequestMapping("/employee/payment")
    public String employeePaymentsList(@RequestParam("id") long id, Model model){
        if(id == 0) throw new IdException(id);
        LocalDate today = LocalDate.now();
        model.addAttribute("title","Payments");
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null) throw new NullException(Employee.class);
        logger.debug("/employee/payment Employee: {}",employee);
        model.addAttribute("employee",employee);
        logger.debug("/employee/payment Going for Payout object...");
        Payout payout = paymentService.getPayout(employee,today.getYear(),today.getMonthValue());
        if(payout == null) throw new NullException(Payout.class);
        logger.debug("/employee/payment Payout: {}",payout);
        model.addAttribute("payout",payout);
        return viewPrefix+"employeePayments";
    }
}
