public interface BagInterface<MyType> {
    boolean add(MyType newEntry);
    MyType[] toArray();
    boolean isFull();
}
