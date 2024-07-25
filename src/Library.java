import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;
    private List<Genre> genres;
    private List<Member> members;
    private List<Observer> observers;

    public enum GenreOptions {
        FICTION, NON_FICTION, SCIENCE_FICTION, MYSTERY, THRILLER, ROMANCE, HORROR, BIOGRAPHY, AUTOBIOGRAPHY, FANTASY, SELF_HELP, HISTORY, SCIENCE, ART, POETRY, DRAMA, COMICS, COOKBOOK, DICTIONARY, ENCYCLOPEDIA, TEXTBOOK, JOURNAL, MAGAZINE, NEWSPAPER
    }

    private Library() {
        genres = new ArrayList<>();
        members = new ArrayList<>();
        observers = new ArrayList<>();
        for (int i = 0; i < GenreOptions.values().length; i++) {
            genres.add(new Genre(GenreOptions.values()[i].toString()));
        }
    }

    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
        notifyObservers();
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addMember(Member member) {
        members.add(member);
        addObserver(member); // Register member as an observer
    }

    public void removeMember(Member member) {
        members.remove(member);
        removeObserver(member); // Deregister member as an observer
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void updateLibrary() {
        notifyObservers();
    }
}
