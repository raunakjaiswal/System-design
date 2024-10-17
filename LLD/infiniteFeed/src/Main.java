// infinite supply of post
// https://leetcode.com/discuss/interview-question/1829936/Coinbase-or-phone-screen-or-implement-iterators


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

interface Iterator<T> {
    boolean hasNext();

    T next();
}

class InfiniteSupplyPostIterator implements Iterator<String> {
    private final String SourceName;
    private int postId;

    public InfiniteSupplyPostIterator(String sourceName) {
        this.SourceName = sourceName;
        this.postId = 1;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        return "post from " + SourceName + " with postId: " + (postId++); // pull from stream queue
    }
}

class InterleavingFeedIterator implements Iterator<String> {
    private final List<Iterator<String>> iterators;
    private int currentIndex = 0;

    public InterleavingFeedIterator(List<Iterator<String>> iterators) {
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        if (iterators.isEmpty())
            throw new NoSuchElementException();
        Iterator<String> itr = iterators.get(currentIndex);
        String nextPost = itr.next();
        currentIndex = (currentIndex + 1) % iterators.size();
        return nextPost;
    }
}

class LimitFeedIterator implements Iterator<String> {

    private final Iterator<String> baseIterator;
    private final int limit;
    private int count = 0;

    public LimitFeedIterator(Iterator<String> baseIterator, int limit) {
        this.baseIterator = baseIterator;
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit && baseIterator.hasNext();
    }

    @Override
    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        count++;
        return baseIterator.next();
    }
}

public class Main {
    public static void main(String[] args) {
        InfiniteSupplyPostIterator facebookIterator = new InfiniteSupplyPostIterator("facebook");

        InfiniteSupplyPostIterator instagramIterartor = new InfiniteSupplyPostIterator("instagram");

        InfiniteSupplyPostIterator twitterIterator = new InfiniteSupplyPostIterator("twitter");

        InterleavingFeedIterator feedIterator = new InterleavingFeedIterator(new ArrayList<>(Arrays.asList(facebookIterator, instagramIterartor, twitterIterator)));

        LimitFeedIterator limitFeedIterator = new LimitFeedIterator(feedIterator, 10);

        while (limitFeedIterator.hasNext()) {
            System.out.println(limitFeedIterator.next());
        }

    }
}