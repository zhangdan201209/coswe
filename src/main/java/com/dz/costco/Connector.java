package com.dz.costco;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by dz on 1/19/17.
 */
public class Connector {
    private final static String baseUrl = "https://m.costco.ca/";

    public String getCommodityByUrl(String url) throws UnirestException {
        //TODO parse html by regex to get var products
        return Unirest.get(buildUrl(url)).asString().getBody();
    }

    public String buildUrl(String url) {
        return baseUrl + url;
    }



    public static void main(String[] args) throws UnirestException {
        System.out.print("SS");
        Connector connector = new Connector();
        System.out.print(connector.getCommodityByUrl("MacroLife®-Naturals-–-Macro-Coco-Greens®-64-Powder-servings.product.100307079.html"));
    }
}
