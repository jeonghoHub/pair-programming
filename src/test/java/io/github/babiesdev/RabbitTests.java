package io.github.babiesdev;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RabbitTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 왼쪽으로_최대_5만큼_이동한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));
        rabbit.leftMove(moveCount);

        assertThat(rabbit.positionValue()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 오른쪽으로_최대_5만큼_이동한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));
        rabbit.rightMove(moveCount);

        assertThat(rabbit.positionValue()).isEqualTo(-moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void 왼쪽으로_1미만_5초과_이동할_경우_예외가_발생한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));

        assertThatThrownBy(() -> rabbit.leftMove(moveCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(String.format("이동할 수 있는 거리는 1 ~ 5 사이의 값이어야 합니다. (현재: %d)", moveCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void 오른쪽으로_1미만_5초과_이동할_경우_예외가_발생한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));

        assertThatThrownBy(() -> rabbit.rightMove(moveCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(String.format("이동할 수 있는 거리는 1 ~ 5 사이의 값이어야 합니다. (현재: %d)", moveCount));
    }

    @Test
    void 자신의_위치를_반환한다() {
        var rabbit = new Rabbit(new Position(0));

        Position position = rabbit.position();
        assertThat(position).isEqualTo(new Position(0));
    }
}
