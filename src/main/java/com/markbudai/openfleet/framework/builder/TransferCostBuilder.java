package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.model.TransferCost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.Currency;

/**
 * Created by Mark on 2017. 05. 09..
 */
public class TransferCostBuilder {

    private static Logger logger = LoggerFactory.getLogger(TransferCostBuilder.class);

    public static TransferCost build(long amount, Currency currency, String description){
        TransferCost t = new TransferCost();
        t.setAmount(amount);
        t.setCostDescription(description);
        t.setCurrency(currency);
        return t;
    }

    public static TransferCost buildFromWebRequest(WebRequest request){
        TransferCost t = new TransferCost();
        logger.trace("Starting builder.");
        logger.debug("start parsing data");
        if(request.getParameter("amount").isEmpty()){
            logger.debug(request.getParameter("amount"));
            return null;
        }
        logger.debug("amount");
        t.setAmount(Long.parseLong(request.getParameter("amount")));
        if(request.getParameter("costDescription").isEmpty()){
            return null;
        }
        logger.debug("costDescription");
        t.setCostDescription(request.getParameter("costDescription"));
        if(request.getParameter("currency").isEmpty()){
            return null;
        }
        logger.debug("currency");
        t.setCurrency(Currency.getInstance(request.getParameter("currency")));
        if(request.getParameter("date").isEmpty()){
            return null;
        }
        logger.debug("date");
        t.setDate(LocalDate.parse(request.getParameter("date")));

        return t;
    }
}
