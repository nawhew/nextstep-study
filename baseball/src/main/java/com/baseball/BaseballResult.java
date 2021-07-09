package com.baseball;

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
    public static BaseballResult calculateResult(int userBall, int index, int[] computerBalls) {
        for (int i = 0; i < computerBalls.length; i++) {
            if(isStrike(userBall, index, computerBalls[i], i)) {
                return BaseballResult.STRIKE;
            }
            if(isBall(userBall, index, computerBalls[i], i)) {
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
    private static boolean isStrike(int userBall, int userBallIndex, int computerBall, int computerBallIndex) {
        return userBall == computerBall && userBallIndex == computerBallIndex;
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
    private static boolean isBall(int userBall, int userBallIndex, int computerBall, int computerBallIndex) {
        return userBall == computerBall && userBallIndex != computerBallIndex;
    }
}
