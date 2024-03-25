package com.persol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persol.bean.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

}
