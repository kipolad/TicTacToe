/**
 * Created by Yulya Telysheva
 */
package main.java.levels;

import java.util.Random;
import java.util.Scanner;

public class EasyLevel {
    Random random;
    Scanner scanner;
    char[][] map;

    public EasyLevel() {
        random = new Random();
        scanner = new Scanner(System.in);
        map = new char[3][3];
    }

    public void game() {
        initTable();
        printTableNumbers();
        System.out.println("You need to make a line of 3 elements");
        printMap();
        while (true) {
            turnHuman();
            if (checkWin('x')) {
                System.out.println("YOU WON!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW...");
                break;
            }
            turnAI();
            printMap();
            if (checkWin('o')) {
                System.out.println("AI WON!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW...");
                break;
            }
        }
        System.out.println("GAME OVER!");
        printMap();
    }

    void printTableNumbers() {
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                System.out.print(y + "_" + x + "|");
            }
            System.out.println();
        }
    }

    void initTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                map[x][y] = '.';
            }
        }
    }

    void printMap() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.print("Horizontal - x [1..3] ");
            x = userNum();
            System.out.print("Vertical - y [1..3] ");
            y = userNum();
        } while (!(map[x][y] == '.'));
        map[x][y] = 'x';
    }

    int userNum() {
        String number;
        do {
            System.out.print("Enter: ");
            number = scanner.nextLine();
        } while (!number.equals("1") && !number.equals("2") && !number.equals("3"));
        return Integer.parseInt(number) - 1;
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!(map[x][y] == '.'));
        map[x][y] = 'o';
    }

    boolean checkWin(char ch) {
        for (int i = 0; i < 3; i++) {
            if ((map[i][0] == ch && map[i][1] == ch && map[i][2] == ch) ||
                    (map[0][i] == ch && map[1][i] == ch && map[2][i] == ch)) {
                return true;
            }
        }
        if (map[0][0] == ch && map[1][1] == ch && map[2][2] == ch) return true;
        return map[2][0] == ch && map[1][1] == ch && map[0][2] == ch;
    }

    boolean isTableFull() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (map[x][y] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
