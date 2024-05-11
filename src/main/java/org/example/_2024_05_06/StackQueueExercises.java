package org.example._2024_05_06;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueueExercises {

    public static void main(String[] args) {
        // Задача 1: Реверс элементов в очереди.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);

        // Задача 2: Проверка на сбалансированность скобок.
        String expression = "{[()]}";
        System.out.println("Expression: " + expression + " is balanced: " + isBalanced(expression));

        // Задача 3: Сортировка стека с использованием дополнительного стека.
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);

        // Задача 4: Первый неповторяющийся символ.
        String stream = "geeksforgeeks";
        System.out.println("First non-repeating character: " +firstNonRepeating(stream));

        // Задача 5: Генерация всех возможных правильных комбинаций скобок.
        int n = 3;
        generateParenthesis(n);
    }

    // Задача 1: Реверс очереди.
    // В контексте задачи о переворачивании очереди
    // методы poll() и add() используются для удаления элементов из начала очереди и добавления элементов в конец очереди соответственно.
    // методы push() и pop() используются для временного хранения элементов в стеке в процессе переворачивания.
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        // Переносим все элементы из очереди в стек
        // poll() используется для извлечения и удаления элемента из начала очереди.
        // Если очередь пуста, poll() возвращает null.
        // push() используется для добавления элемента в вершину стека.
        // Новый элемент помещается наверху стека.
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        // Извлекаем элементы из стека и добавляем их обратно в очередь
        // pop() удаляет и возвращает элемент из вершины стека.
        // Если стек пуст, pop() вызовет исключение.
        // add() используется для добавления элемента в конец очереди.
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    // Задача 2: Проверка сбалансированности скобок.
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char bracket = expression.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                // Если скобка открывающая, помещаем ее в стек
                stack.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                // Если скобка закрывающая, проверяем соответствие с открывающей на вершине стека
                if (stack.isEmpty()) {
                    return false; // Если стек пуст, то скобки не сбалансированы
                }
                char top = stack.pop();
                if ((bracket == ')' && top == '(') ||
                        (bracket == ']' && top == '[') ||
                        (bracket == '}' && top == '{')) {
                    continue; // Если скобки совпадают, продолжаем проверку
                } else {
                    return false; // Иначе, скобки не сбалансированы
                }
            }
        }
        // Если после обработки всех символов стек не пуст, значит есть незакрытые скобки
        return stack.isEmpty();
    }

        // Задача 3: Сортировка стека.
        public static void sortStack (Stack < Integer > stack) {
            Stack<Integer> tempStack = new Stack<>();
            // Пока исходный стек не пуст,
            // извлекаем элементы из него и помещаем их во временный стек
            while (!stack.isEmpty()) {
                int current = stack.pop();

                // Пока временный стек не пуст и вершина временного стека больше текущего элемента,
                // переносим элементы из временного стека обратно в исходный стек
                while (!tempStack.isEmpty() && tempStack.peek() > current) {
                    stack.push(tempStack.pop());
                }

                // Помещаем текущий элемент на вершину временного стека
                tempStack.push(current);
            }

            // После завершения сортировки, переносим элементы из временного стека обратно в исходный стек
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

        }

        // Задача 4: Первый неповторяющийся символ.
        public static char firstNonRepeating (String stream){
            // Создаем массив для подсчета частоты появления каждой буквы
            int[] charCount = new int[26]; // 26 букв в алфавите

            // Создаем очередь для хранения символов в порядке их появления
            Queue<Character> queue = new LinkedList<>();

            // Проходим по символам в потоке
            for (char c : stream.toCharArray()) {
                // Преобразуем символ в индекс массива (смещение 'a' в алфавите)
                int index = c - 'a';
                // Увеличиваем частоту появления символа
                charCount[index]++;
                // Добавляем символ в очередь
                queue.add(c);

                // Удаляем все повторяющиеся символы из начала очереди
                while (!queue.isEmpty() && charCount[queue.peek() - 'a'] > 1) {
                    queue.poll();
                }
            }
            if (queue.isEmpty()) {
                return '?'; // Возвращаем символ-маркер, чтобы указать, что неповторяющийся символ не найден
            } else {
                return queue.peek(); // Возвращаем первый неповторяющийся символ из очереди
            }

        }

        // Задача 5: Генерация всех возможных правильных комбинаций скобок.
        public static void generateParenthesis ( int n){
            generateParenthesisRecursive("", n, n);
        }

        private static void generateParenthesisRecursive (String current,int open, int close){
                // Базовый случай: если открывающих и закрывающих скобок больше нет, добавляем текущую комбинацию
                if (open == 0 && close == 0) {
                    System.out.println(current);
                    return;
                }

                // Рекурсивно вызываем функцию с добавлением открывающей скобки, если она доступна
                if (open > 0) {
                    generateParenthesisRecursive(current + "(", open - 1, close);
                }

                // Рекурсивно вызываем функцию с добавлением закрывающей скобки, если она доступна и количество открывающих скобок больше закрывающих
                if (close > 0 && open < close) {
                    generateParenthesisRecursive(current + ")", open, close - 1);
                }
            }
        }



/**
 *
 * Если все сделаете, то классика с собеседования:
 * <p>
 * <p>
 * Задача: Реализация очереди с использованием двух стеков
 * <p>
 * Напишите класс QueueUsingTwoStacks, который реализует структуру
 * данных очередь с использованием двух стеков. Класс должен содержать следующие методы:
 * <p>
 * enqueue(int x): Добавляет элемент x в конец очереди.
 * dequeue(): Удаляет и возвращает элемент из начала очереди. Если очередь пуста, возвращает -1.
 * isEmpty(): Возвращает true, если очередь пуста, и false в противном случае.
 * <p>
 * Используйте два стека типа java.util.Stack для реализации очереди.
 * <p>
 * Не забудьте обработать случай, когда попытка удалить элемент из пустой очереди,
 * и убедитесь, что методы выполняются с асимптотической сложностью O(1), когда это возможно.
 * <p>
 * public class QueueUsingTwoStacks {
 * private Stack<Integer> stack1;
 * private Stack<Integer> stack2;
 * <p>
 * public QueueUsingTwoStacks() {
 * stack1 = new Stack<>();
 * stack2 = new Stack<>();
 * }
 *
 */
