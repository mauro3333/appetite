package com.appetite.appetite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orderx {


	@Id // Makes the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderxId;

    private Long clientId;
	private String status;



	public Orderx(Long clientId, String status) {
		this.clientId = clientId;
		this.status = status;
	}

	public Orderx() {
	}

	
	public Long getOrderxId() {
		return orderxId;
	}
	public void setOrderxId(Long orderxId) {
		this.orderxId = orderxId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}