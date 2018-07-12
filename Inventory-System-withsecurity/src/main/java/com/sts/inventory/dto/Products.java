package com.sts.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pId;
		
	@Column(name="product_name", nullable= false)
	private String productName;
	
	@Column(name="price", nullable= false)
	private Double price;
	
	@Column(name="weight", nullable= false)
	private Double weight;
	
	@Column(name="discription", nullable= false)
	private String discription;

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Products [pId=" + pId + ", productName=" + productName + ", price=" + price + ", weight=" + weight
				+ ", discription=" + discription + "]";
	}
	
	
	
}
