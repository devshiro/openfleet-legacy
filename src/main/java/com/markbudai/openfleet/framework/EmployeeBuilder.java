package com.markbudai.openfleet.framework;

import com.markbudai.openfleet.model.Employee;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Field;
import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 04..
 */
public class EmployeeBuilder {
    public static Employee build(WebRequest request){
        Employee e = new Employee();
        e.setFirstName(request.getParameter("firstName"));
        e.setLastName(request.getParameter("lastName"));
        e.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
        //e.setPlaceOfBirth(Long.parseLong(request.getParameter("palceOfBirth")));
        return null;
    }


    public static void main(String[] args){
        build(null);
    }
}
