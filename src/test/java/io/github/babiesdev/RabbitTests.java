package io.github.babiesdev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RabbitTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 왼쪽으로_최대_5만큼_이동한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));
        rabbit.leftMove(moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 오른쪽으로_최대_5만큼_이동한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));
        rabbit.rightMove(moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void 왼쪽으로_1미만_5초과_이동할_경우_예외가_발생한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));
        rabbit.leftMove(moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void 오른쪽으로_1미만_5초과_이동할_경우_예외가_발생한다(int moveCount) {
        var rabbit = new Rabbit(new Position(0));
        rabbit.rightMove(moveCount);
    }

    @Test
    void 자신의_위치를_반환한다() {
        var rabbit = new Rabbit(new Position(0));

        Position position = rabbit.position();
        assertThat(position).isEqualTo(new Position(0));
    }
}
