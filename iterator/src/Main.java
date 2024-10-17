import java.util.*;

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface Iterator<T> {
    boolean hasNext();

    T next();
}


class BookIterator implements Iterator<Book> {
    private List<Book> books;
    int currentIndex = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < books.size();
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return books.get(currentIndex++);
        }
        return null;
    }
}

interface IterableCollection<T> {
    Iterator<T> createIterator(); // Returns an iterator to traverse the collection
}

class Library implements IterableCollection<Book> {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }
}

class Pair {
    private Integer first;
    private Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }
}

class CustomIterator implements Iterator<Integer> {
    private List<List<Integer>> data;
    Queue<Pair> totalStream = new LinkedList<>();

    public CustomIterator(List<List<Integer>> data) {
        this.data = data;
        for (int i = 0; i < data.size(); i++) {
            totalStream.add(new Pair(i, 0));
        }
    }

    @Override
    public boolean hasNext() {
        int totcnt = totalStream.size();
        while (totcnt-- > 0) {
            Pair top = totalStream.peek();
            if (top != null && top.getSecond() < data.get(top.getFirst()).size()) {
                return true;
            }
            totalStream.poll();
            totalStream.add(top);
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Pair top = totalStream.poll();
            Integer result = data.get(top.getFirst()).get(top.getSecond());
            top.setSecond(top.getSecond() + 1);
            totalStream.add(top);
            return result;
        }
        return null;
    }
}

class Memory implements IterableCollection<Integer> {
    private List<List<Integer>> data;

    public Memory(List<List<Integer>> data) {
        this.data = data;
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new CustomIterator(data);
    }
}

public class Main {
    public static void main(String[] args) {

        Library library = new Library(Arrays.asList(new Book("book1"), new Book("book2"), new Book("book3")));
        Iterator<Book> itr = library.createIterator();
        while (itr.hasNext()) {
            Book book = itr.next();
            System.out.println(book.getName());
        }

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 6));

        Memory memory = new Memory(Arrays.asList(list1, list2, list3));
        Iterator<Integer> itr1 = memory.createIterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());

        }
    }
}