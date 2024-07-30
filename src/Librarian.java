import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a librarian in the library.
 */
public class Librarian {
    /**
     * The library.
     */
    private Library library;
    /**
     * The list of loans.
     */
    private List<Loan> loans;
    /**
     * Creates a new librarian.
     */
    public Librarian() {
        this.library = Library.getInstance();
        this.loans = new ArrayList<>();
    }
    /**
     * @return The list of loans.
     */
    public List<Loan> getLoans() {
        return loans;
    }
    /**
     * Adds a book to a genre.
     * @param book The book to add.
     * @param genre The genre to add the book to.
     */
    public void addBookToGenre(Book book, Genre genre) {
        genre.addBook(book);
        library.updateLibrary();
    }
    /**
     * Removes a book from a genre.
     * @param book The book to remove.
     * @param genre The genre to remove the book from.
     */
    public void removeBookFromGenre(Book book, Genre genre) {
        genre.removeBook(book);
        library.updateLibrary();
    }
/**
     * Registers a member.
     * @param member The member to register.
     */
    public void registerMember(Member member) {
        library.addMember(member);
        library.updateLibrary();
    }
/**
     * Deregisters a member.
     * @param member The member to deregister.
     */
    public void deregisterMember(Member member) {
        library.removeMember(member);
        library.updateLibrary();
    }
/**
     * Loans a book to a member.
     * @param book The book to loan.
     * @param member The member to loan the book to.
     */
    public void loanBookToMember(Book book, Member member) {
        if (book.isAvailable() && member.canBorrowBook()) {
            Loan loan = new Loan(book);
            member.borrowBook(loan);
            loans.add(loan);
            book.loanBook();
            library.updateLibrary();
        } else {
            System.out.println("The book is currently not available or member can't borrow more books.");
        }
    }
/**
     * Returns a book from a member.
     * @param book The book to return.
     * @param member The member to return the book from.
     */
    public void returnBookFromMember(Book book, Member member) {
        Loan loan = member.returnBook(book);
        if (loan != null) {
            loan.setReturnDate(new Date());
            book.returnBook();
            library.updateLibrary();
        } else {
            System.out.println("The book was not loaned by the member.");
        }
    }
}
