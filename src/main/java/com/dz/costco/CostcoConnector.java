package com.dz.costco;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by dz on 1/19/17.
 */
public class CostcoConnector {
    private final static String baseUrl = "https://m.costco.ca/";

    public static String getCommodityByUrl(String url) throws UnirestException {
        //TODO parse html by regex to get var products
        return Unirest.get(buildUrl(url)).asString().getBody();
    }

    public static String buildUrl(String url) {
        return baseUrl + url;
    }


}
