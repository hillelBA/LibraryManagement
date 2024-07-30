/**
 * VirtualBook is a subclass of Book that represents a virtual book.
 */
public class VirtualBook extends Book {
    /**
     * Creates a new virtual book with the given title, author, and year published.
      * @param title
     * @param author
     * @param yearPublished
     */
    public VirtualBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished, 1);
    }

    /**
     * Adds the book to a genre.
     * @param genre The genre to add the book to.
     */
    @Override
    public void addToGenre(Genre genre) {
        genre.addBook(this);
    }

    /**
     * Loan the book. Does nothing for virtual books.
     */
    public void loanBook() {
        // Do nothing
    }

    /**
     * Return the book. Does nothing for virtual books.
     */
    public void returnBook() {
        // Do nothing
    }
}