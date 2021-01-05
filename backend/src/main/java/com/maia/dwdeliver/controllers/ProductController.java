package com.maia.dwdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maia.dwdeliver.entites.dto.ProductDTO;
import com.maia.dwdeliver.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductServices services;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>>findAll(){
			List<ProductDTO>list = services.findAllByOrderByName();
		return ResponseEntity.ok().body(list);
		
	}

}
