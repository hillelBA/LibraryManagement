import java.util.Date;

/**
 * Represents an observer.
 */
public interface Observer {
    /**
     * Called to provide a notification that a book is overdue.
      */
    void lateToReturn();
}

