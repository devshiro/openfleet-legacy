package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 29..
 */
public interface TransportProvider {
    List<Transport> getAllTransports();
    void addTransport(Transport t);
    List<Transport> getTransportByEmployee(Employee e);
    Transport getTransportById(long id);
    void updateTransport(Transport t);
}
