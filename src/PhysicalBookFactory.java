public class PhysicalBookFactory implements BookFactory{
    public PhysicalBook createBook(String title, String author, int yearPublished, int copies) {
        return new PhysicalBook(title, author, yearPublished, copies);
    }
}
