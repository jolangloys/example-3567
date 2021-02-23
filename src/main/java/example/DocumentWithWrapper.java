package example;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class DocumentWithWrapper {

    public enum MyEnum {
        ONE, NOT_ONE
    }

    private final Wrapper<MyEnum> myWrappedEnum;

    public DocumentWithWrapper(Wrapper<MyEnum> myWrappedEnum) {
        this.myWrappedEnum = myWrappedEnum;
    }

    public Wrapper<MyEnum> getMyWrappedEnum() {
        return myWrappedEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentWithWrapper that = (DocumentWithWrapper) o;
        return Objects.equals(myWrappedEnum, that.myWrappedEnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myWrappedEnum);
    }
}
