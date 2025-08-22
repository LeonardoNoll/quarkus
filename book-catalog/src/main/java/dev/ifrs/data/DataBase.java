package dev.ifrs.data;

import java.util.ArrayList;
import java.util.List;

import dev.ifrs.model.Book;
import jakarta.inject.Singleton;

@Singleton
public class DataBase {
    private List<Book> books;

    public DataBase() {
        this.books = new ArrayList<>();
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "9780345391803", false));
        books.add(new Book("1984", "George Orwell", "9780451524935", false));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", false));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", false));
    }

    public List<Book> getBooks() {
        return books;
    }
}
