package ru.timus.acm;

import java.math.BigInteger;
import java.util.Scanner;
/*
Дядюшка Скрудж изготовил множество золотых слитков и пронумеровал их последовательностями из нулей и единиц длины 2N-2 (номер каждого слитка выбит на нём). Известно, что
Любые два слитка имеют различные номера.
В номере любого из слитков не встречается двух нулей подряд.
Для любой последовательности, отвечающей свойству 2, слиток с таким номером есть в коллекции дядюшки Скруджа.
Затем дядюшка Скрудж решил разложить слитки по сейфам. Коды к сейфам подобраны схожим образом с номерами слитков. А именно
Код к сейфу является последовательностью из нулей и единиц длины N-2.
Коды к любым двум сейфам различаются.
В коде ни одного из сейфов не встречается двух нулей подряд.
Для любого кода, отвечающего свойствам 1 и 3, сейф с таким кодом стоит в хранилище дядюшки Скруджа.
Дядюшка Скрудж положил в каждый из сейфов одинаковое количество золотых слитков, а оставшиеся слитки (их осталось меньше, чем сейфов) решил отправить на благотворительность.
Найдите, сколько слитков лежит в каждом из сейфов дядюшки Скруджа.
Исходные данные
Целое число 3 ≤ N ≤ 70000.
Результат
Выведите единственное число – количество слитков в каждом из сейфов.

 */
public class Task_1462 {

    static BigInteger[] fib = new BigInteger[2000];

    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;

        for (int i = 2; i < 2000; i++)
            fib[i] = fib[i - 1].add(fib[i - 2]);

        System.out.println(f(n * 2).divide(f(n)));

    }

    private static BigInteger f(int n) {
        if (n < 2000) return fib[n];
        if (n % 2 == 0)
            return f(n / 2).multiply(f(n / 2 - 1).add(f(n / 2 + 1)));
        else {
            BigInteger t, p;
            t = f(n / 2);
            p = f(n / 2 + 1);
            return (t.multiply(t)).add(p.multiply(p));
        }
    }
}
