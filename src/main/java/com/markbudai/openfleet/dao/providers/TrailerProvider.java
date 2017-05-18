package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.Trailer;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
public interface TrailerProvider {
    List<Trailer> getAllTrailers();
    Trailer getTrailerById(long id);
    void addTrailer(Trailer trailer);
    void updateTrailer(Trailer trailer);
    void sellTrailer(long id);
    List<SupervisionDetails> getSupervisionList();
    void addOrUpdate(WebRequest request);
}
