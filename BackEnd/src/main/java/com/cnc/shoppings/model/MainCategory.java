package com.cnc.shoppings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MainCategory")
public class MainCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="mainCatId")
	private int mainCatId;
	
	@Column(name="mainCatName")
	private String mainCatName;
	
	@Column(name="mainCatDesc")
	private String mainCatDesc;
	
	@Column(name="status")
	private String status;

	public int getMainCatId() {
		return mainCatId;
	}

	public void setMainCatId(int mainCatId) {
		this.mainCatId = mainCatId;
	}

	public String getMainCatName() {
		return mainCatName;
	}

	public void setMainCatName(String mainCatName) {
		this.mainCatName = mainCatName;
	}

	public String getMainCatDesc() {
		return mainCatDesc;
	}

	public void setMainCatDesc(String mainCatDesc) {
		this.mainCatDesc = mainCatDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
