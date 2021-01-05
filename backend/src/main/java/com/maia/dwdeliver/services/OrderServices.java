package com.maia.dwdeliver.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.dwdeliver.entites.dto.OrderDTO;

@Service
public interface OrderServices {

	@Transactional(readOnly = true)
	List<OrderDTO>findAll();
	
	@Transactional(readOnly = true)
	List<OrderDTO>findAllByOrderByName();
	
	@Transactional
	OrderDTO save(OrderDTO obj);
	
	@Transactional
	OrderDTO setDelivered(Long id);
}
