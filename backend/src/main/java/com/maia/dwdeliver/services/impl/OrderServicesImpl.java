package com.maia.dwdeliver.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.dwdeliver.entites.Order;
import com.maia.dwdeliver.entites.Product;
import com.maia.dwdeliver.entites.dto.OrderDTO;
import com.maia.dwdeliver.repositories.OrderRepository;
import com.maia.dwdeliver.services.OrderServices;

@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	@Override
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findAll();

		return list.stream().map(entity -> new OrderDTO(entity)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<OrderDTO> findAllByOrderByName() {
		List<Order> list = repository.findOrderWithProductsOrderMoment();
		return list.stream().map(entity -> new OrderDTO(entity)).collect(Collectors.toList());
	}

}
