package org.example._2024_03_25;

import java.util.Arrays;
/*
11: Найдите самую длинную строку в массиве строк.
12: Подсчитайте, сколько раз в массиве встречается строка, равная заданной.
13: Проверьте, все ли строки в массиве имеют одинаковую длину.
14: Найдите строку в массиве, содержащую наибольшее количество гласных.
15: Сформируйте новую строку, повторяя каждую строку в массиве столько раз, какова ее длина
*/
public class Test {
    public static void main(String[] args) {
        double[] array = {5, 6, 7, 8, 9, 5, 5, 10};
        double findMe = 0;
        int duplicate = 5;

        System.out.println("1: Найдите сумму всех нечетных элементов массива: "
                + getSumOfOddElements(array));
        System.out.println("2: Найдите максимальный элемент в массиве: "
                + findMaxElement(array));
        boolean isFound = searchForElement(array, findMe);
        System.out.println("3: Проверьте, содержит ли массив заданный элемент: "
                + isFound);
        System.out.println("4: Посчитайте, сколько раз заданный элемент встречается в массиве: "
                + countOfDuplicates(array, duplicate));
        System.out.println("5: Инвертируйте элементы массива: "
                + Arrays.toString(invertElements(Arrays.copyOf(array, array.length))));
        System.out.println("6: Найдите сумму всех нечетных элементов массива которые находятся на нечетных индексах: "
                + getSumOfOddElementsOddIndex(array));
        System.out.println("7: Найдите сумму всех четных элементов массива которые находятся на нечетных индексах: "
                + getSumOfEvenElementsOddIndex(array));
        System.out.println("8: Найдите произведение всех нечетных элементов массива: "
                + getProductOfAllOddElements(array));
        System.out.println("9: Найдите разность между максимальным и минимальным элементами массива: "
                + getDifferenceBetweenMaxAndMin(array));
        System.out.println("10: Найдите сумму элементов массива, " +
                "которые находятся между первым и последним положительными элементами: "
                + getSumBetweenFirstAndLastPositiveElements(array));
    }

    public static double getSumOfOddElements(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static double findMaxElement(double[] array) {
        double maxElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    public static double findMinElement(double[] array) {
        double minElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        return minElement;
    }

    public static boolean searchForElement(double[] array, double findMe) {
        for (int i = 0; i < array.length; i++) {
            if (findMe == array[i]) {
                return true;
            }
        }
        return false;
    }

    public static int countOfDuplicates(double[] array, int duplicate) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == duplicate) {
                count++;
            }
        }
        return count;
    }

    public static double[] invertElements(double[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            double number = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = number;
        }
        return array;
    }

    public static double getSumOfOddElementsOddIndex(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2 != 0) && (i % 2 != 0)) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static double getSumOfEvenElementsOddIndex(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2 == 0) && (i % 2 != 0)) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static double getProductOfAllOddElements(double[] array) {
        double product = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                product *= array[i];
            }
        }
        return product;
    }

    public static double getDifferenceBetweenMaxAndMin(double[] array) {
        double maxElement = findMaxElement(array);
        double minElement = findMinElement(array);
        return maxElement - minElement;
    }

    public static double getSumBetweenFirstAndLastPositiveElements(double[] array) {
        int firstPositiveIndex = -1;
        int lastPositiveIndex = -1;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                firstPositiveIndex = i;
                break;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                lastPositiveIndex = i;
                break;
            }
        }
        for (int i = firstPositiveIndex + 1; i < lastPositiveIndex; i++) {
            sum += array[i];
        }
        return sum;


    }
}
