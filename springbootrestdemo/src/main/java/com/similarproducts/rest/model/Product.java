package com.similarproducts.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Product {

    public Product() {

    }

 
    public Product(String id, String name, Integer price, Boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.availability = availability;
	}


	private String id;
    private String name;
    private Integer price;
    private Boolean availability;
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Boolean getAvailability() {
		return availability;
	}


	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", availability=" + availability + "]";
	}


}
