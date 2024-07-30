import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library.
 */
public class Library {
    /**
     * The instance of the library.
     */
    private static Library instance;
    /**
     * The list of genres in the library.
     */
    private final List<Genre> genres;
    /**
     * The list of members in the library.
     */
    private final List<Member> members;
    /**
     * The list of observers of the library.
     */
    private final List<Observer> observers;

    /**
     * The genre options.
     */
    public enum GenreOptions {
        FICTION, NON_FICTION, SCIENCE_FICTION, MYSTERY, THRILLER, ROMANCE, HORROR, BIOGRAPHY, AUTOBIOGRAPHY, FANTASY, SELF_HELP, HISTORY, SCIENCE, ART, POETRY, DRAMA, COMICS, COOKBOOK, DICTIONARY, ENCYCLOPEDIA, TEXTBOOK, JOURNAL, MAGAZINE, NEWSPAPER
    }

    /**
     * Creates a new library.
     */
    private Library() {
        genres = new ArrayList<>();
        members = new ArrayList<>();
        observers = new ArrayList<>();
        for (int i = 0; i < GenreOptions.values().length; i++) {
            genres.add(new Genre(GenreOptions.values()[i].toString()));
        }
    }

    /**
     * @return The instance of the library.
     */
    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    /**
     * @return The list of genres in the library.
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * @return The list of members in the library.
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Adds a genre to the library.
     *
     * @param genre The genre to add.
     */
    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    /**
     * Removes a genre from the library.
     *
     * @param genre The genre to remove.
     */
    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

    /**
     * Adds an observer to the library.
     *
     * @param observer The observer to add.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the library.
     *
     * @param observer The observer to remove.
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Adds a member to the library.
     *
     * @param member The member to add.
     */
    public void addMember(Member member) {
        members.add(member);
        addObserver(member); // Register member as an observer
    }

    /**
     * Removes a member from the library.
     *
     * @param member The member to remove.
     */
    public void removeMember(Member member) {
        members.remove(member);
        removeObserver(member); // Deregister member as an observer
    }

    /**
     * Notifies observers of the library.
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.lateToReturn();
        }
    }

    /**
     * Prints the loans that are past due.
     */
    public void printPastDueLoans() {
        notifyObservers();
    }
}
