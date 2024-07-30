/**
 * VirtualBookFactory class that implements the BookFactory interface
 */
public class VirtualBookFactory implements BookFactory {
    /**
     * Creates a new virtual book with the given title, author, and year published.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param yearPublished The year the book was published.
     * @param copies The total number of copies of the book.
     * @return The virtual book created.
     */
    public VirtualBook createBook(String title, String author, int yearPublished , int copies) {
        return new VirtualBook(title, author, yearPublished);
    }
}
