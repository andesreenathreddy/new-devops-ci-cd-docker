package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devopsproducts")
public class Product {
	
	
	@Id
	@Column(name = "product_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Column(name = "product_name",nullable = false)
	private String productName;
	
	
	@Column(name = "product_description",nullable = false)
	private String description;
	
	@Column(name = "product_price",nullable = false)
	private Double price;
	
	@Column(name = "product_rating",nullable = false)
	private Double starRating;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String productName, String description, Double price, Double starRating) {
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.starRating = starRating;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getStarRating() {
		return starRating;
	}


	public void setStarRating(Double starRating) {
		this.starRating = starRating;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, price, productId, productName, starRating);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(price, other.price)
				&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
				&& Objects.equals(starRating, other.starRating);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", starRating=");
		builder.append(starRating);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
