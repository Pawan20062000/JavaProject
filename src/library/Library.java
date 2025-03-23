package library;

import book.Book;
import libraryBranch.LibraryBranch;
import patron.Patron;

import javax.swing.plaf.synth.SynthTreeUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//+--------------------------------+
//                 Library
//        +--------------------------------+
//        patrons: Map<String, Patron>
//        branches: List<LibraryBranch>
//        +--------------------------------+
//        addBranch(branch: LibraryBranch): void
//        addPatron(p: Patron): void
//        checkoutBook(ISBN: String, patronId: String, branch: LibraryBranch): boolean
//        returnBook(ISBN: String, patronId: String, branch: LibraryBranch): boolean
//        reserveBook(ISBN: String, patronId: String, branch: LibraryBranch): boolean
//        transferBook(ISBN: String, fromBranch: LibraryBranch, toBranch: LibraryBranch): boolean

public class Library extends LibraryBranch {
    private  Map<String, Patron> patrons;
    private List<LibraryBranch> branches;
    public Library(){
        this.patrons = new HashMap<>();
        this.branches = new ArrayList<>();
    }

    public void addBranch(LibraryBranch branch){
        branches.add((branch));
    }
    public void addPatron(Patron patron){
        patrons.put(patron.getId(),patron);
    }

    public Patron getPatron(String id){
        return patrons.get(id);
    }
    public boolean checkoutBook(String ISBN, String patronId, LibraryBranch branch){
        Book book  = branch.getBook(ISBN);
        Patron patron = patrons.get(patronId);
        if(book != null && patron != null && !book.isBorrowed() && book.getReservedBy() == null){
            book.borrowBook();
            patron.borrowBook(ISBN);
            return true;
        }
        return false;
    }
    public boolean returnBook(String ISBN, String patronId, LibraryBranch branch) {
        Book book = branch.getBook(ISBN);
        Patron patron = patrons.get(patronId);
        if (book != null && patron != null && book.isBorrowed()) {
            book.returnBook();
            patron.returnBook(ISBN);
            if (book.getReservedBy() != null) {
                System.out.println("Book reserved by: " + book.getReservedBy().getName());
            }
            return true;
        }
        return false;
    }

    public boolean reserveBook(String ISBN, String patronId, LibraryBranch branch) {
        Book book = branch.getBook(ISBN);
        Patron patron = patrons.get(patronId);
        if (book != null && patron != null && book.isBorrowed()) {
            book.reserveBook(patron);
            return true;
        }
        return false;
    }

    public boolean transferBook(String ISBN, LibraryBranch fromBranch, LibraryBranch toBranch) {
        Book book = fromBranch.getBook(ISBN);
        if (book != null) {
            fromBranch.removeBook(ISBN);
            toBranch.addBook(book);
            return true;
        }
        return false;
    }

}
