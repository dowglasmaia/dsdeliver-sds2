package com.maia.dwdeliver.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.maia.dwdeliver.entites.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_order_product", 
			   joinColumns = @JoinColumn(name = "order_id"),  			// referencia na tabela present
			   inverseJoinColumns = @JoinColumn(name = "product_id")) 	// referencia a tabela  da coleção "Product"
	private Set<Product> products = new HashSet<>();

}
