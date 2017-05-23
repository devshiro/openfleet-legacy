package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Transport;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 23..
 */
public interface TransportRepository {
    List<Transport> getAllTransports();

    void addTransport(Transport t);

    void updateTransport(Transport t);

    Transport getTransportById(long id);
}
