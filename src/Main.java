import java.util.List;

public class Main {

    public static void main(String[] args) {

        LibraryFacade library = new LibraryFacade();
        Librarian librarian = new Librarian();
        BookFactory bookFactory = new PhysicalBookFactory();
        Book book = bookFactory.createBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, 3);
        List<Genre> genres = library.getGenres();
        for (Genre genre : genres) {
            if (genre.getName().equals("SCIENCE_FICTION")) {
                librarian.addBookToGenre(book, genre);
            }
        }
        library.registerMember("Arthur Dent", 2);
        List<Member> members = library.getMembers();
        for (Member member : members) {
            if (member.getName().equals("Arthur Dent")) {
                library.loanBookToMember(book, member);
            }
        }
        library.printLibraryStatus();

    }

}