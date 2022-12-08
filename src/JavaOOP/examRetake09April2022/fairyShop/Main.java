package JavaOOP.examRetake09April2022.fairyShop;

import JavaOOP.examRetake09April2022.fairyShop.core.Engine;
import JavaOOP.examRetake09April2022.fairyShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
