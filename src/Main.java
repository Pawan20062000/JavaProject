import book.Book;
import library.Library;
import libraryBranch.LibraryBranch;
import patron.Patron;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryBranch branch1 = new LibraryBranch("Downtown");
        LibraryBranch branch2 = new LibraryBranch("Uptown");

        library.addBranch(branch1);
        library.addBranch(branch2);

        // Adding books
        Book book1 = new Book("Effective Java", "Joshua Bloch", "123456789", "2018");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "987654321", "2008");
        branch1.addBook(book1);
        branch1.addBook(book2);

        // Adding patrons
        Patron alice = new Patron("Pawan", "P001");
        Patron bob = new Patron("Jay", "P002");
        library.addPatron(alice);
        library.addPatron(bob);

        // Borrowing books
        library.checkoutBook("123456789", "P001", branch1);
        System.out.println("After borrowing: " + branch1.getBook("123456789"));

        // Reserving a book
        library.reserveBook("123456789", "P002", branch1);

        // Returning books
        library.returnBook("123456789", "P001", branch1);
        System.out.println("After returning: " + branch1.getBook("123456789"));

        // Transferring books
        library.transferBook("987654321", branch1, branch2);
        System.out.println("Book transferred to Uptown: " + branch2.getBook("987654321"));
    }
}