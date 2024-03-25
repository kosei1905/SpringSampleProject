package com.persol.bean;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "stockinfo")
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    // 在庫のidを保持するフィールド
    private Integer id;
	
    @Column(name="title")
    // 在庫の商品を保持するフィールド
    private String title;
	
    // 在庫の個数を保持するフィールド
    @Column(name="quantity")
    private Integer quantity;
    
    //登録日
    @Column(name="registration_date")
    private LocalDate registrationDate;
	
    // 在庫の値段を保持するフィールド
    @Column(name="price")
    private Integer price;
}
