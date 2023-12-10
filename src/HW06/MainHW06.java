package HW06;
/*
Контекст
Предположим, что мы хотим найти элемент в массиве (получить
его индекс). Мы можем это сделать просто перебрав все элементы.
Но что, если массив уже отсортирован? В этом случае можно
использовать бинарный поиск. Принцип прост: сначала берём
элемент находящийся посередине и сравниваем с тем, который мы
хотим найти. Если центральный элемент больше нашего,
рассматриваем массив слева от центрального, а если больше -
справа и повторяем так до тех пор, пока не найдем наш элемент.
● Ваша задача
Написать программу на любом языке в любой парадигме для
бинарного поиска. На вход подаётся целочисленный массив и
число. На выходе - индекс элемента или -1, в случае если искомого
элемента нет в массиве.
 */

import java.util.Arrays;

public class MainHW06 {
    public static void main(String args[]) {

        int counter, num, item, array[], first, last;
        int[] arr = new int[] {1, 3, 10, 15, 2, 47, -12};

        System.out.println("Our array is: ");
        printArray(arr);

        //one of the conditions is that the array is sorted
        Arrays.sort(arr);

        System.out.println("After sort it is: ");
        printArray(arr);

        item = 3;
        first = 0;
        last = arr.length - 1;

        // accepts in array, first and last index and number of element for search
        binarySearch(arr, first, last, item);
    }

    // binary search
    public static void binarySearch(int[] arr, int firstIndex, int lastIndex, int item) {
        int position;
        int comparisonCount = 1;

        // find the middle element
        position = (firstIndex + lastIndex) / 2;

        while ((arr[position] != item) && (firstIndex <= lastIndex)) {
            comparisonCount++;
            if (arr[position] > item) {
                lastIndex = position - 1;
            } else {
                firstIndex = position + 1;
            }
            position = (firstIndex + lastIndex) / 2;
        }
        if (firstIndex <= lastIndex) {
            System.out.println(item + " is " + ++position + " element in array.");
            System.out.println("Method of binary search founded it after " + comparisonCount +
                    " iterations.");
        } else {
            System.out.println(-1);
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }
}
