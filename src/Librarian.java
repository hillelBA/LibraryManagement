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


}
