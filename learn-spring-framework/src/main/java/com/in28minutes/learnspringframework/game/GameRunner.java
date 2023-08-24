package com.in28minutes.learnspringframework.game;

public class GameRunner {
    GamingConsole game;
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game : " + game); //logging을 사용하는게 좋음 (나중에 다룸)
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
