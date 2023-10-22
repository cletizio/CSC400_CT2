import java.util.Arrays;

public final class ShoppingCart<MyType> implements BagInterface<MyType> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final int MAX_CAPACITY = 10000;
    private MyType[] myBag;
    private int numberOfProducts;
    private boolean integrityOK;

    public ShoppingCart() {
        this(DEFAULT_CAPACITY);
    }

    public ShoppingCart(int desiredCapacity) {

        integrityOK = false;
        if (desiredCapacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            MyType[] tempBag = (MyType[]) new Object[desiredCapacity];
            myBag = tempBag;
            numberOfProducts = 0;
            integrityOK = true;
        } else
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
    }

    public boolean add(MyType newEntry) {

        checkIntegrity();
        boolean result = true;
        if (isFull()) {
            result = false;
        }
        else {
            myBag[numberOfProducts] = newEntry;
            numberOfProducts++;
        }
        return result;
    }


    public MyType[] toArray() {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        MyType[] result = (MyType[]) new Object[numberOfProducts];
        System.arraycopy(myBag, 0, result, 0, numberOfProducts);
        return result;
    }


    public boolean isFull() {
        return numberOfProducts >= myBag.length;
    }

    public boolean isEmpty() {
        return numberOfProducts == 0;
    }

    private void doubleCapacity() {

        int newLength = 2 * myBag.length;
        checkCapacity(newLength);
        myBag = Arrays.copyOf(myBag, newLength);
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum of " +
                    MAX_CAPACITY);
    }

    public int getCurrentSize() {
        return numberOfProducts;
    }

    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ShoppingCart object is corrupt.");
    }
}
