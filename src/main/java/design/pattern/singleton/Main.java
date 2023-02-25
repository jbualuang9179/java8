package design.pattern.singleton;

public class Main {

    public static void main(String[] args) {

        ToiletDoor toiletDoor = ToiletDoor.getInstance();

        // Try The door is work
        toiletDoor.openTheDoor();
        toiletDoor.closeTheDoor();

        // can not create new Object because constructor is private
    }
}
