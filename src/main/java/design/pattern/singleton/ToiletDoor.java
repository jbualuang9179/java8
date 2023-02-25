package design.pattern.singleton;

public class ToiletDoor {

    // Create 1 Door
    private static ToiletDoor instance = new ToiletDoor();

    // define constructor is private for can not create the door anymore;
    private ToiletDoor(){}

    // provide for use the door via getInstance() then send the door to use
    public static ToiletDoor getInstance() {
        return instance;
    }

    public void openTheDoor() {
        System.out.println("Door is opened.");
    }

    public void closeTheDoor() {
        System.out.println("Door is closed");
    }
}
