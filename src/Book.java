public abstract class Book implements Cloneable {
    private String title;
    private String author;
    private int yearPublished;
    private int copies;
    protected int availableCopies;

    public Book(String title, String author, int yearPublished, int copies) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.availableCopies = copies;
        this.copies = copies;
    }
}

