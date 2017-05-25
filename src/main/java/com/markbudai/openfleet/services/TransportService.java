package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Mark on 2017. 04. 29..
 */
public interface TransportService {
    List<Transport> getAllTransports();
    void addTransport(Transport t);
    List<Transport> getTransportByEmployee(Employee e);
    Transport getTransportById(long id);
    void updateTransport(Transport t);
}
