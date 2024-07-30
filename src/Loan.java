import java.util.Date;

/**
 * Represents a loan of a book.
 */
public class Loan {
    /**
     * The book being loaned.
     */
    private Book book;
    /**
     * The date the book was loaned.
     */
    private Date loanDate;
    /**
     * The date the book was returned.
     */
    private Date returnDate;

    /**
     * Creates a new loan for the given book.
     *
     * @param book The book being loaned.
     */
    public Loan(Book book) {
        this.book = book;
        this.loanDate = new Date();
        // set the return date to two weeks from the loan date
        this.returnDate = new Date(loanDate.getTime() + 14 * 24 * 60 * 60 * 1000);
    }

    /**
     * @return The book being loaned.
     */
    public Book getBook() {
        return book;
    }

    /**
     * @return The date the book was loaned.
     */
    public Date getLoanDate() {
        return loanDate;
    }

    /**
     * @return The date the book was returned.
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the date the book was returned.
     *
     * @param returnDate The date the book was returned.
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
