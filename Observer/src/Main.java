import java.util.ArrayList;
import java.util.List;

interface observer {
    void update(String newspaperIssue);
}

interface Subject {
    void addObserver(observer ob);

    void removeObserver(observer ob);

    void notifyAllObserver();
}


class Newspaper implements Subject {
    private List<observer> observers;
    String latestIssue;

    public Newspaper() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyAllObserver() {
        for (observer observer : observers) {
            observer.update(latestIssue);
        }
    }

    public void setLatestIssue(String issue) {
        this.latestIssue = issue;
        notifyAllObserver();
    }
}

class User implements observer {
    private String username;

    public User(String name) {
        this.username = name;
    }

    @Override
    public void update(String newspaperIssue) {
        System.out.println(username + " has been notified of the new newspaper issue: " + newspaperIssue);
    }
}


public class Main {
    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();

        // Creating subscribers
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Registering subscribers
        newspaper.addObserver(user1);
        newspaper.addObserver(user2);
        newspaper.addObserver(user3);

        // Setting a new newspaper issue and notifying subscribers
        newspaper.setLatestIssue("Daily News - Issue #1");

        newspaper.removeObserver(user2);

        newspaper.setLatestIssue("Daily News - Issue #2");
    }
}