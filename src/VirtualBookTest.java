import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualBookTest {

    @Test
    void addToGenre() {
        VirtualBook virtualBook = new VirtualBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Genre genre = new Genre("Fiction");
        virtualBook.addToGenre(genre);
        assertTrue(genre.getBooks().contains(virtualBook));
    }

    @Test
    void loanBook() {
        VirtualBook virtualBook = new VirtualBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertEquals(1, virtualBook.getAvailableCopies());
        virtualBook.loanBook();
        assertEquals(1, virtualBook.getAvailableCopies());
    }

    @Test
    void returnBook() {
        VirtualBook virtualBook = new VirtualBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertEquals(1, virtualBook.getAvailableCopies());
        virtualBook.loanBook();
        assertEquals(1, virtualBook.getAvailableCopies());
        virtualBook.returnBook();
        assertEquals(1, virtualBook.getAvailableCopies());
    }
}