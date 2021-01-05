package com.maia.dwdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maia.dwdeliver.entites.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	/* Retorna os Pedidos com seus Produtos em Order , do mais Antigo ao mais Novo*/
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
			+ "WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order>findOrderWithProductsOrderMoment(); 
}
