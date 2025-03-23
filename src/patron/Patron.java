package patron;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.List;

//Patron
//  +--------------------+
//    name: String
//    id: String
//    borrowedBooks: List<String>
//  +---------------------+
//    borrowBook(ISBN: String): void
//    returnBook(ISBN: String): void

public class Patron {
    private String name;
    private String id;
    private List<String> borrowedBooks;
    public Patron(String name, String id){
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public Patron() {
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void borrowBook(String ISBN){
        borrowedBooks.add(ISBN);
    }
    public void returnBook(String ISBN){
        borrowedBooks.remove(ISBN);
    }
}