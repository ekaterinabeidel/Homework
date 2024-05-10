package org.example._2024_05_03.input;
/*    Пользователь вводит неограниченное количество слов.
 *    Ввод завершается, когда пользователь вводит команду stop.
 *    Программа должна вывести введённые слова в следующем порядке:
 *    первое слово, последнее слово, второе слово, предпоследнее слово и т.д.
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//public class Control {
//    Deque<String> words = new LinkedList<>();
//    Scanner scanner = new Scanner(System.in);
//        System.out.println("enter messages");
//    String inputMessage = "";
//        while (true){
//        inputMessage = scanner.nextLine();
//        if(inputMessage.equals("stop")) break;
//        words.add(inputMessage);
//    }
//        while (!words.isEmpty()){
//        System.out.println(words.removeFirst());
//        if(!words.isEmpty()){
//            System.out.println(words.removeLast());
//        }
//    }
//}
