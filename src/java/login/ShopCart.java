/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import be.bt.model.Book;
import beans.BookBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rome10
 */
public class ShopCart {
    private List<BookBean> bookList = new ArrayList<BookBean>();
    private int totalPrice;
    
    public void addBook(BookBean b) {
        bookList.add(b);
        incrementPrice(b);
    }
    
    public void removeBook(BookBean b) {
        decrementPrice(b);
        bookList.remove(b);
    }
    
    public void clearCart() {
        bookList.clear();
        totalPrice = 0;
    }
    
    public int getTotalPrice() {
        int total = 0;
        for (BookBean b : bookList) {
            total += b.getPrice();
        }
        return total;
    }
    
    public void incrementPrice(BookBean b) {
        totalPrice += b.getPrice();
    }
    
    public void decrementPrice(BookBean b) {
        totalPrice -= b.getPrice();
    }
    
    public List<BookBean> getList() {
        return bookList;
    }
}
