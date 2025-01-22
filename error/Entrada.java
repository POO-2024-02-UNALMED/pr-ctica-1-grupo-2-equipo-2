package error;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Entrada {
    static int input(){
        boolean correcto = false;
        int input = 0;
        while (!correcto) {
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error, entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
                continue;
            }
            correcto = true;
        }
        return input;
    }
}
