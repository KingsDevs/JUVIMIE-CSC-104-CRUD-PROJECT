package com.juvimie;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public Product(String productName, Double productPrize, int quantity, String productType, String productOrigin)
    {
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

    public static ResultSet getProductTypes() throws SQLException, IOException
    {
        String sql = "SELECT * FROM type_of_product";

        Statement statement = ConnSqlite.getStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    public static ResultSet getCountries() throws SQLException, IOException
    {
        String sql = "SELECT * FROM countries";

        Statement statement = ConnSqlite.getStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

}
