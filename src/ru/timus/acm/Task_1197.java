package ru.timus.acm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Условие этой задачи очень простое: вам всего лишь надо определить, сколько клеток находится под боем шахматного коня, одиноко стоящего на шахматной доске.
На всякий случай напомним, что конь ходит буквой «Г» — на две клетки по горизонтали или вертикали в любом направлении,
и потом на одну клетку в направлении, перпендикулярном первоначальному.
Исходные данные
В первой строке находится единственное число N, 1 ≤ N ≤ 100 — количество тестов.
В каждой из последующих N строк содержится очередной тест: два символа (маленькая латинская буква от 'a' до 'h' и цифра от 1 до 8) — стандартное шахматное обозначение клетки,
на которой стоит конь. При этом буква обозначает вертикаль, а цифра — горизонталь.
Результат
Выведите N строк: в каждой из них должно находиться единственное число — количество клеток шахматной доски, находящихся под боем коня.
 */
public class Task_1197 {

    public static void main(String str[]) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        int size = 8;
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

        int n = Integer.parseInt(consoleReader.readLine());
        List<String> tests = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            tests.add(consoleReader.readLine().toLowerCase());


        for (String s : tests) {
            int column = s.charAt(0) - 'a';
            int row = s.charAt(1) - '1';

            int currentX, currentY, positionCount = 0;
            for (int i = 0; i < size; i++) {
                currentX = column + dx[i];
                currentY = row + dy[i];
                if (currentX >= 0 && currentX < size && currentY >= 0 && currentY < size)
                    positionCount++;
            }
            System.out.println(positionCount);
        }
    }
}
