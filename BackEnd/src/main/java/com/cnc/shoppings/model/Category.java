package com.cnc.shoppings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="catId")
	private int catId;
	
	@Column(name="catName")
	private String catName;
	
	@Column(name="catDesc")
	private String catDesc;
	
	@Column(name="status")
	private String status;

	@Column(name="mainCatId")
	private int mainCatId;
	
	@Lob
	@Column(name="catImage")
	private String catImage;
	
	@Column(name="catImageName")
	private String catImageName;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMainCatId() {
		return mainCatId;
	}

	public void setMainCatId(int mainCatId) {
		this.mainCatId = mainCatId;
	}

	public String getCatImage() {
		return catImage;
	}

	public void setCatImage(String catImage) {
		this.catImage = catImage;
	}

	public String getCatImageName() {
		return catImageName;
	}

	public void setCatImageName(String catImageName) {
		this.catImageName = catImageName;
	}
	
}
