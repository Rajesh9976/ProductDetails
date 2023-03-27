package com.adaptnxt.productdetails;

public class ProductData 
{
	    private String name;
	    private String price;
	    private String sku;
	    private String model;
	    private String category;
	    private String desc;
	    
	    public ProductData(String name, String price, String sku, String model, String category, String desc)
	    {
	        this.name = name;
	        this.price = price;
	        this.sku = sku;
	        this.model = model;
	        this.category = category;
	        this.desc = desc;
	    }

	    public String getName()
	    {
	        return name;
	    }

	    public String getPrice() 
	    {
	        return price;
	    }

	    public String getSku() 
	    {
	        return sku;
	    }

	    public String getModel() 
	    {
	        return model;
	    }

	    public String getCategory() 
	    {
	        return category;
	    }

	    public String getDesc() 
	    {
	        return desc;
	    }
	


	}

