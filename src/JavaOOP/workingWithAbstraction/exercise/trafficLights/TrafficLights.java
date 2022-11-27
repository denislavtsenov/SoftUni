package JavaOOP.workingWithAbstraction.exercise.trafficLights;

import static JavaOOP.workingWithAbstraction.exercise.trafficLights.Color.*;

public class TrafficLights {
    Color color;

    public TrafficLights(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void changeColor() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }
}
