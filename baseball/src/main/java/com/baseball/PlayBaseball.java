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
        return this.getPrettyPrintResultString(results);
    }

    /**
     * 축적된 결과를 보기 좋게 문자열로 변환하여 반환합니다.
     * 포맷 : N 스트라이크 M 볼
     * 포맷 2 (스트라이크와 볼이 없고 낫싱만 3인 경우) : 낫싱
     * @return
     */
    private String getPrettyPrintResultString(Map<BaseballResult, Integer> results) {
        String result = "";

        if (this.isPrintNothing(results)) {
            return BaseballResult.NOTHING.getDisplayName();
        }
        result = this.addPrintStrike(result, results);
        result = this.addPrintBall(result, results);
        return result;
    }

    /**
     * 볼이 있는 경우 볼을 출력하기 위한 문자열을 가져 옵니다
     * @param result
     * @return
     */
    private String addPrintBall(String result, Map<BaseballResult, Integer> results) {
        Integer ballCount = results.get(BaseballResult.BALL);
        if(ballCount != null && ballCount != 0) {
            if(result.length() != 0) {
                result = result + " ";
            }
            result = result + ballCount + " " + BaseballResult.BALL.getDisplayName();
        }
        return result;
    }

    /**
     * 스트라이크가 있는 경우 스트라이크를 출력하기 위한 문자열을 가져옵니다.
     * @param result
     * @return
     */
    private String addPrintStrike(String result, Map<BaseballResult, Integer> results) {
        Integer strikeCount = results.get(BaseballResult.STRIKE);
        if(strikeCount != null && strikeCount != 0) {
            result = strikeCount + " " + BaseballResult.STRIKE.getDisplayName();
        }
        return result;
    }

    private boolean isPrintNothing(Map<BaseballResult, Integer> results) {
        Integer nothingCount = results.get(BaseballResult.NOTHING);
        return nothingCount != null && nothingCount == 3;
    }
}
