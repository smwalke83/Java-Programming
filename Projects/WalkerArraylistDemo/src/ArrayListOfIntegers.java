public static void main(String[] args) {
    // instantiate and populate array list
    ArrayList<Integer> list = new ArrayList<>();
    list.add(34);
    list.add(89);
    list.add(65);

    // traditional for loop
    System.out.println("Using the traditional for loop: ");
    for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i) + "\t");
    }
    System.out.println();

    // enhanced for loop
    System.out.println("\nUsing the enhanced for loop: ");
    for (Integer currentInteger: list) {
        System.out.print(currentInteger + "\t");
    }
    System.out.println();

    // unboxing & enhanced for loop
    System.out.println("\nUsing unboxing and the enhanced for loop: ");
    for (int currentInt: list) {
        System.out.print(currentInt + "\t");
    }
    System.out.println();

    // set a new value, display again
    list.set(1, 100);
    System.out.println("\nAfter calling set(1, 100): ");
    for (int currentInt: list) {
        System.out.print(currentInt + "\t");
    }
    System.out.println();

    // remove item and display again
    int removed = list.remove(0);
    System.out.println("At index 0 " + removed + " was removed.");
    for (int currentInt: list) {
        System.out.print(currentInt + "\t");
    }
    System.out.println();
}

