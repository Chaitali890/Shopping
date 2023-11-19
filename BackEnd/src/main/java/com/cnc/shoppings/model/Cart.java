package com.cnc.shoppings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="cartId")
	private int cartId;
	
	@Column(name="prodId")
	private int prodId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="status")
	private String status;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, int prodId, int userId, String status) {
		super();
		this.cartId = cartId;
		this.prodId = prodId;
		this.userId = userId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", prodId=" + prodId + ", userId=" + userId + ", status=" + status + "]";
	}

}
