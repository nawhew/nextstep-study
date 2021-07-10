package com.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
        for (int i = 0; i < size; i++) {
            randomBalls.add(new Ball(createRandomNumber()));
        }
        return null;
    }

    private static int createRandomNumber() {
        int number = 0;
        while(number <= 0 || number >= RANDOM_BALL_NUMBER_MAX_BOUND) {
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
