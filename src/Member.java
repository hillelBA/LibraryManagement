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

    @Override
    public void update() {
        // Implementation for the Observer update method
    }
}
