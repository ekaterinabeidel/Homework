package org.example._2024_04_09;

public class TwoDimensionalBinarySearch {

    public static void main(String[] args) {

        int[][] table = {
                {2, 4, 10, 15, 24},
                {3, 7, 19, 21, 29},
                {5, 8, 25, 28, 44},
                {6, 11, 26, 33, 55},
                {9, 13, 27, 36, 66}
        };
        int searchNumber = 25;

        printTable(table);
        printSearchNumber(table, searchNumber);

    }

    public static void printTable(int[][] table) {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //todo

    /**
     * @param table        матрица в которой все числа отсортированы справа налево и сверху вниз
     * @param searchNumber число которое ищем
     * @return true - если число есть матрице
     */

    public static boolean isConsistNumber(int[][] table, int searchNumber) {
        boolean found = false;

        int i = 0;
        int j = table[0].length - 1;

        while (i < table.length && j >= 0) {
            if (table[i][j] == searchNumber) {
                found = true;
                break;
            } else if (table[i][j] > searchNumber) {
                j--;
            } else {
                i++;
            }
        }
        return found;
    }

    public static void printSearchNumber(int[][] table, int searchNumber) {
        if (isConsistNumber(table, searchNumber)) {
            System.out.println("Число " + searchNumber + " найдено в массиве");
        } else {
            System.out.println("Число " + searchNumber + " не найдено в массиве");
        }
    }

}






