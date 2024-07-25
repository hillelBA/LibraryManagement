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
    public void printLibraryStatus() {
        System.out.println("Library status:");
        for (Genre genre : library.getGenres()) {
            System.out.println(genre.getName() + ":");
            for (Book book : genre.getBooks()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYearPublished() + ")");
                System.out.println("Copies: " + book.getCopies() + ", Available: " + book.getAvailableCopies()+"\n");
            }
        }
        System.out.println("Members:");
        for (Member member : library.getMembers()) {
            System.out.println(member.getName() + " can borrow " + member.getMaxBooks() + " books.");
            System.out.println("Currently borrowed books:");
            for (Loan loan : member.getLoans()) {
                System.out.println(loan.getBook().getTitle() + " by " + loan.getBook().getAuthor());
            }
        }
    }
}
