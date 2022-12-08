package JavaOOP.examRetake10April2021.aquarium;

import JavaOOP.examRetake10April2021.aquarium.core.Engine;
import JavaOOP.examRetake10April2021.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
