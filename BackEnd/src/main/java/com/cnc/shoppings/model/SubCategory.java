package com.cnc.shoppings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="SubCategory")
public class SubCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="subCatId")
	private int subCatId;
	
	@Column(name="subCatName")
	private String subCatName;
	
	@Column(name="subCatDesc")
	private String subCatDesc;
	
	@Lob
	@Column(name="subCatImage")
	private String subCatImage;
	
	@Column(name="subCatImageName")
	private String subCatImageName;
	
	@Column(name="catId")
	private int catId;
	
	@Column(name="status")
	private String status;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getSubCatDesc() {
		return subCatDesc;
	}

	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}

	public String getSubCatImage() {
		return subCatImage;
	}

	public void setSubCatImage(String subCatImage) {
		this.subCatImage = subCatImage;
	}

	public String getSubCatImageName() {
		return subCatImageName;
	}

	public void setSubCatImageName(String subCatImageName) {
		this.subCatImageName = subCatImageName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
