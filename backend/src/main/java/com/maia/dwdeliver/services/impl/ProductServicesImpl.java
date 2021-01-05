package com.maia.dwdeliver.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.dwdeliver.entites.Product;
import com.maia.dwdeliver.entites.dto.ProductDTO;
import com.maia.dwdeliver.repositories.ProductRepository;
import com.maia.dwdeliver.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	@Override
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAll();

		return list.stream().map(entity -> new ProductDTO(entity)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductDTO> findAllByOrderByName() {
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(entity -> new ProductDTO(entity)).collect(Collectors.toList());
	}

}
