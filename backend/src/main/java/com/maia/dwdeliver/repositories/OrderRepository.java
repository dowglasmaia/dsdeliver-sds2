package com.maia.dwdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maia.dwdeliver.entites.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
