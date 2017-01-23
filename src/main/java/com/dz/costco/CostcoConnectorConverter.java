package com.dz.costco;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dz on 1/22/17.
 */
public class CostcoConnectorConverter {

    private static final String IMG_URL = "img_url";
    private static final String INVENTARY = "inventory";
    private static final String LISTPRICE = "listPrice";
    private static final String PRICE = "price";
    private static final String PRODUCT = "productName";
    private static final String PRODUCTURL = "productUrl";

    public static Commodity convertHtmlIntoComodity(String html) throws CostcoConnectorConverterException {
        String pattern = "var products = (.*?);\\n";
        Pattern r = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher m = r.matcher(html);
        Commodity result = null;
        if (m.find()) {
            try {
                JsonParser jsonParser = JsonParserFactory.getJsonParser();
                List<Object> objects = jsonParser.parseList(m.group(1));
                Map json = (Map) ((List) objects.get(0)).get(0);
                result = buildComodityFromMap(json);
            } catch (Exception e) {
                throw new CostcoConnectorConverterException("var products structure changed in commodity html");
            }
        } else {
            throw new CostcoConnectorConverterException("var products dont exist in the commodity html");
        }
        return result;
    }

    private static Commodity buildComodityFromMap(Map json) {
        Commodity result;
        result = new Commodity();
        result.setImageUrl((String) json.get(IMG_URL));
        result.setInventory((String) json.get(INVENTARY));
        result.setProductName((String) json.get(PRODUCT));
        result.setProductUrl((String) json.get(PRODUCTURL));
        return result;
    }
}
