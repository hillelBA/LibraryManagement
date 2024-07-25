public class VirtualBook extends Book {
    public VirtualBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished, 1);
    }

    @Override
    public void addToGenre(Genre genre) {
        genre.addBook(this);
    }
    public void loanBook() {
        // Do nothing
    }
    public void returnBook() {
        // Do nothing
    }
}