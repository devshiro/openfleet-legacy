package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Trailer;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 23..
 */
public interface TrailerRepository {
    List<Trailer> getAllTrailers();

    Trailer getTrailerById(long id);

    void addTrailer(Trailer t);

    void updateTrailer(Trailer t);
}
