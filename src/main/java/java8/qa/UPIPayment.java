package java8.qa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// --- 4) Can you write one functional interface ?
@FunctionalInterface
public interface UPIPayment {

    String doPayment(String source, String dest);

    default double getScratchCard() {
        return new Random().nextDouble();
    }

    static String datePatterns(String patterns) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patterns);
        return dateFormat.format(new Date());
    }

}
