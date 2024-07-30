/**
 * This class represents a book in the library.
 */
public abstract class Book implements Cloneable {
    /**
     * The title of the book.
     */
    private String title;
    /**
     * The author of the book.
     */
    private String author;
    /**
     * \
     * The year the book was published.
     */
    private int yearPublished;
    /**
     * The total number of copies of the book.
     */
    private int copies;
    /**
     * The total number of available copies of the book.
     */
    protected int availableCopies;

    /**
     * Creates a new book with the given title, author, year published, and number of copies.
     *
     * @param title         The title of the book.
     * @param author        The author of the book.
     * @param yearPublished The year the book was published.
     * @param copies        The total number of copies of the book.
     */
    public Book(String title, String author, int yearPublished, int copies) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.availableCopies = copies;
        this.copies = copies;
    }

    /**
     * Returns the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }


    /**
     * @return The year the book was published.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * get the number of copies of the book.
     */

    public int getCopies() {
        return copies;
    }

    /**
     * set the number of copies of the book.
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }

    /**
     * get the number of available copies of the book.
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * check if the book is available.
     *
     * @return true if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return availableCopies > 0;
    }

    /**
     * loan the book.
     * If the book is available, the number of available copies is decreased by 1.
     */
    public void loanBook() {
        if (isAvailable()) {
            availableCopies--;
        }
    }

    /**
     * return the book.
     */
    public void returnBook() {
        if (availableCopies < copies) {
            availableCopies++;
        }
    }

    /**
     * Returns a clone of the book.
     *
     * @return A clone of the book.
     */
    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    /**
     * Adds the book to the given genre.
     * @param genre The genre to add the book to.
     */
    public abstract void addToGenre(Genre genre);
}

