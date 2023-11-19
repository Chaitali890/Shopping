package com.cnc.shoppings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.shoppings.model.Stock;
import com.cnc.shoppings.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;
	
	@PostMapping("add-stock")
	public Stock addStock(@RequestBody Stock stock) {
		Stock s = stockService.addStock(stock);
		if(s!=null) {
			return s;
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("removestock/{stockId}")
		public String removeStock(@PathVariable("stockId") int stockId) {
			if(stockService.removeStock(stockId)) {
				return "success";
			}
			else
			{
				return "unsuccess";
			}
		}
		
	@GetMapping("all-stocks")
		public List<Stock> getStocks(){
			return stockService.getStocks();
		}

	@GetMapping("by-stockId/{stockId}")
		public Stock getStock(@PathVariable("stockId") int stockId) {
		return stockService.getStock(stockId);
	}
	
	}
		
	

