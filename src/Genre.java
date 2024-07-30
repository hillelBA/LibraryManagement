import java.util.ArrayList;
import java.util.List;

/**
 * Represents a genre of books in the library.

 */
public class Genre {
    /**
     * The list of books in this genre.
      */
    private List<Book> books;
    /**
     * The name of the genre.
     */
    private String name;

    /**
     * Creates a new genre with the given name.
     * @param name The name of the genre.
     */
    public Genre(String name) {
        this.books = new ArrayList<>();
        this.name = name;
    }

    /**
     * @return The name of the genre.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the genre.
     * @param name The name of the genre.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
