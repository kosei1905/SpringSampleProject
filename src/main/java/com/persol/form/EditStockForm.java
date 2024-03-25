package com.persol.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EditStockForm {
	
    /**
     * 在庫のIDを保持する
     * チェック内容：Nullでないこと
     */
    @NotNull(message="IDがNullになっています")
    private Integer id;
	
    /**
     * 在庫のタイトルを保持する
     * チェック内容：未入力でないこと
     */
    @NotBlank(message="タイトルを入力してください")
    private String title;
    
    @NotNull(message="個数を入力してください。")
	@Positive(message="個数はプラスの値を入力してください。")
	// 在庫の個数を保持するフィールドs
    private Integer quantity;
    
	@NotNull(message="登録日を入力してください。")
    //登録日
    private LocalDate registrationDate;
	
    /**
     * 在庫の値段を保持する
     * チェック内容：Nullでないこと、プラスであること
     */
    @NotNull(message="値段を入力してください")
    @Positive(message="値段はプラスの値を入力してください")
    private Integer price;
}
