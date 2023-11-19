package com.cnc.shoppings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Stock")
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="stockId")
	private int stockId;
	
	@Column(name="prodId")
	private int prodId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalSold")
	private int totalSold;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(int totalSold) {
		this.totalSold = totalSold;
	}
}
