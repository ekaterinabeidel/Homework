package org.example._2024_05_13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class TryAndCatch {
    //Простой пример использования блоков try и catch для обработки исключений.
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        }
    }
}

class MultipleCatches {
    //Позволяет обработать несколько различных типов исключений в одном блоке catch
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Произошло деление на ноль или попытка доступа к null!");
        }
    }
}

class NestedTry {
    //Вложенный блок try-catch, используется для обработки исключений внутри другого блока try.
    public static void main(String[] args) {
        try {
            try {
                int[] arr = new int[5];
                arr[10] = 10; // Выход за пределы массива
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Выход за пределы массива!");
            }
        } catch (Exception e) {
            System.out.println("Общая ошибка!");
        }
    }
}

class Throw {
    //Позволяет явно выбросить исключение.
    public static void main(String[] args) {
        throw new ArithmeticException("Исключение вызвано явным образом!");
    }
}

class Throws {
    //Используется для указания того, что метод может выбросить исключение определенного типа.
    public static void main(String[] args) throws IOException {
        // Код, который может вызвать исключение IOException
    }
}

class Finally {
    //Блок finally используется для выполнения кода независимо от того, возникало ли исключение или нет.
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        } finally {
            System.out.println("Блок finally всегда выполняется!");
        }
    }
}

class ChainedExceptions {
    //Позволяет связать несколько исключений в цепочку.
    public static void main(String[] args) {
        try {
            try {
                int[] arr = new int[5];
                arr[10] = 10; // Выход за пределы массива
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NullPointerException("Ссылка на массив null");
            }
        } catch (Exception e) {
            System.out.println("Исключение: " + e);
            System.out.println("Причина: " + e.getCause());
        }
    }
}

class TryWithResources {
    //Введено в Java 7, позволяет автоматически закрывать ресурсы (например, файлы или сетевые соединения) после их использования.
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}

class MultiCatch {
    // Введено в Java 7, позволяет обрабатывать несколько исключений в одном блоке catch.
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Произошло деление на ноль или попытка доступа к null!");
        }
    }
}

class MorePreciseRethrow {
    //В Java 7 добавлена возможность использовать механизм перехвата и повторного генерирования исключений с более точным типом.
    public static void main(String[] args) throws IOException {
        try {
            throwFirstException();
        } catch (IOException e) {
            // Обработка IOException
            throwSecondException();
        }
    }

    public static void throwFirstException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void throwSecondException() throws IOException {
        throw new IOException();
    }
}



