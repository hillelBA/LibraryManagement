public class VirtualBookFactory implements BookFactory {
    public VirtualBook createBook(String title, String author, int yearPublished , int copies) {
        return new VirtualBook(title, author, yearPublished);
    }
}
