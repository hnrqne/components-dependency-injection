package com.hnrqne.componentsdependencyinjection;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hnrqne.componentsdependencyinjection.entities.Order;
import com.hnrqne.componentsdependencyinjection.services.OrderService;

@SpringBootApplication
public class ComponentsDependencyInjectionApplication implements CommandLineRunner {
	
	@Autowired 
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(ComponentsDependencyInjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Order> list = new ArrayList<>();
		
		System.out.print("Hi, what will be the order quantity? ");
		
		int n = sc.nextInt();
		System.out.println();
		System.out.println("***** ORDER DATA *****");
		
		for (int i = 1; i <= n; i++) {
			System.out.print("Code: ");
			Integer code = sc.nextInt();
			System.out.print("Basic value: ");
			Double basicValue = sc.nextDouble();
			System.out.print("Discount percentage: ");
			Double discountPercentage = sc.nextDouble();
			System.out.println();
			
			Order order = new Order(code, basicValue, discountPercentage);
			list.add(order);
		}
		
		System.out.println();
		System.out.println("***** OUTPUT OF ORDERS *****");
		for(Order c : list) {
			System.out.println("Request code: " + c.getCode() 
				+ "\n" + "Total value: R$ " + String.format("%.2f", orderService.total(c)));
			System.out.println();
		}
		
		sc.close();
	}
}
