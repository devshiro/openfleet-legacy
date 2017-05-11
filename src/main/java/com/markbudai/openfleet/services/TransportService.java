package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.TransportProvider;
import com.markbudai.openfleet.dao.repositories.TransportRepository;
import com.markbudai.openfleet.model.Transport;
import org.omg.PortableInterceptor.TRANSPORT_RETRY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 10..
 */
@Service
@Component
public class TransportService implements TransportProvider{

    private TransportRepository transportRepository;

    @Autowired
    public TransportService(TransportRepository repository){
        this.transportRepository = repository;
    }

    @Override
    public List<Transport> getAllTransports() {
        return transportRepository.getAllTransports();
    }

    @Override
    public void addTransport(Transport t) {
        transportRepository.addTransport(t);
    }
}
