package com.cnc.shoppings.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Delivery")
public class Delivery {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="deliveryId")
	private int deliveryId;
	
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="deliveryDate")
	private Date deliveryDate;
	
	@Column(name="status")
	private String status;

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
