package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Trailer;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * Interface describing operations to manage {@link com.markbudai.openfleet.model.Trailer} objects.
 */
public interface TrailerService {

    /**
     * Retrieves all {@link com.markbudai.openfleet.model.Trailer} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository}.
     * @return a {@link java.util.List} of all {@link com.markbudai.openfleet.model.Trailer} objects.
     */
    List<Trailer> getAllTrailers();

    /**
     * Gets a {@link com.markbudai.openfleet.model.Trailer} object with corresponding {@code id}.
     * @param id the {@code id} of the required {@link com.markbudai.openfleet.model.Trailer} object.
     * @return the {@link com.markbudai.openfleet.model.Trailer} object with corresponding {@code id}.
     */
    Trailer getTrailerById(long id);

    /**
     * Passes a {@link com.markbudai.openfleet.model.Trailer} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     * @param trailer the {@link com.markbudai.openfleet.model.Trailer} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     */
    void addTrailer(Trailer trailer);

    /**
     * Passes a {@link com.markbudai.openfleet.model.Trailer} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     * @param trailer the {@link com.markbudai.openfleet.model.Trailer} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     */
    void updateTrailer(Trailer trailer);

    /**
     * Sets the {@link com.markbudai.openfleet.model.Trailer} object with corresponding {@code id} as sold.
     * The sell date will be today.
     * @param id of the {@link com.markbudai.openfleet.model.Trailer} object which needs to be sold.
     */
    void sellTrailer(long id);

    /**
     * Creates a {@link java.util.List} of {@link com.markbudai.openfleet.pojo.SupervisionDetails} about the stored {@link com.markbudai.openfleet.model.Trailer}s.
     * A given tractor will be on the list if the next supervision is due in 30 days.
     * @return the {@link java.util.List} of {@link com.markbudai.openfleet.pojo.SupervisionDetails} about the stored {@link com.markbudai.openfleet.model.Trailer}s.
     */
    List<SupervisionDetails> getSupervisionList();

    /**
     * Parses a {@link org.springframework.web.context.request.WebRequest} object to build a {@link com.markbudai.openfleet.model.Trailer} object for update or add operation.
     * @param request the {@link org.springframework.web.context.request.WebRequest} to build from.
     */
    void addOrUpdate(WebRequest request);
}
