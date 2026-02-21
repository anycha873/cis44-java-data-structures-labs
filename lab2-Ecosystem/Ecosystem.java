import java.util.Random;

abstract class Animal {
    public abstract String toString();
}

class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        populateRandomly();
    }

    private void populateRandomly() {
        for (int i = 0; i < river.length; i++) {
            int choice = random.nextInt(3); // 0, 1, 2
            if (choice == 0) {
                river[i] = new Bear();
            } else if (choice == 1) {
                river[i] = new Fish();
            } else {
                river[i] = null;
            }
        }
    }

    public void runStep() {

        Animal[] next = new Animal[river.length];

        int bearBirths = 0;
        int fishBirths = 0;

        for (int i = 0; i < river.length; i++) {
            Animal a = river[i];
            if (a == null) continue;

            int target = pickTarget(i);

            if (next[target] == null) {
                next[target] = a;
            } else {
                Animal occupant = next[target];

                if (a instanceof Bear && occupant instanceof Bear) {
                    bearBirths++;
                } else if (a instanceof Fish && occupant instanceof Fish) {
                    fishBirths++;
                } else {
                    next[target] = (a instanceof Bear) ? a : occupant;
                }
            }
        }

        placeBirths(next, bearBirths, true);
        placeBirths(next, fishBirths, false);

        river = next;
    }

    private int pickTarget(int i) {
        int dir = random.nextInt(3) - 1; // -1, 0, +1
        int target = i + dir;

        if (target < 0) target = 0;
        if (target >= river.length) target = river.length - 1;

        return target;
    }

    private void placeBirths(Animal[] next, int births, boolean isBear) {
        for (int b = 0; b < births; b++) {
            if (!hasEmpty(next)) return; // no room left

            while (true) {
                int idx = random.nextInt(next.length);
                if (next[idx] == null) {
                    next[idx] = isBear ? new Bear() : new Fish();
                    break;
                }
            }
        }
    }

    private boolean hasEmpty(Animal[] arr) {
        for (Animal a : arr) {
            if (a == null) return true;
        }
        return false;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20);
        eco.visualize();

        for (int step = 1; step <= 20; step++) {
            eco.runStep();
            eco.visualize();
        }
    }
}
