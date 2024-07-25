public interface BookFactory {
    Book createBook(String title, String author, int yearPublished, int copies);
}