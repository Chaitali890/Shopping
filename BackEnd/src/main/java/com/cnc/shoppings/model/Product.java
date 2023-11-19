package com.cnc.shoppings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="prodId")
	private int prodId;
	
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public String getProdImageName() {
		return prodImageName;
	}

	public void setProdImageName(String prodImageName) {
		this.prodImageName = prodImageName;
	}

	@Column(name="prodName")
	private String prodName;
	
	@Column(name="prodDesc")
	private String prodDesc;
	
	@Column(name="prodPrice")
	private int prodPrice;
	
	@Column(name="status")
	private String status;
	
	@Column(name="subCatId")
	private int subCatId;
	
	@Column(name="prodImage")
	private String prodImage;
	
	@Column(name="prodImageName")
	private String prodImageName;

	
}
