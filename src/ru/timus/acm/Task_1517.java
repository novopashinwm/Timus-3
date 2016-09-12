package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Вступление
Не успели жители Албании привыкнуть к свободе слова (более подробно эта история описана в задаче «Свобода слова»), как им на голову свалилась ещё и свобода выбора.
В самом ближайшем будущем населению предстоит пережить первые в истории страны демократические президентские выборы.
О намерении бороться за высокий пост уже объявили два самых ярких албанских политика последних лет – либерал Мухаммед Тахир-оглы и его извечный оппонент консерватор Ахмед Касым-бей.
Задача
Следуя демократическим традициям, перед выборами оба кандидата развлекаются тем, что выливают друг другу на головы тонны грязи под одобрительные возгласы избирателей.
Каждый кандидат при любом удобном случае произносит предвыборную речь,
в которой обвиняет своего политического оппонента в коррупции, неуважении к старшим, пособничестве террористам и вообще всячески демонстрирует своё уважение к противнику.
В результате выступления Мухаммеда и Ахмеда стали похожи друг на друга до такой степени, что избирателям теперь вообще до лампочки, за кого голосовать.
Этим хочет воспользоваться третий кандидат в президенты – председатель социалистической партии Албании товарищ Ктулху.
Он поленился написать себе предвыборную речь, но между тем заметил, что некоторые фрагменты выступлений г-на Тахир-оглы и г-на Касым-бея полностью совпадают.
Тогда тов. Ктулху решил взять самый длинный совпадающий фрагмент и сделать его своей предвыборной речью.
Исходные данные
Первая строка содержит целое число N (1 ≤ N ≤ 100000). Вторая строка содержит речь г-на Тахир-оглы. Третья строка содержит речь г-на Касым-бея.
Каждая речь состоит из N заглавных латинских букв.
Результат
Вывести речь тов. Ктулху. Если задача имеет несколько решений, то вывести любое из них.
 */
public class Task_1517 {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        String line1 = consoleReader.readLine();
        String line2 = consoleReader.readLine();
        System.out.println(longestCS(n, line1, line2));
    }


    private static String longestCS(int n, String a, String b) {
        if (a.equals(b)) return a;

        int[][] matrix = new int[n][n];

        int maxLength = 0;
        int maxI = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a.charAt(i) == b.charAt(j)) {
                    if (i != 0 && j != 0)
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    else
                        matrix[i][j] = 1;
                    if (matrix[i][j] > maxLength) {
                        maxLength = matrix[i][j];
                        maxI = i;
                    }
                }

        return a.substring(maxI - maxLength + 1, maxI + 1);
    }
}
