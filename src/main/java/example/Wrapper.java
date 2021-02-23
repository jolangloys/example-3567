package example;

import java.util.Objects;

public class Wrapper<V> extends BaseWrapper<V> {

    private final int number;

    public Wrapper(V value, int number) {
        super(value);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapper<?> wrapper = (Wrapper<?>) o;
        return number == wrapper.number && Objects.equals(value, wrapper.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, number);
    }
}
