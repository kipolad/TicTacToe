/**
 * Created by Yulya Telysheva
 */
package main.java.levels;

import java.util.Random;
import java.util.Scanner;

public class MiddleLevel {
    Random random;
    Scanner scanner;
    char[][] map;

    public MiddleLevel() {
        random = new Random();
        scanner = new Scanner(System.in);
        map = new char[5][5];
    }

    public void game() {
        initTable();
        printTableNumbers();
        System.out.println("You need to make a line of 4 elements");
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

    void initTable() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                map[x][y] = '.';
            }
        }
    }

    void printTableNumbers() {
        for (int x = 1; x <= 5; x++) {
            for (int y = 1; y <= 5; y++) {
                System.out.print(y + "_" + x + "|");
            }
            System.out.println();
        }
    }


    void printMap() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.print("Horizontal - x [1..5] ");
            x = userNum();
            System.out.print("Vertical - y [1..5] ");
            y = userNum();
        } while (!(map[x][y] == '.'));
        map[x][y] = 'x';
    }

    int userNum() {
        String number;
        do {
            System.out.print("Enter: ");
            number = scanner.nextLine();
        } while (!number.equals("1") &&
                !number.equals("2") &&
                !number.equals("3") &&
                !number.equals("4") &&
                !number.equals("5"));
        return Integer.parseInt(number) - 1;
    }


    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(5);
            y = random.nextInt(5);
        } while (!(map[x][y] == '.'));
        map[x][y] = 'o';
    }

    boolean checkWin(char ch) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if ((map[i][j] == ch && map[i][j + 1] == ch && map[i][j + 2] == ch && map[i][j + 3] == ch) ||
                        (map[j][i] == ch && map[j + 1][i] == ch && map[j + 2][i] == ch && map[j + 3][i] == ch)) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            if ((map[i][i] == ch &&
                    map[i + 1][i + 1] == ch &&
                    map[i + 2][i + 2] == ch &&
                    map[i + 3][i + 3] == ch) ||
                    (map[i][1 - i] == ch &&
                            map[i + 1][2 - i] == ch &&
                            map[i + 2][3 - i] == ch &&
                            map[i + 3][4 - i] == ch) ||
                    (map[0][4 - i] == ch &&
                            map[1][3 - i] == ch &&
                            map[2][2 - i] == ch &&
                            map[3][1 - i] == ch) ||
                    (map[1][i + 3] == ch &&
                            map[2][i + 2] == ch &&
                            map[3][i + 1] == ch &&
                            map[4][i] == ch)) return true;
        }
        return false;
    }

    boolean isTableFull() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (map[x][y] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
