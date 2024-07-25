public class PhysicalBook extends Book {
    public PhysicalBook(String title, String author, int yearPublished, int copies) {
        super(title, author, yearPublished, copies);
    }

    @Override
    public void addToGenre(Genre genre) {
        genre.addBook(this);
    }
}