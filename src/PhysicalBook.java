/**
 * PhysicalBook class that extends Book class
 */
public class PhysicalBook extends Book {
    /**
     * Creates a new physical book with the given title, author, year published, and number of copies.
     *
     * @param title         The title of the book.
     * @param author        The author of the book.
     * @param yearPublished The year the book was published.
     * @param copies        The total number of copies of the book.
     */
    public PhysicalBook(String title, String author, int yearPublished, int copies) {
        super(title, author, yearPublished, copies);
    }

    /**
     * Adds the book to a genre.
     * @param genre The genre to add the book to.
     */
    @Override
    public void addToGenre(Genre genre) {
        genre.addBook(this);
    }
}