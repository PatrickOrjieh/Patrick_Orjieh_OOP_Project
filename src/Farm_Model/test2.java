package Farm_Model;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 10;
        int spacesNeeded = 0;
        int size = 1;
        String[] inputs = new String[size];
        for (int i = 0; i < size; i++) {
            inputs[i] = "jnbhfdjvihdfkjvbfdhvn";
        }
        System.out.print("+");

        int maxsize = 0;

        for (String s : inputs) {
            if (s.length() > maxsize) {
                maxsize = s.length();
            }
        }

        for (int i = 0; i <= maxsize + 1; i++) {
            System.out.print("-");
        }

        System.out.print("+");
        System.out.println();
        for (int j = 0; j < inputs.length; j++) {
            System.out.print("| " + inputs[j]);

            for (int i = inputs[j].length(); i <= maxsize; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();

        }
        System.out.print("+");

        for (int i = 0; i <= maxsize + 1; i++) {
            System.out.print("-");
        }

        System.out.print("+");
        System.out.println();
        in.close();
    }
}
