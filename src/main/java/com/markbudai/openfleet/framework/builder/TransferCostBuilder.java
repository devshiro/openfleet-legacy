package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.exception.EmptyParameterException;
import com.markbudai.openfleet.model.TransferCost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.Currency;

/**
 * Class providing static method to build {@link com.markbudai.openfleet.model.TransferCost} objects.
 * Also provides static method to map {@link org.springframework.web.context.request.WebRequest} to {@link com.markbudai.openfleet.model.TransferCost}.
 */
public class TransferCostBuilder {

    private static Logger logger = LoggerFactory.getLogger(TransferCostBuilder.class);

    /**
     * Static method to build a new {@link com.markbudai.openfleet.model.TransferCost} object.
     * @param amount the payed amount.
     * @param currency the currency of the cost.
     * @param description the description of the cost.
     * @return the new {@link com.markbudai.openfleet.model.TransferCost} object with the given values.
     */
    public static TransferCost build(long amount, Currency currency, String description){
        TransferCost t = new TransferCost();
        t.setAmount(amount);
        t.setCostDescription(description);
        t.setCurrency(currency);
        return t;
    }

    /**
     * Takes the parameters from the {@link org.springframework.web.context.request.WebRequest} and parses into the new {@link com.markbudai.openfleet.model.TransferCost} object by its setter methods.
     * @param request the {@link org.springframework.web.context.request.WebRequest} containing parameters for the new {@link com.markbudai.openfleet.model.TransferCost} object.
     * @return the parsed  {@link com.markbudai.openfleet.model.TransferCost} object.
     * @exception com.markbudai.openfleet.exception.EmptyParameterException if any parameter is empty.
     */
    public static TransferCost buildFromWebRequest(WebRequest request){
        TransferCost t = new TransferCost();
        logger.trace("Starting builder.");
        logger.debug("start parsing data");
        if(request.getParameter("amount").isEmpty()){
            logger.debug(request.getParameter("amount"));
            throw new EmptyParameterException("amount");
        }
        logger.debug("amount");
        t.setAmount(Long.parseLong(request.getParameter("amount")));
        if(request.getParameter("costDescription").isEmpty()){
            throw new EmptyParameterException("costDescription");
        }
        logger.debug("costDescription");
        t.setCostDescription(request.getParameter("costDescription"));
        if(request.getParameter("currency").isEmpty()){
            throw new EmptyParameterException("currency");
        }
        logger.debug("currency");
        t.setCurrency(Currency.getInstance(request.getParameter("currency")));
        if(request.getParameter("date").isEmpty()){
            throw new EmptyParameterException("date");
        }
        logger.debug("date");
        t.setDate(LocalDate.parse(request.getParameter("date")));

        return t;
    }
}
