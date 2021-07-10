package com.baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private final List<Ball> balls;

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
