import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double screen = 0.0;
        double stored = 0.0;
        String op = "";

        System.out.println("Calculator started. Type exit to quit.");
        System.out.println("Screen: " + screen);

        while (true) {

            String input = sc.nextLine();


            if (input.equals("exit")) {
                break;
            }


            else if (input.equals("+")) {
                stored = screen;
                op = "+";
            }


            else if (input.equals("-")) {
                stored = screen;
                op = "-";
            }


            else if (input.equals("*")) {
                stored = screen;
                op = "*";
            }


            else if (input.equals("/")) {
                stored = screen;
                op = "/";
            }


            else if (input.equals("=")) {

                if (op.equals("+")) {
                    screen = stored + screen;
                }

                else if (op.equals("-")) {
                    screen = stored - screen;
                }

                else if (op.equals("*")) {
                    screen = stored * screen;
                }

                else if (op.equals("/")) {
                    screen = stored / screen;
                }
            }


            else {
                screen = Double.parseDouble(input);
            }


            System.out.println("Screen: " + screen);
        }


        System.out.println("Calculator closed.");
    }
}
