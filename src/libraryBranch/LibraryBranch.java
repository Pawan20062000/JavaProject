package libraryBranch;

import book.Book;

import java.util.HashMap;
import java.util.Map;

//+--------------------------+
//           LibraryBranch
//        +--------------------------+
//        branchName: String
//        books: Map<String, Book>
//        +--------------------------+
//        addBook(b: Book): void
//        removeBook(ISBN: String): void
//        getBook(ISBN: String): Book

public class LibraryBranch extends Book {
    private String  branchName;
    private Map<String,Book> books;

    public LibraryBranch(String branchName){
        this.branchName = branchName;
        this.books = new HashMap<>();
    }

    public LibraryBranch() {
    }

    public String getBranchName() {
        return branchName;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.put(book.getISBN(), book);
    }
    public void removeBook(String ISBN){
        books.remove(ISBN);
    }
    public Book getBook(String ISBN){
        return books.get(ISBN);
    }
}