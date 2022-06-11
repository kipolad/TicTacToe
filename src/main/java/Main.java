/**
 * Created by Yulya Telysheva
 */
package main.java;

import main.java.levels.EasyLevel;
import main.java.levels.HardLevel;
import main.java.levels.MiddleLevel;

public class Main {
    public static void main(String[] args) {
        int gameLevel = new UserView().getLevelChoice();
        switch (gameLevel) {
            case 0 -> System.out.println("Game over!");
            case 1 -> new EasyLevel().game();
            case 2 -> new MiddleLevel().game();
            case 3 -> new HardLevel().game();
            default -> {
            }
        }
    }
}
