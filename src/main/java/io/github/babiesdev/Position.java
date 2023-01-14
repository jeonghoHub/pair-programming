package io.github.babiesdev;

import java.util.Objects;

public record Position(int value) {

    public Position {
        validate(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position1)) return false;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validate(int position) {
        if (position < 0 || position > 69) {
            throw new IllegalArgumentException(String.format("위치는 0 ~ 69 사이의 값이어야 합니다. (현재: %d)", position));
        }
    }
}
