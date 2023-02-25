package design.pattern.singleton;

public class ClassSingleton {

    private static ClassSingleton INSTANCE;
    private String info = "Initial info class";

    public ClassSingleton() {
    }

    public static ClassSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ClassSingleton();
        }
        return INSTANCE;
    }

    // getters and setters
}
