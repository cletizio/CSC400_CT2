public class BagDemo {
    public static void main(String[] args) {
        ShoppingCart<String> shoppingCart = new ShoppingCart<>();

        // Testing the add method
        System.out.println("Testing an empty shopping cart with sufficient capacity.");
        String[] contentsOfShoppingCart1 = {"Potato", "Cereal", "Bread"};
        testAdd(shoppingCart, contentsOfShoppingCart1);

        System.out.println("\nTesting an empty shopping cart that will be filled to capacity.");
        shoppingCart = new ShoppingCart<>(6);
        String[] contentsOfShoppingCart2 = {"Potato", "Cereal", "Bread", "Milk", "Cookies", "Pop", "Too Many"};
        testAdd(shoppingCart, contentsOfShoppingCart2);
    }

    private static void testAdd(BagInterface<String> shoppingCart, String[] content) {
        System.out.println("Adding the following strings to the bag: ");
        for (int index = 0; index < content.length; index++) {
            if (shoppingCart.add(content[index]))
                System.out.print(content[index] + " ");
            else
                System.out.print("\nUnable to add " + content[index] + " to the shopping cart.");
        }

        System.out.println();

        displayBag((ShoppingCart<String>) shoppingCart);
    }

    public static void displayBag(ShoppingCart<String> aCart) {
        System.out.println("The shopping cart contains the following string(s): ");
        Object[] bagArray = aCart.toArray();
        for (int index = 0; index < bagArray.length; index++){
            System.out.print(bagArray[index] + " ");
        }
        System.out.println();
    }
}
