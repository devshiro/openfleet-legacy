package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.model.Trailer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
public class TrailerRepository implements TrailerProvider{

    private List<Trailer> trailerList;

    public TrailerRepository(){
        trailerList = new ArrayList<>();
        Trailer trailer = new Trailer(1,"Cassbohrer","TT52", LocalDate.of(2010,5,12),
                LocalDate.of(2017,02,02),LocalDate.of(2020,01,01),
                "SSS-444","aaaaaaaaaaaaaaaaa",1000,4000);
        trailerList.add(trailer);
        Trailer t2 = new Trailer(2,"Berger","ecotrail LTN",LocalDate.of(2016,5,10),
                LocalDate.of(2017,03,03),LocalDate.of(2020,05,01),
                "XXF-432","AXG45700002A2F341",4745,39000);
        trailerList.add(t2);
        Trailer t3 = new Trailer(3,"Bodex","64t",LocalDate.of(2016,9,12),
                LocalDate.of(2017,03,03),LocalDate.of(2020,9,01),
                "HGF-707","CXG45700032A2F541",5635,64000);
        trailerList.add(t3);
    }

    @Override
    public List<Trailer> getAllTrailers() {
        return trailerList;
    }

    @Override
    public Trailer getTrailerById(long id) {
        return trailerList.stream().filter(p -> p.getId() == id)
                .collect(Collectors.toList()).get(0);
    }
}
