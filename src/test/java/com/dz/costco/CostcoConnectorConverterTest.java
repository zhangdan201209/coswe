package com.dz.costco;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * Created by dz on 1/22/17.
 */
public class CostcoConnectorConverterTest {

    @Test
    public void givenHtmlWhenConvertThenConvertToRightCommodity() throws UnirestException, CostcoConnectorConverterException {
        String html = CostcoConnector.getCommodityByUrl("MacroLife®-Naturals-–-Macro-Coco-Greens®-64-Powder-servings.product.100307079.html");
        Commodity commodity = CostcoConnectorConverter.convertHtmlIntoComodity(html);
        System.out.println(commodity.toString());
    }
}