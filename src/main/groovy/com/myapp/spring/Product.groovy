package com.myapp.spring

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

import groovy.transform.Canonical

@Entity


class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	 Integer productId;
	
	
	@Column(name="PRODUCT_NAME",nullable = false)
	 String productName;
	
	
	@Column(name="PRODUCT_DESCRIPTION",nullable = false)
	 String description;
	
	
	@Column(name="PRODUCT_PRICE",nullable = false)
	 Double price;
	
	
	@Column(name="PRODUCT_RATING",nullable = false)
	Double starRating;
}
