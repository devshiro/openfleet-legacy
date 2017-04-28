package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.TractorProvider;
import com.markbudai.openfleet.model.Tractor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
public class TractorRepository implements TractorProvider {

    private List<Tractor> tractorList;


    public TractorRepository(){
        tractorList = new ArrayList<>();
        tractorList.add(new Tractor(1,"DAF","XF 105", LocalDate.of(2010,5,12),
                LocalDate.of(2017,02,02),LocalDate.of(2020,01,01),
                "SSS-666","aaaaaaaaaaaaaaaaa",22.5,1000,4000));
    }

    @Override
    public List<Tractor> getAllTractors() {
        return tractorList;
    }

    @Override
    public Tractor getTractorById(long id) {
        return tractorList.stream().filter(p -> p.getId() == id)
                .collect(Collectors.toList()).get(0);
    }
}
