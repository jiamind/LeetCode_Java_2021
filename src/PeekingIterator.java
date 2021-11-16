import java.util.Iterator;

/**
 * 284. Peeking Iterator
 */
public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    boolean hasNext;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        prepareNext();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = this.next;
        prepareNext();

        return result;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    private void prepareNext() {
        if (this.iterator.hasNext()) {
            this.hasNext = true;
            this.next = iterator.next();
        } else {
            this.hasNext = false;
            this.next = null;
        }
    }
}