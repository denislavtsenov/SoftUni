package JavaAdvanced.src.definingClasses.Google;

public class Children {
    private final String name;
    private final String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public String format(){
        return String.format("%s %s",name,birthday);
    }
}
