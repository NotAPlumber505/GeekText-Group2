package com.bookBrowser.GeekTextBookBrowser.demo.Service;

import com.bookBrowser.GeekTextBookBrowser.demo.Entity.BookEntity;
import com.bookBrowser.GeekTextBookBrowser.demo.Repository.BookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public BookEntity saveDetails(BookEntity bookEntity) {

        return bookRepo.save(bookEntity);

    }

    public BookEntity getBookDetailsById(int bookId) {

        return bookRepo.findById(bookId).orElse(null);

    }

    public List<BookEntity> getBooksByGenre(String genre) {
        return bookRepo.findByGenre(genre);
    }

    public List<BookEntity> getTopSellingBooks() {
        return bookRepo.findTop10ByOrderBySaleQuantityDesc();
    }

    public List<BookEntity> getBooksByRating(double rating) {
        return bookRepo.findByRatingGreaterThanEqual(rating);
    }

    @Transactional
    public void applyDiscountToPublisher(double discount, String publisher) {

        List<BookEntity> books = bookRepo.findByPublisher(publisher);
        for (BookEntity book : books) {
            BigDecimal originalPrice = book.getPrice();

            // Convert discount from double to BigDecimal for proper precision
            BigDecimal discountPercentage = BigDecimal.valueOf(discount);

            // Multiply the original price by the discount percentage
            BigDecimal discountAmount = originalPrice.multiply(discountPercentage);

            // Subtract the discount from the original price to get the new price
            BigDecimal newPrice = originalPrice.subtract(discountAmount);

            // Set the new price for the book
            book.setPrice(newPrice);

            // Save the updated book in the database
            bookRepo.save(book);
        }

    }

}
