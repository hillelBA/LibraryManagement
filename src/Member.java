import java.util.ArrayList;
import java.util.List;

public class Member implements Observer {
    private String name;
    private List<Loan> loans;
    private int maxBooks;

    public Member(String name, int maxBooks) {
        this.name = name;
        this.loans = new ArrayList<>();
        this.maxBooks = maxBooks;
    }

    public boolean canBorrowBook() {
        return loans.size() < maxBooks;
    }

    public void borrowBook(Loan loan) {
        if (canBorrowBook()) {
            loans.add(loan);
        } else {
            System.out.println("Cannot borrow more books.");
        }
    }

    public Loan returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && loan.getReturnDate() == null) {
                loans.remove(loan);
                return loan;
            }
        }
        return null;
    }

    @Override
    public void update() {
        // Implementation for the Observer update method
    }
}
