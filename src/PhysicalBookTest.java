import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhysicalBookTest {

    @Test
    void addToGenre() {
        PhysicalBook physicalBook = new PhysicalBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 1);
        Genre genre = new Genre("Fiction");
        physicalBook.addToGenre(genre);
        assertTrue(genre.getBooks().contains(physicalBook));
    }
}