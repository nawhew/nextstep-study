package com.baseball;

import java.util.*;
import java.util.stream.Collectors;

public class Balls {

    private static final int RANDOM_BALL_SIZE = 3;
    private static final int RANDOM_BALL_NUMBER_MAX_BOUND = 10;

    private final List<Ball> balls;

    public Balls() {
        this(createRandomBalls(RANDOM_BALL_SIZE));
    }

    private static List<Ball> createRandomBalls(int size) {
        List<Ball> randomBalls = new ArrayList<>();
        Set<Integer> pickNumbers = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int number = 0;
            while(number <= 0) {
                number = new Random().nextInt(RANDOM_BALL_NUMBER_MAX_BOUND);
                if(number != 0 && pickNumbers.contains(number)) {
                    continue;
                }
                pickNumbers.add(number);
            }
            randomBalls.add(new Ball(number));
        }
        return randomBalls;
    }

    private static int createRandomNumber() {
        int number = 0;
        while(number <= 0) {
            number = new Random().nextInt(RANDOM_BALL_NUMBER_MAX_BOUND);
        }
        return number;
    }

    public Balls(String balls) {
        this(convertBalls(balls));
    }

    public Balls(List<Ball> balls) {
        this.validate(balls);
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return this.balls;
    }

    private static List<Ball> convertBalls(String balls) {
        return Arrays.stream(balls.split(""))
                .map(s -> new Ball(Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    private void validate(List<Ball> balls) {
        if(balls.size() != 3) {
            throw new IllegalArgumentException("공은 총 3개여야합니다.");
        }
    }

    public int size() {
        return this.balls.size();
    }

    public Ball getBall(int index) {
        return this.balls.get(index);
    }
}
