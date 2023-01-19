package io.github.babiesdev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PositionTests {
    @ParameterizedTest
    @ValueSource(ints = {-1, 70})
    void 위치가_0미만_69초과할_경우_예외가_발생한다(int value) {
        assertThatThrownBy(() -> new Position(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(String.format("위치는 0 ~ 69 사이의 값이어야 합니다. (현재: %d)", value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 69})
    void 생성된다(int value) {
        assertThatCode(() -> new Position(value))
            .doesNotThrowAnyException();
    }

    @Test
    void 자신의_값을_반환한다() {
        final var position = new Position(0);

        assertThat(position.value()).isEqualTo(0);
    }
}
