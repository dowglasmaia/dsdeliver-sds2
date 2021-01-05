package com.maia.dwdeliver.services.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.dwdeliver.entites.Order;
import com.maia.dwdeliver.entites.Product;
import com.maia.dwdeliver.entites.dto.OrderDTO;
import com.maia.dwdeliver.entites.dto.ProductDTO;
import com.maia.dwdeliver.entites.enums.OrderStatus;
import com.maia.dwdeliver.repositories.OrderRepository;
import com.maia.dwdeliver.repositories.ProductRepository;
import com.maia.dwdeliver.services.OrderServices;

@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository prodRepository;
	
	@Override
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findAll();
		return list.stream().map(entity -> new OrderDTO(entity)).collect(Collectors.toList());
	}
	
	@Override
	public List<OrderDTO> findAllByOrderByName() {
		List<Order> list = repository.findOrderWithProductsOrderMoment();
		return list.stream().map(entity -> new OrderDTO(entity)).collect(Collectors.toList());
	}

	@Override
	public OrderDTO save(OrderDTO obj) {
		Order order = new Order(
				null,
				obj.getAddress(),
				obj.getLatitude(),
				obj.getLongitude(),
				Instant.now(),
				OrderStatus.PENDING);				
		
	/* pegando os produtos de cada pedido e salvando suas associações  */
		for(ProductDTO p : obj.getProducts()) {
			Product product = prodRepository.getOne(p.getId() ); // instancia Um Produto  com Base no DTO, sem passar pelo Banco de Dados.
			order.getProducts().add(product);			
		}	
		
		order = repository.save(order);		
		return new OrderDTO(order);
	}

}
