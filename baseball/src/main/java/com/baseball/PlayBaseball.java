package com.baseball;

import java.util.HashMap;
import java.util.Map;

public class PlayBaseball {

    private final int[] userBalls;
    private final int[] computerBalls;

    private final Map<BaseballResult, Integer> results = new HashMap<>();

    public PlayBaseball(int[] userBalls, int[] computerBalls) {
        this.userBalls = userBalls;
        this.computerBalls = computerBalls;
    }

    /**
     * 주어진 유저와 컴퓨터의 공들을 바교하여 결과를 만듦니다.
     */
    public void play() {
        for (int i = 0; i < this.userBalls.length; i++) {
            int userBall = this.userBalls[i];
            this.addResult(userBall, i, this.computerBalls);
        }
//        return this.baseballResult;
    }

    /**
     * 주어진 유저공을 컴퓨터공과 비교하여 결과값의 카운트를 1 증가시킵니다.
     * @param userBall
     * @param i
     * @param computerBalls
     */
    public void addResult(int userBall, int i, int[] computerBalls) {
        BaseballResult baseballResult = BaseballResult.calculateResult(userBall, i, computerBalls);
        this.results.put(baseballResult, this.results.getOrDefault(baseballResult, 0) + 1);
    }

    /**
     * 축적된 결과를 보기 좋게 문자열로 변환하여 반환합니다.
     * 포맷 : N 스트라이크 M 볼
     * 포맷 2 (스트라이크와 볼이 없고 낫싱만 3인 경우) : 낫싱
     * @return
     */
    public String getPrintResult() {
        String result = "";

        if (this.isPrintNothing()) {
            return BaseballResult.NOTHING.getDisplayName();
        }
        result = this.getPrintStrike(result);
        result = this.getPrintBall(result);
        return result;
    }

    /**
     * 볼이 있는 경우 볼을 출력하기 위한 문자열을 가져 옵니다
     * @param result
     * @return
     */
    private String getPrintBall(String result) {
        Integer ballCount = this.results.get(BaseballResult.BALL);
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
    private String getPrintStrike(String result) {
        Integer strikeCount = this.results.get(BaseballResult.STRIKE);
        if(strikeCount != null && strikeCount != 0) {
            result = strikeCount + " " + BaseballResult.STRIKE.getDisplayName();
        }
        return result;
    }

    private boolean isPrintNothing() {
        Integer nothingCount = this.results.get(BaseballResult.NOTHING);
        return nothingCount != null && nothingCount == 3;
    }
}
