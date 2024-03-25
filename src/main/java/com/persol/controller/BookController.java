package com.persol.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.persol.bean.Stock;
import com.persol.form.EditStockForm;
import com.persol.form.StockForm;
import com.persol.service.StockService;


@Controller
public class BookController {
	
    StockService service;

    BookController(StockService service) {
        this.service = service;
    }
	
    @GetMapping("/stock-list")
    public String bookList(Model model) {
		
        // serviceを使って、在庫の一覧をDBから取得する
        List<Stock> stockList = service.findAll();
        // modelに在庫の一覧を設定して、画面に渡す
        model.addAttribute("stockList", stockList);
        // bookList.htmlの表示
        return "bookList";
    }
	
    /**
     * 新規登録画面を表示
     * @param model
     * @return 新規登録画面
     */
    @GetMapping("/stock-create")
    public String createBook(Model model) {

        model.addAttribute("stockForm", new StockForm());
		
        return "add";
    }
	
    /**
     * データベースに在庫を登録する
     * @param bookForm
     * @param model
     * @return
     */
    @PostMapping("/stock-create")
    public String saveBook(@ModelAttribute @Validated StockForm stockForm, BindingResult result,Model model) {
    	
    	// バリデーションエラーの場合
    	if (result.hasErrors()) {
    		// 新規登録画面に遷移
    		return "add";
    	}

        // 在庫を登録する
        service.insert(stockForm);

        // 在庫の一覧表示画面にリダイレクト
        return "redirect:/stock-list";
    }
    
 // 編集画面を表示する
    @GetMapping("/stock-edit")
    public String editBook(Model model, EditStockForm editBook) {
		
        editBook = service.getOneStock(editBook.getId());
        model.addAttribute(editBook);
		
        return "edit";
    }
	
    // 在庫の情報を更新する
    @PostMapping("/stock-edit")
    public String update(@ModelAttribute @Validated EditStockForm editStockForm, BindingResult result,Model model) {
		
        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 編集画面に遷移
            return "edit";
        }
		
        // 在庫を更新する
        service.update(editStockForm);
		
        // 在庫の一覧画面にリダイレクト
        return "redirect:/stock-list";
    }
    
    // 在庫の削除を行う
    @GetMapping("/stock-delete")
    public String deleteBook(Model model, Stock Book) {

        // データベースのデータを削除する
        service.delete(Book.getId());

        // 在庫の一覧画面にリダイレクト
        return "redirect:/stock-list";
		
    }
}