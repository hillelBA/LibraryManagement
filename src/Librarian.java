import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Librarian {
    private Library library;
    private List<Loan> loans;

    public Librarian() {
        this.library = Library.getInstance();
        this.loans = new ArrayList<>();
    }

    public void addBookToGenre(Book book, Genre genre) {
        genre.addBook(book);
        library.updateLibrary();
    }

    public void removeBookFromGenre(Book book, Genre genre) {
        genre.removeBook(book);
        library.updateLibrary();
    }

    public void registerMember(Member member) {
        library.addMember(member);
        library.updateLibrary();
    }

    public void deregisterMember(Member member) {
        library.removeMember(member);
        library.updateLibrary();
    }

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
