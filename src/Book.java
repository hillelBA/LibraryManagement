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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }



    public int getYearPublished() {
        return yearPublished;
    }


    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getAvailableCopies() {
        return availableCopies;
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

    public abstract void addToGenre(Genre genre);
}

