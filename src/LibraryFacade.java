import java.util.List;

public class LibraryFacade {
    private Library library;
    private Librarian librarian;

    public LibraryFacade() {
        this.library = Library.getInstance();
        this.librarian = new Librarian();
    }

    public void registerMember(String name, int maxBooks) {
        Member member = new Member(name, maxBooks);
        librarian.registerMember(member);
        library.addObserver(member);
    }

    public void deregisterMember(Member member) {
        librarian.deregisterMember(member);
        library.removeObserver(member);
    }

    public void addBookToGenre(String title, String author, int yearPublished, int copies, Genre genre, boolean isPhysical) {
        BookFactory bookFactory = isPhysical ? new PhysicalBookFactory() : new VirtualBookFactory();
        Book book = bookFactory.createBook(title, author, yearPublished, copies);
        librarian.addBookToGenre(book, genre);
        library.updateLibrary();  // Notify observers
    }

    public void loanBookToMember(Book book, Member member) {
        librarian.loanBookToMember(book, member);
        library.updateLibrary();  // Notify observers
    }

    public void returnBookFromMember(Book book, Member member) {
        librarian.returnBookFromMember(book, member);
        library.updateLibrary();  // Notify observers
    }

    public Genre createGenre(String name) {
        Genre genre = new Genre(name);
        library.addGenre(genre);
        library.updateLibrary();  // Notify observers
        return genre;
    }

    public void addObserver(Observer observer) {
        library.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        library.removeObserver(observer);
    }

    public List<Genre> getGenres() {
        return library.getGenres();
    }

    public List<Member> getMembers() {
        return library.getMembers();
    }
}
