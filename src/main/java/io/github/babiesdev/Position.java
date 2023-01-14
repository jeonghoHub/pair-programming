package io.github.babiesdev;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = validate(position);
    }

    public int value() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position1)) return false;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    private static int validate(int position) {
        if (position < 0 || position > 69) {
            throw new IllegalArgumentException(String.format("위치는 0 ~ 69 사이의 값이어야 합니다. (현재: %d)", position));
        }
        return position;
    }
}
