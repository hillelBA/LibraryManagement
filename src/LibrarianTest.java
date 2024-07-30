import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {
    @BeforeEach
    public void setUp() {
        Library library = Library.getInstance();
        library.getGenres().clear();
        library.getMembers().clear();
    }

    @Test
    void addBookToGenre() {
        Library library = Library.getInstance();
        Librarian librarian = new Librarian();
        Genre genre = new Genre("Fiction");
        library.addGenre(genre);
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 1);
        librarian.addBookToGenre(book, genre);
        assertTrue(genre.getBooks().contains(book));
    }

    @Test
    void removeBookFromGenre() {
        Library library = Library.getInstance();
        Librarian librarian = new Librarian();
        Genre genre = new Genre("Fiction");
        library.addGenre(genre);
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 1);
        librarian.addBookToGenre(book, genre);
        librarian.removeBookFromGenre(book, genre);
        assertFalse(genre.getBooks().contains(book));
        librarian.removeBookFromGenre(book, genre); // Attempting to remove again to test redundancy
        assertFalse(genre.getBooks().contains(book));
    }

    @Test
    void registerMember() {
        Library library = Library.getInstance();
        Librarian librarian = new Librarian();
        Member member = new Member("Alice", 3);
        librarian.registerMember(member);
        assertTrue(library.getMembers().contains(member));
    }

    @Test
    void deregisterMember() {
        Library library = Library.getInstance();
        Librarian librarian = new Librarian();
        Member member = new Member("Alice", 3);
        librarian.registerMember(member);
        librarian.deregisterMember(member);
        assertFalse(library.getMembers().contains(member));
        librarian.deregisterMember(member); // Attempting to deregister again to test redundancy
        assertFalse(library.getMembers().contains(member));
    }

    @Test
    void loanBookToMember() {
        Library library = Library.getInstance();
        Librarian librarian = new Librarian();
        Genre genre = new Genre("Fiction");
        library.addGenre(genre);
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 1);
        librarian.addBookToGenre(book, genre);
        Member member = new Member("Alice", 3);
        librarian.registerMember(member);
        librarian.loanBookToMember(book, member);
        assertEquals(member.getLoans().get(0).getBook(), book);
    }

    @Test
    void returnBookFromMember() {
        Library library = Library.getInstance();
        Librarian librarian = new Librarian();
        Genre genre = new Genre("Fiction");
        library.addGenre(genre);
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 1);
        librarian.addBookToGenre(book, genre);
        Member member = new Member("Alice", 3);
        librarian.registerMember(member);
        librarian.loanBookToMember(book, member);
        librarian.returnBookFromMember(book, member);
        assertTrue(member.getLoans().isEmpty());
    }
}
