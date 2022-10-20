package JavaAdvanced.src.generics.genericBoxofInteger;

public class Box<T> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }
}

