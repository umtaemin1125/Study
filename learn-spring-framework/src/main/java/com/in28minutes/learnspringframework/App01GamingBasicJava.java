package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        var game = new SuperContraGame();
//         var game = new MarioGame();
        var game = new PacmanGame(); // 1단계 : 객체 생성
        var gameRunner = new GameRunner(game); //2단계 game을 인수로 갖는 객체 생성
        // + game이라는 종속성(의존성)을 연결 (Wiring of Dependency) game이 gameRunner의 Dependency이다!

        gameRunner.run();


    }
}
