//package design.pattern.builder;
//
//public class HolyBasilBuilder
//{
//    private final String meat;
//    private String fishSauce;
//    private String garlic;
//    private String chili;
//    public HolyBasilBuilder(String meat) {
//        this.meat = meat;
//    }
//    public HolyBasilBuilder fishSauce(String fishSauce) {
//        this.fishSauce = fishSauce;
//        return this;
//    }
//    public HolyBasilBuilder garlic(String garlic) {
//        this.garlic = garlic;
//        return this;
//    }
//    public HolyBasilBuilder chili(String chili) {
//        this.chili = chili;
//        return this;
//    }
//
//    //object สุดท้ายที่จะส่งออกไป
//    public HolyBasil build() {
//        HolyBasil holyBasil =  new HolyBasil(this);
//        return holyBasil;
//    }
//}
//}
