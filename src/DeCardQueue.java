import java.util.*;


public class DeCardQueue
{
    public static void main(String[] args)
    {
        Queue<Integer> arr1= new LinkedList<Integer>();
        Queue<Integer> arr2= new LinkedList<Integer>();
        Scanner scanner=new Scanner(System.in);

        System.out.print("Введите 5 карт первого игрока: ");
        for (int i = 0; i < 5; i++){
            int value = scanner.nextInt();
            arr1.offer(value);
        }

        System.out.print("Введите 5 карт второго игрока: ");
        for (int i = 0; i < 5; i++){
            int value = scanner.nextInt();
            arr2.offer(value);
        }
        int count = 0;
        boolean res = false;

        for (int i = 0; i < 106; i++) {
            count++;
            if (arr1.element() > arr2.element() || ((arr1.element() == 0) && (arr2.element() == 9))) {
                arr1.add(arr1.element());
                arr1.add(arr2.element());
            } else if (arr1.element() < arr2.element() || ((arr1.element() == 9) && (arr2.element() == 0))) {
                arr2.add(arr2.element());
                arr2.add(arr1.element());
            }
            arr1.poll();
            arr2.poll();

            if (arr1.isEmpty()) {
                System.out.println("Second " + count);
                res = true;
                break;
            } else if (arr2.isEmpty()) {
                System.out.println("First " + count);
                res = true;
                break;
            }
        }
        if (!res) System.out.println("Botva!");
    }
}

