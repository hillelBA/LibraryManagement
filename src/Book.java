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

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void loanBook() {
        if (isAvailable()) {
            availableCopies--;
        }
    }
    public void returnBook() {
        if (availableCopies < copies) {
            availableCopies++;
        }
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // Abstract method to be implemented by subclasses
    public abstract void addToGenre(Genre genre);
}

