package com.maia.dwdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maia.dwdeliver.entites.dto.OrderDTO;
import com.maia.dwdeliver.services.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderServices services;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>>findAll(){
			List<OrderDTO>list = services.findAllByOrderByName();
		return ResponseEntity.ok().body(list);
		
	}

}
