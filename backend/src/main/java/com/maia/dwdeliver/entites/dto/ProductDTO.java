package com.maia.dwdeliver.entites.dto;

import java.io.Serializable;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.maia.dwdeliver.entites.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private String imageUri;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private Double price;

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Long id, String name, String description, String imageUri, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUri = imageUri;
		this.price = price;
	}

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.imageUri = entity.getImageUri();
		this.price = entity.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
