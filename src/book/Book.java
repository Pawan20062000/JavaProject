package book;

import patron.Patron;
import java.util.*;

//|       Book
//        +---------------------+
//        title: String
//        author: String
//        ISBN: String
//        publicationYear: int
//        isBorrowed: boolean
//        reservedBy: Patron
//        +---------------------+
//        borrowBook(): void
//        returnBook(): void
//        reserveBook(p: Patron): void
//        clearReservation(): void

public class Book extends Patron {
    private String title;
    private String author;
    private String  ISBN;
    private String publicationYear;
    private boolean isBorrowed;
    private Patron reservedBy;

    public Book(String title, String author, String ISBN, String publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.isBorrowed = false;
        this.reservedBy = null;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public Patron getReservedBy() {
        return reservedBy;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook(){
        this.isBorrowed = true;
    }
    public void returnBook(){
        this.isBorrowed = false;
    }

    public void reserveBook(Patron patron){
        this.reservedBy = patron;
    }

    public void clearReservation(){
        this.reservedBy = null;
    }
}
