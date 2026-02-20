import java.util.Random;
public class Lab1DotProduct {
    public static void main(String[] args) {
        int n = 5;

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        Random rand = new Random();

        for (int i = 0; i<n ; i++) {
            a[i] = rand.nextInt(10);
            b[i] = rand.nextInt(10);
        }

        for (int i = 0; i<n; i++) {
            c[i] = a[i] * b[i];
        }
        System.out.println("Array a:");
        for(int i = 0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n Array b:");
        for(int i = 0; i<n; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println("\n Array c:");
        for(int i = 0; i<n; i++) {
            System.out.print(c[i] + " ");
        }

        }
    }
