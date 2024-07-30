import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFacadeTest {
    public LibraryFacade libraryFacade;
@BeforeEach
    public void setUp() {
        libraryFacade = new LibraryFacade();
        libraryFacade.getLibrary().getGenres().clear();
        libraryFacade.getLibrary().getMembers().clear();
        libraryFacade.getLibrarian().getLoans().clear();
    }
    @Test
    void registerMember() {
        libraryFacade.registerMember("Alice", 3);
        assertEquals(1, libraryFacade.getLibrary().getMembers().size());
        assertEquals("Alice", libraryFacade.getLibrary().getMembers().get(0).getName());
    }

    @Test
    void deregisterMember() {
        Member member = new Member("Alice", 3);
        libraryFacade.getLibrary().addMember(member);
        libraryFacade.deregisterMember(member);
        assertEquals(0, libraryFacade.getLibrary().getMembers().size());
    }

    @Test
    void addBookToGenre() {
        Genre genre = new Genre("Fiction");
        libraryFacade.getLibrary().addGenre(genre);
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby1", "F. Scott Fitzgerald", 1925, 1);
        libraryFacade.addBookToGenre(book, genre);
        assertTrue(genre.getBooks().contains(book));
    }

    @Test
    void loanBookToMember() {
        Genre genre = new Genre("Fiction");
        libraryFacade.getLibrary().addGenre(genre);
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby2", "F. Scott Fitzgerald", 1925, 1);
        libraryFacade.addBookToGenre(book, genre);
        Member member = new Member("Alice", 3);
        libraryFacade.getLibrary().addMember(member);
        libraryFacade.loanBookToMember(book, member);
        assertEquals(1, libraryFacade.getLibrarian().getLoans().size());
        assertEquals(book, libraryFacade.getLibrarian().getLoans().get(0).getBook());
    }

    @Test
    void returnBookFromMember() {
        Genre genre = new Genre("Fiction");
        libraryFacade.getLibrary().addGenre(genre);
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby3", "F. Scott Fitzgerald", 1925, 1);
        libraryFacade.addBookToGenre(book, genre);
        Member member = new Member("Alice", 3);
        libraryFacade.getLibrary().addMember(member);
        libraryFacade.loanBookToMember(book, member);
        libraryFacade.returnBookFromMember(book, member);
        assertEquals(0, libraryFacade.getLibrarian().getLoans().size());
    }

    @Test
    void createGenre() {
        Genre genre = libraryFacade.createGenre("Fiction2");
        assertTrue(libraryFacade.getLibrary().getGenres().contains(genre));
    }
}