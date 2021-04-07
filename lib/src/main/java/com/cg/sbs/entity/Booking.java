package com.cg.sbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	@GeneratedValue
	@Id
	@Column(name="orderId")
	private OrderDetails orderId;
	
	@OneToOne
	@Column(name="orderStatus")
	private String orderStatus;

	public OrderDetails getOrderId() {
		return orderId;
		}

	public void setOrderId(OrderDetails orderId) {
		this.orderId = orderId;
		}

	public String getOrderStatus() {
		return orderStatus;
		}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
		}

	}