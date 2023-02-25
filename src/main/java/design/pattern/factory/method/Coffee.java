package design.pattern.factory.method;

public class Coffee implements Beverage {

    @Override
    public void brew() {
        make();
        System.out.println("กาแฟได้แล้วครับ");
    }

    private void make() {
        String doSomeThing = "ฉีกซองเทใส่แก้วแล้วเติมน้ำร้อน";
    }
}
