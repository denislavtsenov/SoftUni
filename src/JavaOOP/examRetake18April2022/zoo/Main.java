package JavaOOP.examRetake18April2022.zoo;

import JavaOOP.examRetake18April2022.zoo.core.Engine;
import JavaOOP.examRetake18April2022.zoo.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
