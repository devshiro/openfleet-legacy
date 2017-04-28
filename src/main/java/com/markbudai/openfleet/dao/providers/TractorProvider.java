package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.Tractor;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
public interface TractorProvider {
    List<Tractor> getAllTractors();
    Tractor getTractorById(long id);
}
