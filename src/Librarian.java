import java.util.ArrayList;
import java.util.List;

/**
 * Represents a librarian in the library.
 */
public class Librarian {
    /**
     * The library.
     */
    private final Library library;
    /**
     * The list of loans.
     */
    private final List<Loan> loans;
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
    }
    /**
     * Removes a book from a genre.
     * @param book The book to remove.
     * @param genre The genre to remove the book from.
     */
    public void removeBookFromGenre(Book book, Genre genre) {
        genre.removeBook(book);
    }
/**
     * Registers a member.
     * @param member The member to register.
     */
    public void registerMember(Member member) {
        library.addMember(member);
    }
/**
     * Deregisters a member.
     * @param member The member to deregister.
     */
    public void deregisterMember(Member member) {
        library.removeMember(member);
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
        for (int i = 0; i <loans.size(); i++) {
            if (loans.get(i).getBook().equals(book)) {
                for (int j = 0; j < member.getLoans().size(); j++) {
                    if (member.getLoans().contains(loans.get(i))) {
                        loans.remove(i);
                        member.getLoans().remove(j);
                        book.returnBook();
                        break;
                    }
                }
            }
        }
    }
}
