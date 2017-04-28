package com.markbudai.openfleet.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

/**
 * Created by Mark on 2017. 04. 13..
 */
public class MNBExchangeService implements ExchangeService {

    private Logger logger = LoggerFactory.getLogger(MNBExchangeService.class);

    private mnb.MNBArfolyamServiceSoap service;
    private Document exchangeRates;


    //constructors
    public MNBExchangeService(){
        mnb.MNBArfolyamServiceSoapImpl impl = new mnb.MNBArfolyamServiceSoapImpl();
        this.service = impl.getCustomBindingMNBArfolyamServiceSoap();
        generateExchangeRates();
    }

    public MNBExchangeService(mnb.MNBArfolyamServiceSoapImpl impl){
        this.service = impl.getCustomBindingMNBArfolyamServiceSoap();
        generateExchangeRates();
    }

    public MNBExchangeService(mnb.MNBArfolyamServiceSoap soap){
        this.service = soap;
        generateExchangeRates();
    }

    //private methods
    private void generateExchangeRates(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.exchangeRates = builder.parse(new InputSource(new StringReader(this.service.getCurrentExchangeRates())));
            this.exchangeRates.getDocumentElement().normalize();
        } catch(Exception e)
        {
            logger.error(e.toString());
        }

    }

    private BigDecimal exchangeToHUF(Currency from, BigDecimal amount){
        double rate = this.getExchangeRateForCurrency(from);
        return amount.multiply(new BigDecimal(rate));
    }

    @Override
    public double getExchangeRateForCurrency(Currency currency) {
        logger.trace(currency.getCurrencyCode());
        NodeList list = this.exchangeRates.getElementsByTagName("Rate");
        for(int i=0;i<list.getLength();i++)
        {
            Node n = list.item(i);
            if(n.getNodeType() == Node.ELEMENT_NODE)
            {
                Element e = (Element) n;
                logger.trace(e.getAttribute("curr") + ": " + Double.parseDouble(e.getTextContent().replace(",",".")) / Double.parseDouble(e.getAttribute("unit")));
                if(e.getAttribute("curr").equals(currency.getCurrencyCode())){
                    return Double.parseDouble(e.getTextContent().replace(",",".")) / Double.parseDouble(e.getAttribute("unit"));
                }
            }
        }
        return -1.0;
    }

    @Override
    public BigDecimal exchange(Currency from, BigDecimal amount, Currency to) {
        if(to.getCurrencyCode().equals("HUF"))
            return this.exchangeToHUF(from,amount);
        BigDecimal amountInHUF = this.exchangeToHUF(from,amount);
        BigDecimal rate = new BigDecimal(this.getExchangeRateForCurrency(to));
        return amountInHUF.divide(rate, MathContext.DECIMAL64);
    }
}