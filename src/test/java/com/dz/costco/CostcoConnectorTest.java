package com.dz.costco;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dz on 1/22/17.
 */
public class CostcoConnectorTest {

    @Test
    public void givenCommodityNameWhenUsingConnectorThenReturnHtmlContainsProdcutInfor() throws UnirestException {
        CostcoConnector costcoConnector = new CostcoConnector();
        String name = "MacroLife®-Naturals-–-Macro-Coco-Greens®-64-Powder-servings.product.100307079.html";
        String result = costcoConnector.getCommodityByUrl(name);
        assertTrue(result.contains(CostcoConnectorConst.productTag));
    }

}