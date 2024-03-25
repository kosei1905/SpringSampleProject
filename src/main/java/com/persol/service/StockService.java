package com.persol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persol.bean.Stock;
import com.persol.form.EditStockForm;
import com.persol.form.StockForm;
import com.persol.repository.StockRepository;

@Service
@Transactional
public class StockService {
	
    @Autowired
    StockRepository repository;
	
  
    /**
     * データベースから本の一覧を取得する
     * @return
     */
    public List<Stock> findAll() {
        return repository.findAll();
    }
    
    /**
     * データベースにデータを登録する
     * @return
     */
    public void insert(StockForm stockForm) {
        // データベースに登録する値を保持するインスタンス
        Stock stock = new Stock();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        stock.setTitle(stockForm.getTitle());
        stock.setQuantity(stockForm.getQuantity());
        stock.setPrice(stockForm.getPrice());
        stock.setRegistrationDate(stockForm.getRegistrationDate());

        // データベースに登録する
        repository.save(stock);
    }
    
 // 受け取ったidからデータを取得して、Formを返却する
    public EditStockForm getOneStock(Integer id) {
		
        // idを指定して本の情報を取得する
        Stock stock = repository.findById(id).orElseThrow();
		
        // 画面返却用のFormに値を設定する
        EditStockForm editstock = new EditStockForm();
        editstock.setId(stock.getId());
        editstock.setTitle(stock.getTitle());
        editstock.setQuantity(stock.getQuantity());
        editstock.setPrice(stock.getPrice());
        editstock.setRegistrationDate(stock.getRegistrationDate());
		
        return editstock;
    }
	
    // 在庫を更新する
    public void update(EditStockForm editstock) {
		
        // データベースに登録する値を保持するインスタンスの作成
        Stock stock = new Stock();
		
        // 画面から受け取った値を設定する
        stock.setId(editstock.getId());
        stock.setTitle(editstock.getTitle());
        stock.setQuantity(editstock.getQuantity());
        stock.setPrice(editstock.getPrice());
        stock.setRegistrationDate(editstock.getRegistrationDate());
		
        // データベースを更新する
        repository.save(stock);
    }
    // 在庫を削除する
    public void delete(Integer id) {

    // idを指定して、データベースからデータを削除する
     repository.deleteById(id);
    }
    
}