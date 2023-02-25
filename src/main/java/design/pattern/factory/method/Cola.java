package design.pattern.factory.method;

public class Cola implements Beverage {

    @Override
    public void brew() {
        openBottle();
        String doSomeThing = "โคล่าได้แล้วครับ";
    }

    private void openBottle() {
        System.out.println("เปิดขวดแล้วเทใส่แก้ว");
    }
}
