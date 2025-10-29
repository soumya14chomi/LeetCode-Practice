// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    List<Integer> lst = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    int idx = 0;
	public PeekingIterator(Iterator<Integer> it) {
	    // initialize any member here.
	    while(it.hasNext()){
            int i = it.next();
            lst.add(i);
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return lst.get(idx);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(dq.peekFirst() == lst.get(idx))  dq.pollFirst();
        idx++;
        return lst.get(idx-1);
	}
	
	@Override
	public boolean hasNext() {
	    return idx != lst.size();
	}
}