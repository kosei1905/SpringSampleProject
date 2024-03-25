package com.persol.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class StockForm {

    /**
     * 商品名
     */
	@NotBlank(message="タイトルを入力してください。")
    private String title;

	@NotNull(message="個数を入力してください。")
	@Positive(message="個数はプラスの値を入力してください。")
	// 在庫の個数を保持するフィールド
    private Integer quantity;
    
	
    //登録日
    private LocalDate registrationDate;
    /**
     * 在庫の値段を保持する
     */
	 @NotNull(message="値段を入力してください。")
	 @Positive(message="値段はプラスの値を入力してください。")
    private Integer price;
}