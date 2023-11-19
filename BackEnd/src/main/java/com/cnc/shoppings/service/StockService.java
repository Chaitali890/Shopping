package com.cnc.shoppings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.shoppings.model.Stock;
import com.cnc.shoppings.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public Stock addStock(Stock stock) {
		try
		{
			return stockRepository.save(stock);
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in"+e.getMessage()+"cause"+e.getCause());
		}
		return null;
	}
	
	public boolean removeStock(int stockId) {
		try
		{
			stockRepository.deleteById(stockId);
			return true;
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in"+e.getMessage()+"cause"+e.getCause());
			return false;
		}
	}
	
	public List<Stock> getStocks(){
		try
		{
			return stockRepository.findAll();
		}
		catch(Exception e)
		{
			System.err.println("Exception occured in"+e.getMessage()+"cause"+e.getCause());
		}
		return null;
	}
	
	public Stock getStock(int stockId) {	
	try
	{
		return stockRepository.findById(stockId).get();
	}
	catch(Exception e)
	{
		System.err.println("Exception occured in"+e.getMessage()+"cause"+e.getCause());
	}
	return null;
	}
	
	
}