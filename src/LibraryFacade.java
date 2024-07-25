import java.util.List;

public class LibraryFacade {
    private Library library;
    private Librarian librarian;

    public LibraryFacade() {
        this.library = Library.getInstance();
        this.librarian = new Librarian();
    }

    public List<Genre> getGenres() {
        return library.getGenres();
    }

    public List<Member> getMembers() {
        return library.getMembers();
    }

    }
