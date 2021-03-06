package com.maia.dwdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<OrderDTO>insert(@RequestBody OrderDTO obj){
		obj = services.save(obj);
		
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO>setdelivered(@PathVariable Long id){
		OrderDTO dto = services.setDelivered(id);		
		return ResponseEntity.ok().body(dto);
	}


}
