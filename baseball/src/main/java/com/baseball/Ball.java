package com.baseball;

import java.util.Objects;

public class Ball {

    private final int number;

    public Ball(int number) {
        this.validate(number);
        this.number = number;
    }

    /**
     * 주어진 숫자가 1 ~ 9사이의 적합한 값인지 확인합니다.
     * 적합한 경우 받은 숫자를 그대로 리턴하며,
     * 적합하지 않은 경우 오류를 발생합니다.
     * @param number
     * @return
     */
    public void validate(int number) {
        if(number < 1 || number > 9) {
            throw new IllegalArgumentException("공의 숫자가 적합하지 않습니다.");
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return getNumber() == ball.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
