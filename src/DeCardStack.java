import java.util.Scanner;
import java.util.Stack;

public class DeCardStack {
    public static void main(String[] args) {
        Stack<Integer> arr1 = new Stack<Integer>();
        Stack<Integer> arr2 = new Stack<Integer>();
        Stack<Integer> Reverse_arr1 = new Stack<Integer>();
        Stack<Integer> Reverse_arr2 = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите 5 карт первого игрока: ");
        for (int i = 0; i < 5; i++) {
            int value = scanner.nextInt();
            arr1.push(value);
        }


        System.out.print("Введите 5 карт второго игрока: ");
        for (int i = 0; i < 5; i++) {
            int value = scanner.nextInt();
            arr2.push(value);
        }

        for (int i = 0; i < 5; i++) {
            Reverse_arr1.push(arr1.pop());
            Reverse_arr2.push(arr2.pop());
        }


        int count = 0;
        boolean res = false;

        for (int i = 0; i < 106; i++) {
            count++;
            if (Reverse_arr1.peek() > Reverse_arr2.peek() ||
                    ((Reverse_arr1.peek() == 0) && (Reverse_arr2.peek() == 9))) {
                Reverse_arr1.push(Reverse_arr1.peek());
                Reverse_arr1.push(Reverse_arr2.peek());
            } else if (Reverse_arr1.peek() < Reverse_arr2.peek() || ((Reverse_arr1.peek() == 9) && (Reverse_arr2.peek() == 0))) {
                Reverse_arr2.push(Reverse_arr2.peek());
                Reverse_arr2.push(Reverse_arr1.peek());
            }
            Reverse_arr1.pop();
            Reverse_arr2.pop();
            if (Reverse_arr1.isEmpty()) {
                System.out.println("Second " + count);
                res = true;
                break;
            } else if (Reverse_arr2.isEmpty()) {
                System.out.println("First " + count);
                res = true;
                break;
            }
        }
        if (!res) System.out.println("Botva!");

    }
}
