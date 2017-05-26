package com.markbudai.openfleet.services.implementations;

import com.markbudai.openfleet.dao.repositories.TransportRepository;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.services.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 05. 10..
 */
@Service
public class TransportServiceImpl implements TransportService {

    private Logger logger = LoggerFactory.getLogger(TransportServiceImpl.class);

    private TransportRepository transportRepository;

    @Autowired
    public TransportServiceImpl(TransportRepository repository){
        this.transportRepository = repository;
        logger.trace("{} service created.",TransportServiceImpl.class);
    }

    @Override
    public List<Transport> getAllTransports() {
        List<Transport> transports = transportRepository.getAllTransports();
        logger.trace("Serving {} transports.",transports.size());
        return transports;
    }

    @Override
    public void addTransport(Transport t) {
        transportRepository.addTransport(t);
        logger.trace("Added transport {}",t);
    }

    @Override
    public List<Transport> getTransportByEmployee(Employee e) {
        List<Transport> transports = transportRepository.getAllTransports();
        transports = transports.stream().filter(p->p.getEmployee().equals(e)).collect(Collectors.toList());
        logger.trace("Serving {} transports for employee {}",transports.size(),e);
        return transports;
    }

    @Override
    public Transport getTransportById(long id){
        Transport transport = transportRepository.getTransportById(id);
        logger.trace("Serving transport {} identified by {}",transport,id);
        return transport;
    }

    @Override
    public void updateTransport(Transport t) {
        transportRepository.updateTransport(t);
        logger.trace("Transport {} updated.",t);
    }

}
