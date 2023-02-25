package design.pattern.factory.method;

// --- Design Patterns
// 1. Creational patterns – เป็นกลุ่มที่ไว้ใช้สร้าง object ในรูปแบบต่างๆ ให้มีความยืดหยุ่น(flexible) และนำโค้ดมาใช้ซ้ำ(reuse)ได้
// 2. Structural patterns – กลุ่มนี้จะเป็นวิธีการนำ object และ class มาใช้งานร่วมกัน สร้างเป็นโครงสร้างที่มีความซับซ้อนยิ่งขึ้น โดยที่ยังมีความยืดหยุ่นและทำงานได้อย่างมีประสิทธิภาพ
// 3. Behavioral patterns – กลุ่มสุดท้ายนี้เป็นวิธีการออกแบบการติดต่อกันระกว่าง object ให้มีความยืดหยุ่นและสามารถติดต่อกันกันได้อย่างไม่มีปัญหา

// 1. Factory method -> Creational patterns
// 2. Builder -> Creational patterns
// 3. Singleton -> Creational patterns
// 4. Adapter -> Structural patterns
// 5. Facade -> Structural patterns
// 6. Observer -> Behavioral patterns
// 7. Template Method -> Behavioral patterns

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();

        // สั่งกาแฟกับบารริสต้า
        Beverage order1 = barista.order("coffee");

        // สั่งให้ทำมาให้ก็จะได้กาแฟออกมา
        order1.brew();

        // สั่งชาเขียวกับบาริสต้า
        Beverage order2 = barista.order("greentea");

        // สั่งเหมือนกับเครื่องดื่มอื่นๆ
        order2.brew();

        // สั่งโคล่ากับบาริสต้า
        Beverage order3 = barista.order("cola");

        // สั่งเหมือนๆกันกับเครื่องดื่มอื่น
        order3.brew();

    }
}
