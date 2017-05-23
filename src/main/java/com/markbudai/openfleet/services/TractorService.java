package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.pojo.SupervisionDetails;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
public interface TractorService {
    List<Tractor> getAllTractors();
    Tractor getTractorById(long id);
    void addTractor(Tractor tractor);
    void updateTractor(Tractor tractor);
    void sellTractor(long id);
    List<SupervisionDetails> getSupervisionList();
}
