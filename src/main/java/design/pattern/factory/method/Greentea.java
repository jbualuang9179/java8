package design.pattern.factory.method;

public class Greentea implements Beverage {

    @Override
    public void brew() {
        collectingTeaLeaves();
        System.out.println("ชาเขียวได้แล้วครับ");
    }

    private void collectingTeaLeaves() {
        String doSomeThing = "เก็บยอดอ่อนใบชาจากความสูง 1200 เมตร เหนือน้ำทะเล";
    }
}
