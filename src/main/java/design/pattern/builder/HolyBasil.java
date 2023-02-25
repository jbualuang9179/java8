//package design.pattern.builder;
//
//public class HolyBasil
//{
//    private final String meat; // จำเป็นต้องใส่
//    private final String fishSauce; // ไม่จำเป็น
//    private final String garlic; // ไม่จำเป็น
//    private final String chili; // ไม่จำเป็น
//    private HolyBasil(HolyBasilBuilder builder) {
//        this.meat = builder.meat;
//        this.fishSauce = builder.fishSauce;
//        this.garlic = builder.garlic;
//        this.chili = builder.chili;
//    }
//    //ต้องมี getter แต่ไม่ต้องมี setter
//    public String getMeat() {
//        return meat;
//    }
//    public String getfishSauce() {
//        return fishSauce;
//    }
//    public String getgarlic() {
//        return garlic;
//    }
//    public String getchili() {
//        return chili;
//    }
//    @Override
//    public String toString() {
//        String order = "HolyBasil "+this.meat + ", fishSauce:"+this.fishSauce+", garlic:"+this.garlic+", chili:"+this.chili;
//        return order;
//    }
//
//}
