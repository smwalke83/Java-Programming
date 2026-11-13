//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Random rand = new Random(43);
    for (int i = 0; i < 7; i++) {
        System.out.println(rand.nextInt(1, 51));
    }
}
