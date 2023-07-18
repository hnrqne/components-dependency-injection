package com.hnrqne.componentsdependencyinjection.services;

import org.springframework.stereotype.Service;

import com.hnrqne.componentsdependencyinjection.entities.Order;

@Service
public class ShippingService {
	
	private static final double FREIGHT_UNDER_100 = 20.00;
    private static final double FREIGHT_BETWEEN_100_AND_200 = 12.00;
    private static final double FREIGHT_200_OR_MORE = 0.00;
    private static final double LIMIT_100 = 100.00;
    private static final double LIMIT_200 = 200.00;
	
	public double shipment(Order order) {
		if (order.getBasic() < LIMIT_100) {
			return FREIGHT_UNDER_100;
		} else if (order.getBasic() < LIMIT_200) {
			return FREIGHT_BETWEEN_100_AND_200;
		}
		return FREIGHT_200_OR_MORE;
	}
}
