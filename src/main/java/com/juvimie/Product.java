package com.juvimie;

public class Product 
{
    private int productId;
    private String productName;
    private Double productPrize;
    private int quantity;
    private String productType;
    private String productOrigin;

    public Product(int productId, String productName, Double productPrize, int quantity, String productType, String productOrigin)
    {
        this.productId = productId;
        this.productName = productName;
        this.productPrize = productPrize;
        this.quantity = quantity;
        this.productType = productType;
        this.productOrigin = productOrigin;
    }

    public String getProductName()
    {
        return productName;
    }

    public Double getProductPrize()
    {
        return productPrize;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getProductOrigin()
    {
        return productOrigin;
    }

}
