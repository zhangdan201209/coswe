package com.dz.costco;

import lombok.Data;

/**
 * Created by dz on 1/19/17.
 */
@Data
public class Commodity {
    private String inventory;
    private String productUrl;
    private String imageUrl;
    private float price;
    private String productName;
}
