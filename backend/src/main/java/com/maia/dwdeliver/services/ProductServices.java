package com.maia.dwdeliver.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maia.dwdeliver.entites.dto.ProductDTO;

@Service
public interface ProductServices {

	List<ProductDTO>findAll();
	
	List<ProductDTO>findAllByOrderByName();
}
