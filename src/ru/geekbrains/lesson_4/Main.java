package ru.geekbrains.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    static char[][] map;
    static final int SIZE = 3;
    static final int DOTS_TO_VIN = 3;

    static final char DOT_EMPTY = '.';
    static final char DOT_X = 'X';
    static final char DOT_0 = '0';

    public static void main(String[] args)
    {
        initMap();
        printMap();

    }
    static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++)
        {

            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    static void printMap()
    {
        for (int i = 0; i<= map.length; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < map.length; i++)
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void makeHumanTurn()
    {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;

        do

            {
                System.out.println("Введите координаты");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isCellValid(x, y));

        map[y][x] = DOT_X;

    }
    static void makeAiTurn()
    {
        Random random = new Random();
        int x;
        int y;

        do
            {
                System.out.println("Компьютер вводит координаты");
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);

            } while (isCellValid(x, y));
        System.out.println("Компьютер сходилв точку " + (x +1) + " " + (y + 1) + ". Ваш ход.");
    }
    static boolean isCellValid(int x, int y)
    {
        if (x < 0 || x >= SIZE || y >= SIZE)
        {
            return false;
        }
        else if (map[x][y] == DOT_EMPTY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
