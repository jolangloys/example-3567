package example;

import java.util.Objects;

public class BaseWrapper<V> {

    protected final V value;

    public BaseWrapper(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseWrapper<?> that = (BaseWrapper<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
