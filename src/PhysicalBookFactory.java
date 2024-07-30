/**
 * PhysicalBookFactory class that implements the BookFactory interface
 */
public class PhysicalBookFactory implements BookFactory{
    /**
     * Creates a new physical book with the given title, author, year published, and number of copies.
     *
     * @param title        The title of the book.
     * @param author       The author of the book.
     * @param yearPublished The year the book was published.
     * @param copies       The number of copies of the book.
     * @return The physical book created.
     */
    public PhysicalBook createBook(String title, String author, int yearPublished, int copies) {
        return new PhysicalBook(title, author, yearPublished, copies);
    }
}
