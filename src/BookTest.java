
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testClone() {
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 1);
        Book clone = book.clone();
        assertEquals(book.getTitle(), clone.getTitle());
        assertEquals(book.getAuthor(), clone.getAuthor());
        assertEquals(book.getYearPublished(), clone.getYearPublished());
        assertEquals(book.getCopies(), clone.getCopies());
    }
}