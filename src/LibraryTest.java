import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    public Library library = Library.getInstance();
    @BeforeEach
    public void setUp() {
        library.getGenres().clear();
        library.getMembers().clear();
    }

    @Test
    void addGenre() {
        Genre genre = new Genre("Fiction");
        library.addGenre(genre);
        assertTrue(library.getGenres().contains(genre));
    }

    @Test
    void removeGenre() {
        Genre genre = new Genre("Fiction");
        library.addGenre(genre);
        library.removeGenre(genre);
        assertFalse(library.getGenres().contains(genre));
        library.removeGenre(genre); // Attempting to remove again to test redundancy
        assertFalse(library.getGenres().contains(genre));
    }

    @Test
    void addMember() {
        Member member = new Member("Alice", 3);
        library.addMember(member);
        assertTrue(library.getMembers().contains(member));
    }

    @Test
    void removeMember() {
        Member member = new Member("Alice", 3);
        library.addMember(member);
        library.removeMember(member);
        assertFalse(library.getMembers().contains(member));
        library.removeMember(member); // Attempting to remove again to test redundancy
        assertFalse(library.getMembers().contains(member));
    }
}