package com.adaptnxt.productdetails;

import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductDetails
{

	public static void main(String[] args) 
	{
		        String url = "https://www.staples.com/Computer-office-desks/cat_CL210795/663ea?icid=BTS:2020:STUDYSPACE:DESKS";
		        ArrayList<ProductData> products = new ArrayList<>();
		        try
		         {
		            Document doc = Jsoup.connect(url).get();
		            Elements productElements = doc.select("div.sku-details");
		            for (Element productElement : productElements) {
		                String name = productElement.select("a.product-title").text();
		                String price = productElement.select("span.price").text();
		                String sku = productElement.select("div.sku").text();
		                String model = productElement.select("div.model").text();
		                String category = doc.select("div.breadcrumb").text();
		                String desc = productElement.select("div.description").text();
		                ProductData product = new ProductData(name, price, sku, model, category, desc);
		                products.add(product);
		            }
		            writeProductsToCsv(products, "product.csv");
		            
		            System.out.println("Product details have been written to product.csv file successfully.");
		        } 
		        catch (IOException e) 
		        {
		            e.printStackTrace();
		        }
		    }
		    
		    public static void writeProductsToCsv(List<ProductData> products, String filename) throws IOException
		    {
		        FileWriter csvWriter = new FileWriter(filename);
		        csvWriter.append("Product Name, Product Price, Item Number, Model Number, Product Category, Product Description\n");
		        for (ProductData product : products)
		        {
		            csvWriter.append(product.getName()).append(",");
		            csvWriter.append(product.getPrice()).append(" ");
		            csvWriter.append(product.getSku()).append(",");
		            csvWriter.append(product.getModel()).append(",");
		            csvWriter.append(product.getCategory()).append(" ");
		            csvWriter.append(product.getDesc()).append("\n");
		        }
		        csvWriter.flush();
		        csvWriter.close();
		    }

		}

		


