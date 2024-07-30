/**
 * BookFactory interface
 */
public interface BookFactory {
    /**
     * Create a book
     * @param title The title of the book.
     * @param author The author of the book.
     * @param yearPublished The year the book was published.
     * @param copies The total number of copies of the book.
     * @return The book created.
     */
    Book createBook(String title, String author, int yearPublished, int copies);
}