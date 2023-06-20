package com.mosoftvn.crud_spring_mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@Column(name = "categoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	@Column(name =  "categoryName")
	private String categoryName;
	@Column(name = "categoryStatus")
	private Boolean categoryStatus;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Integer categoryId, String categoryName, Boolean categoryStatus) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryStatus = categoryStatus;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(Boolean categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	
	
}
