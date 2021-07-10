package com.baseball;

import java.util.Map;

public enum  BaseballResult {
    STRIKE("스트라이크")
    , BALL("볼")
    , NOTHING("낫싱")
    ;

    private final String displayName;

    BaseballResult(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * 주어진 유저공을 컴퓨터 볼과 비교하여 결과를 반환합니다.
     * @param userBall
     * @param index
     * @param computerBalls
     * @return
     */
    public static BaseballResult calculateResult(Ball userBall, int index, Balls computerBalls) {
        for (int i = 0; i < computerBalls.size(); i++) {
            if(isStrike(userBall, index, computerBalls.getBall(i), i)) {
                return BaseballResult.STRIKE;
            }
            if(isBall(userBall, index, computerBalls.getBall(i), i)) {
                return BaseballResult.BALL;
            }
        }
        return BaseballResult.NOTHING;
    }

    /**
     * 스트라이크 여부를 반환합니다.
     * 유저볼과 컴퓨터볼의 숫자와 위치가 모두 같은 경우 스트라이크입니다.
     * @param userBall
     * @param userBallIndex
     * @param computerBall
     * @param computerBallIndex
     * @return
     */
    private static boolean isStrike(Ball userBall, int userBallIndex, Ball computerBall, int computerBallIndex) {
        return userBall.equals(computerBall) && userBallIndex == computerBallIndex;
    }

    /**
     * 볼 여부를 반환합니다.
     * 유저볼과 컴퓨터볼의 숫자가 같고 위치만 다른 경우 볼입니다.
     * @param userBall
     * @param userBallIndex
     * @param computerBall
     * @param computerBallIndex
     * @return
     */
    private static boolean isBall(Ball userBall, int userBallIndex, Ball computerBall, int computerBallIndex) {
        return userBall.equals(computerBall) && userBallIndex != computerBallIndex;
    }

    /**
     * 축적된 결과를 보기 좋게 문자열로 변환하여 반환합니다.
     * 포맷 : N 스트라이크 M 볼
     * 포맷 2 (스트라이크와 볼이 없고 낫싱만 3인 경우) : 낫싱
     * @return
     */
    public static String getPrettyPrintResultString(Map<BaseballResult, Integer> results) {
        String result = "";

        if (isPrintNothing(results)) {
            return BaseballResult.NOTHING.getDisplayName();
        }
        result = addPrintStrike(result, results);
        result = addPrintBall(result, results);
        return result;
    }

    /**
     * 볼이 있는 경우 볼을 출력하기 위한 문자열을 가져 옵니다
     * @param result
     * @return
     */
    private static String addPrintBall(String result, Map<BaseballResult, Integer> results) {
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
    private static String addPrintStrike(String result, Map<BaseballResult, Integer> results) {
        Integer strikeCount = results.get(BaseballResult.STRIKE);
        if(strikeCount != null && strikeCount != 0) {
            result = strikeCount + " " + BaseballResult.STRIKE.getDisplayName();
        }
        return result;
    }

    private static boolean isPrintNothing(Map<BaseballResult, Integer> results) {
        Integer nothingCount = results.get(BaseballResult.NOTHING);
        return nothingCount != null && nothingCount == 3;
    }
}
