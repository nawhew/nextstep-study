package com.baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayBaseballTest {

    @ParameterizedTest
    @CsvSource({"123,456,낫싱"
            , "123,124,2 스트라이크", "123,123,3 스트라이크"
            , "123,321,1 스트라이크 2 볼", "123,451,1 볼"})
    @DisplayName("유저와 컴퓨터에 주어진 3가지 수를 비교하여 결과를 보는 테스트")
    void play(String userBalls, String computerBalls, String expected) {
        // given
        Balls userNumberBalls = new Balls(userBalls);
        Balls computerNumberBalls = new Balls(computerBalls);
        PlayBaseball playBaseball = new PlayBaseball(computerNumberBalls);

        // when
        String result = playBaseball.play(userNumberBalls);

        // then
        assertThat(result).isEqualTo(expected);
    }
}