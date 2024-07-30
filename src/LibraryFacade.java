import java.util.List;

/**
 * Represents a facade for the library.
 */
public class LibraryFacade {
    /**
     * The library.
     */
    private final Library library;
    /**
     * The librarian.
     */
    private final Librarian librarian;

    /**
     * Creates a new library facade.
     */
    public LibraryFacade() {
        this.library = Library.getInstance();
        this.librarian = new Librarian();
    }

    /**
     * @return The genres in the library.
     */
    public List<Genre> getGenres() {
        return library.getGenres();
    }

    /**
     * @return The members in the library.
     */
    public List<Member> getMembers() {
        return library.getMembers();
    }

    /**
     * Registers a member.
     *
     * @param name     The name of the member.
     * @param maxBooks The maximum number of books the member can borrow.
     */
    public void registerMember(String name, int maxBooks) {
        Member member = new Member(name, maxBooks);
        librarian.registerMember(member);
        library.addObserver(member);
    }

    /**
     * Deregister a member.
     *
     * @param member The member to deregister.
     */
    public void deregisterMember(Member member) {
        librarian.deregisterMember(member);
        library.removeObserver(member);
    }

    /**
     * Adds a book to a genre.
     *
     * @param title         The title of the book.
     * @param author        The author of the book.
     * @param yearPublished The year the book was published.
     * @param copies        The number of copies of the book.
     * @param genre         The genre to add the book to.
     * @param isPhysical    Whether the book is physical or virtual.
     */
    public void addBookToGenre(String title, String author, int yearPublished, int copies, Genre genre, boolean isPhysical) {
        BookFactory bookFactory = isPhysical ? new PhysicalBookFactory() : new VirtualBookFactory();
        Book book = bookFactory.createBook(title, author, yearPublished, copies);
        librarian.addBookToGenre(book, genre);
    }

    /**
     * Adds a book to a genre.
     *
     * @param book         The book to add.
     * @param genre         The genre to add the book to.
     */
    public void addBookToGenre(Book book, Genre genre) {
        librarian.addBookToGenre(book, genre);
    }

    /**
     * Removes a book from a genre.
     *
     * @param book   The book to remove.
     * @param member The member to loan the book to.
     */
    public void loanBookToMember(Book book, Member member) {
        librarian.loanBookToMember(book, member);
    }

    /**
     * Returns a book from a member.
     *
     * @param book   The book to return.
     * @param member The member to return the book from.
     */
    public void returnBookFromMember(Book book, Member member) {
        librarian.returnBookFromMember(book, member);
    }

    /**
     * Creates a genre.
     *
     * @param name The name of the genre.
     * @return The genre created.
     */
    public Genre createGenre(String name) {
        Genre genre = new Genre(name);
        library.addGenre(genre);
        return genre;
    }

    /**
     * adds an observer to the library.
     *
     * @param observer The observer to add.
     */
    public void addObserver(Observer observer) {
        library.addObserver(observer);
    }

    /**
     * Removes an observer from the library.
     *
     * @param observer The observer to remove.
     */
    public void removeObserver(Observer observer) {
        library.removeObserver(observer);
    }

    /**
     * Prints the library status.
     */
    public void printLibraryStatus() {
        System.out.println("Library status:");
        System.out.println("Genres:");
        for (Genre genre : library.getGenres()) {
            System.out.println(genre.getName() + ":");
            for (Book book : genre.getBooks()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYearPublished() + ")");
                System.out.println("Copies: " + book.getCopies() + ", Available: " + book.getAvailableCopies() + "\n");
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
        System.out.println("Loans:");
        for (Loan loan : librarian.getLoans()) {
            System.out.println(loan.getBook().getTitle() + " by " + loan.getBook().getAuthor() + " borrowed until " + loan.getReturnDate());
        }
        System.out.println("end of library status\n");
    }

    public Library getLibrary() {
        return library;
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}
