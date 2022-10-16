package JavaAdvanced.src.generics;

public class Box<T> {
    private T value;


    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }
}
