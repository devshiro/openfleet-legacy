package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Tractor;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 23..
 */
public interface TractorRepository {
    List<Tractor> getAllTractors();

    Tractor getTractorById(long id);

    void addTractor(Tractor t);

    void updateTractor(Tractor t);
}
