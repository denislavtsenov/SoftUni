package JavaOOP.interfacesAndAbstraction.lab.ferrari;

public class Ferrari implements Car{
    private String driverName;
    private static  final String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;

    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return MODEL + "/" + brakes() + "/" + gas() + "/" + driverName;
    }
}
