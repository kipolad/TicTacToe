/**
 * Created by Yulya Telysheva
 */
package main.java;

import java.util.Scanner;

public class UserView {
    public int getLevelChoice() {
        System.out.print("""
                Hello. Let's play :)
                What level do you choose?
                1 - easy, 2 - middle, 3 hard, 0 - exit.
                Your choice:\040""");
        Scanner console = new Scanner(System.in);
        String userChoice = console.nextLine();

        while (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3") && !userChoice.equals("0")) {
            System.out.print("""
                Try again -> 1 - easy, 2 - middle, 3 hard, 0 - exit.
                Your choice:\040""");
            userChoice = console.nextLine();
        }
        return Integer.parseInt(userChoice);
    }
}
