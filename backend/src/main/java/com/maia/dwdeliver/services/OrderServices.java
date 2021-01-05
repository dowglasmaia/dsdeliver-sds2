package com.maia.dwdeliver.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maia.dwdeliver.entites.dto.OrderDTO;

@Service
public interface OrderServices {

	List<OrderDTO>findAll();
	
	List<OrderDTO>findAllByOrderByName();
}
