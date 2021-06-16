package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().mapToDouble(item -> {
			Optional<Product> product = this.productRepository.findById(item.getProductId());
			Double discount = product.get().getIsSale() ? 0.8 : 1;
			return item.getQuantity() * product.get().getValue() * discount;
		}).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.filter(id -> this.productRepository.findById(id).isPresent())
				.map(id -> this.productRepository.findById(id).get()).collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(this::calculateOrderValue).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream()
				.filter(id -> this.productRepository.findById(id).isPresent())
				.map(id -> this.productRepository.findById(id).get())
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}