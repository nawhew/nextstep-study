package com.baseball;

import java.util.HashMap;
import java.util.Map;

public class PlayBaseball {

    private final Balls computerBalls;

    public PlayBaseball(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    /**
     * 주어진 유저와 컴퓨터의 공들을 바교하여 결과를 만듦니다.
     * @return
     */
    public String play(Balls userBalls) {
        final Map<BaseballResult, Integer> results = new HashMap<>();
        for (int i = 0; i < userBalls.size(); i++) {
            Ball userBall = userBalls.getBall(i);
            BaseballResult baseballResult = BaseballResult.calculateResult(userBall, i, computerBalls);
            results.put(baseballResult, results.getOrDefault(baseballResult, 0) + 1);
        }
        return BaseballResult.getPrettyPrintResultString(results);
    }
}
