import java.util.ArrayList;
import java.util.List;

public class Genre {
    private List<Book> books;
    private String name;


    public Genre(String name) {
        this.books = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Book> getBooks() {
        return books;
    }
}
