package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import java.util.List;

/**
 * Interface for managing {@link com.markbudai.openfleet.model.Transport} objects.
 */
public interface TransportService {

    /**
     * Retrieves all {@link com.markbudai.openfleet.model.Transport} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository}.
     * @return a {@link java.util.List} of all {@link com.markbudai.openfleet.model.Transport} objects.
     */
    List<Transport> getAllTransports();

    /**
     * Passes a {@link com.markbudai.openfleet.model.Transport} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     * @param t the {@link com.markbudai.openfleet.model.Transport} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     */
    void addTransport(Transport t);

    /**
     * Retrieves all {@link com.markbudai.openfleet.model.Transport}s which was done by given {@link com.markbudai.openfleet.model.Employee}.
     * @param e the {@link com.markbudai.openfleet.model.Employee} who did the transpors.
     * @return {@link java.util.List} of all {@link com.markbudai.openfleet.model.Transport} done by given {@link com.markbudai.openfleet.model.Employee}.
     */
    List<Transport> getTransportByEmployee(Employee e);

    /**
     * Gets a {@link com.markbudai.openfleet.model.Transport} object with corresponding {@code id}.
     * @param id the {@code id} of the required {@link com.markbudai.openfleet.model.Transport} object.
     * @return the {@link com.markbudai.openfleet.model.Transport} object with corresponding {@code id}.
     */
    Transport getTransportById(long id);

    /**
     * Passes a {@link com.markbudai.openfleet.model.Transport} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     * @param t the {@link com.markbudai.openfleet.model.Transport} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     */
    void updateTransport(Transport t);
}
