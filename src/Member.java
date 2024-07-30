import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a member of the library.
 */
public class Member implements Observer {
    /**
     * The name of the member.
     */
    private String name;
    /**
     * The list of loans.
     */
    private List<Loan> loans;
    /**
     * The maximum number of books the member can borrow.
     */
    private int maxBooks;

    /**
     * Creates a new member with the given name and maximum number of books.
     *
     * @param name     The name of the member.
     * @param maxBooks The maximum number of books the member can borrow.
     */
    public Member(String name, int maxBooks) {
        this.name = name;
        this.loans = new ArrayList<>();
        this.maxBooks = maxBooks;
    }

    /**
     * @return The name of the member.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the member.
     *
     * @param name The name of the member.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The list of loans.
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Sets the list of loans.
     *
     * @param loans The list of loans.
     */
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    /**
     * @return The maximum number of books the member can borrow.
     */
    public int getMaxBooks() {
        return maxBooks;
    }

    /**
     * Sets the maximum number of books the member can borrow.
     *
     * @param maxBooks The maximum number of books the member can borrow.
     */
    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    /**
     * @return Whether the member can borrow a book.
     */
    public boolean canBorrowBook() {
        return loans.size() < maxBooks;
    }

    /**
     * Borrows a book.
     *
     * @param loan The loan to add.
     */
    public void borrowBook(Loan loan) {
        if (canBorrowBook()) {
            loans.add(loan);
        } else {
            System.out.println("Cannot borrow more books.");
        }
    }

    /**
     * Returns a book.
     *
     * @param book The book to return.
     * @return The loan that was returned.
     */
    public Loan returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && loan.getReturnDate() == null) {
                loans.remove(loan);
                return loan;
            }
        }
        return null;
    }

    /**
     * Print the books the member has borrowed.
     */
    @Override
    public void lateToReturn() {
        Date date = new Date();
        System.out.println("overdue books for " + name + ":");
        for (Loan loan : loans) {
            if (loan.getReturnDate() == null && date.after(loan.getReturnDate())) {
                System.out.println("The book " + loan.getBook().getTitle() + " is overdue.");
            }
        }
        System.out.println();
    }
}
