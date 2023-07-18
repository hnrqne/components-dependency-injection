package com.hnrqne.componentsdependencyinjection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnrqne.componentsdependencyinjection.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		
		return order.getBasic() - (order.getBasic() / 100 * order.getDiscount()) + shippingService.shipment(order);
	}
}
