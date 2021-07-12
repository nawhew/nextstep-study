package com.baseball;

import java.util.Scanner;

public class Application {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // TODO 반복문으로 변경
        PlayBaseball playBaseball = new PlayBaseball(new Balls());
        while (playBaseball != null) {
            System.out.println("숫자를 입력해주세요 : ");
            Balls userBalls = new Balls(scanner.nextLine());

            String result = playBaseball.play(userBalls);
            System.out.println(result);
            if(result.equals("3 스트라이크")) {
                if(askContinueGame()) {
                    playBaseball = new PlayBaseball(new Balls());
                    System.out.println("게임을 다시 시작합니다.");
                } else {
                    break;
                }
            }
        }
    }

    private static boolean askContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            try {
                return isContinueGame(Integer.parseInt(scanner.nextLine()));
            } catch (IllegalArgumentException e) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
    }

    private static boolean isContinueGame(int input) {
        if(input == 1) {
            return true;
        }
        if(input == 2) {
            return false;
        }
        throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
