package java8.qa;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Flow;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Test {

    class PrintUnils {
        static void print(String it) {
            System.out.println(it);
        }
    }

    class Character {

        public Character(String name) {
            this.name = name;
        }
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        // 1) Lambda express
        // Example Thread class have constructor input Runnable is Argument
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable");
            }
        }).start();
        // use Lambda expression on Thread constructor
        new Thread(() -> System.out.println("inside runnable use lambda")).start();
        // Lambda expression can Assign value to Reference
        Runnable runnable = () -> System.out.println("Run method");
        new Thread(runnable).start();

        // 2) Method Reference use Double-colon (::)
        List<String> list = Arrays.asList("jirapong", "Luke", "Darth Vader", "Han Solo", "Stormtrooper", "Nitcha");
        // lambda expression
        list.forEach(it -> System.out.println(it));
        // method reference
        list.forEach(System.out::println);
        // Class::instanceMethod call Instance method + example
        list.forEach(PrintUnils::print);

        // 3) Constructor References
        // Call Class Character{}
        // Using a Constructor References to create Character
//        List<Character> characters = stringList.stream().map(Character::new)
//                .collect(Collectors.toList());
//
//        List<String> names = characters.stream().map(Character::getName)
//                .collect(Collectors.toList());

        // 4) Streams
        // Create Stream use Stream interface via Stream.of
        String names = Stream.of("jirapong", "Luke", "Darth Vader", "Han Solo", "Stormtrooper","Nitcha").collect(Collectors.joining(","));
        System.out.println(names);
        // --- Result = Anakin,Luke,Darth Vader,Han Solo,Stormtrooper,Cherprang

        // Stream.iterate
        List<Integer> nums = Stream.iterate(1, n -> n + 1).limit(10)
                .collect(Collectors.toList());
        System.out.println(nums);
        // --- Result = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // Arrays.stream
        String[] listString = {"jirapong", "Luke", "Darth Vader", "Han Solo", "Stormtrooper", "Nitcha"};
        String names2 = Arrays.stream(listString).collect(Collectors.joining(","));
        //Anakin,Luke,Darth Vader,Han Solo,Stormtrooper,Cherprang

        // Create Stream from Collection
        String names3 = list.stream().collect(Collectors.joining(","));
        System.out.println(names);
        //Anakin,Luke,Darth Vader,Han Solo,Stormtrooper,Cherprang

        // Create Stream of IntStream.range
        List<Integer> ints = IntStream.range(10, 15).boxed()
                .collect(Collectors.toList());
        System.out.println(ints);
        // Result = [10, 11, 12, 13, 14]

        // --- 5) Boxed Streams
        // Normal Stream
        List<String> namesNormal = Stream.of("Jirapong", "Bualuang").collect(Collectors.toList());
        // Primitive stream can not use this
        // List<Integer> numsB = IntStream.of(1,2,3,4,5).collect(Collectors.toList()); // this is can't compile should use boxed() method
        List<Integer> numsBoxedStreams = IntStream.of(1,2,3,4,5).boxed().collect(Collectors.toList());
        // Or mapToObj method convert int to Integer
        List<Integer> intToInteger = IntStream.of(1,2,3,4,5).mapToObj(Integer::valueOf).collect(Collectors.toList());


        // --- 6) Map is method on Stream Transforms data + Map method input function is argument
        Function<String, Integer> getLength = it -> it.length();

        List<Integer> sizes = Stream.of("jirapong", "Luke", "Darth Vader", "Han Solo", "Stormtrooper", "Nitcha")
                .map(getLength).collect(toList());
        System.out.println("Map call function : " + sizes);

        // use lambda expression
        List<Integer> sizesLambda = Stream.of("jirapong", "Luke", "Darth Vader", "Han Solo", "Stormtrooper", "Nitcha")
                .map(it -> it.length()).collect(Collectors.toList());
        System.out.println(sizesLambda);

        // --- 7) FlatMap
        // ex. transform array 2 dimension to array 1 dimension
        String [][] data = new String[][]{{"Jirapong", "Bualuang"}, {"Nitcha", "Bualuang"}};

        List<String> datas = Arrays.stream(data)
                .flatMap(it -> Arrays.stream(it)).collect(Collectors.toList());
        // Or
        List<String> dataRefMethod = Arrays.stream(data)
                .flatMap(Arrays::stream).collect(Collectors.toList());

        // --- 8) Filter
        // Same Code For loop and use if for check condition that
        // input value to element that match condition to List *** Filter pattern
        List<String> listForLoop = Arrays.asList("jirapong", "Luke", "Darth Vader", "Han Solo", "Stormtrooper", "Nitcha");
        List<String> lengthGreaterThan8 = new ArrayList<>();
        for (String it : list) {
            if (it.length() > 8) {
                lengthGreaterThan8.add(it);
            }
        }
        System.out.println("ForLoop : " + lengthGreaterThan8);

        // process then return value is TRUE or FALSE
        Predicate<String> isLengthGreaterThan8 = it -> it.length() > 8;
        List<String> lengthGreaterThan8Pre = listForLoop.stream()
                .filter(isLengthGreaterThan8).collect(Collectors.toList());
        System.out.println("Predicate " + lengthGreaterThan8Pre);

        // Or use Lambda expression like this
        List<String> lengthGreaterThan8Lambda = listForLoop.stream()
                .filter(it -> it.length() > 8).collect(toList());
        System.out.println("lambda : " + lengthGreaterThan8Lambda);

        // --- 9) Reduce
        // สำหรับ Reduce จะใช้เมื่อเราได้ Collection ของค่าที่เราต้องการแล้ว แต่เราต้องการสร้าง
        // Result ตัวเดียว เช่น ใช้ Reduce ในการหาค่า sum ใช้ Reduce ในการหาค่า Min หรือค่า Max หรือใช้ในการ Join String เป็นต้น

        String nameRe = list.stream().filter(it -> it.length() > 8)
                .reduce((acc, name) -> acc+ ", " + name).get();
        System.out.println(nameRe);


//        --- 10) Built-in Operations
//        สำหรับ Primitive streams เช่น IntStream, LongStream, และ DoubleStream
//        จะมี Built-in Operations ให้เรียกใช้งานอย่างหลากหลาย เช่น average, count, max, min, และ sum เป็นต้น
        Double average = IntStream.of(1, 2, 3, 4, 5).average().getAsDouble();
        System.out.println(average); //3.0;

        Long count = IntStream.of(1, 2, 3, 4, 5).count();
        System.out.println(count);  //5

        Integer min = IntStream.of(1, 2, 3, 4, 5).min().getAsInt();
        System.out.println(min);  //1

        Integer max = IntStream.of(1, 2, 3, 4, 5).max().getAsInt();
        System.out.println(max);   //5

        Integer sum = IntStream.of(1, 2, 3, 4, 5).sum();
        System.out.println(sum);   //15

        // --- 11) Optional
//        เอาหละครับ มาถึงเจ้า Optional ซึ่งจะเป็น Feature สุดท้ายในบทความนี้แล้ว Optional ก็คือ Class ใหม่ที่ถูกเพิ่มเข้ามาใน
//        Java 8 คือ java.util.Optional<T> โดยจุดประสงค์ของมัน คือเอามาใช้ในการจัดการกับ NullPointerExceptions
//        อย่างเหมาะสม และใน Stream API บาง Method จะ Return ค่าเป็น Optional เช่น reduce, min, max, findFirst
//        และ findAny สำหรับการสร้าง Optional จะใช้ Optional.of, Optional.ofNullable, หรือ Optional.empty
//        สร้าง Optional ด้วย Optional.of ตัว Optional.of ใช้ในการหุ้ม Value ถ้า Value เป็น null ก็จะทำการ throws exception

        Optional<List<String>> listOptional = createOptional(list);
        System.out.println(listOptional);

        // สร้าง Optional ด้วย Optional.ofNullable ไม่เหมือนกับ Optional.of
        // เจ้า Optional.ofNullable เปิดให้สามารถหุ้มvalue ที่เป็น null ได้

        Optional<List<String>> listOptional1 = createOptional(list);
        System.out.println(listOptional1);

//        นอกจาก Optional ยังมี Class OptionalInt, OptionalLong, และ OptionalDouble
//        ที่ใช้ในการหุ้มค่า primitives ที่ไม่สามารถเป็น Null ได้

//        สำหรับการเอา Value ที่เราใช้ Optional หุ้มกลับคืนมา เราสามารถใช้ get method ในการเอาค่าที่อยู่ใน
//        Optional กลับมาได้ สำหรับการใช้ get method เราต้องแน่ใจด้วยนะครับ ว่ามี value อยู่ใน Optional จริงๆ
//        และถ้าเป็นไปได้แนะนำให้หลีกเลี่ยงการใช้ get method แต่ให้ใช้ทางเลือกอื่น เช่น orElse method หรือ ifPresent

        Optional<String> firstLength2 = Stream.of("Nitcha", "Luke", "Darth Vader", "Han Solo", "Stormtrooper", "Nathamon")
                .filter(s -> s.length() == 0).findFirst();
//        System.out.println(firstLength2.get()); //อย่าใช้ Get แบบนี้โดยเด็ดขาด
        // throw NoSuchElementException
        // use orElse method
        System.out.println(firstLength2.orElse("No 2 length string"));
        // use isPresent
        System.out.println(firstLength2.isPresent() ? firstLength2.get() : ("No 2 length string"));

        // ใช้งาน orElseThrow method เจ้า orElseThrow method รับ Supplier เป็น argument
        Optional<String> firstLength3 = Stream.of("Nitcha", "Luke", "Darth Vader", "Han Solo", "Stormtrooper", "Nathamon")
                .filter(s -> s.length() == 0).findFirst();

        Supplier<NoSuchElementException> throwNoSuchElementException =
                NoSuchElementException::new;
        System.out.println(firstLength3.orElseThrow(throwNoSuchElementException));
        // throw NoSuchElementException





        // --- Interview Java 8 feature ---- //

        // 1) --- What are all features of java 8 did you used?
//                1. Functional Interface(include default & static method)
//                2. Lamda Expression
//                3. Stream API
//                4. CompletableFuture -> Asynchronous
//                5. Java DateTime API

//        2) ---- What is functional interface?
//        An Interface that contains only one abstract method is known as functional interface.
//        It can have any number of default and static methods

        // 3) --- interface which is already there before java8 ?
        // Runnable
        // Callable
        // Comparator


        // 6) --- what are all functional interface introduced in java 8 ?
        // Function
        // Consumer
        // Supplier
        // Predicate


        // 7) What is lambda expression ?   ->
        // --- Normal
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//
//        Runnable th = () -> System.out.println("run method");
//        new Thread(th).start();
//
//        Runnable run = () -> {
//
//        };

//        MyFunction test = (i) -> System.out.println("test method executed ...");
//        test.test(15);

//        MyFunction function = (i) -> i *10;
//        System.out.println(function.test(15));

//        MyFunction function = (s1, s2) -> s1 +":" +s2;
//        System.out.println(function.test("abc", "def"));

        // --- Type Generic
//        Function<Integer, String> function1 = (t) -> "output : " + t;
//        System.out.println(function1.apply(88));


//        // -- Stream API
//        List<Integer> list = Arrays.asList(23,4,6,8,9,1,2,10);
//        //>4 23,6,8,9,10
//        //6,8,9,10,23
//
////        Predicate<Integer> predicate = (t) -> t > 4;
//
////        list.stream().filter(n -> n > 4).sorted().forEach(System.out::println);
//
//        List<User> users = Stream.of(
//                new User("user1", "1234567890", Arrays.asList("abc@gmail.com", "def@gmail.com")),
//                new User("user2", "0656159450", Arrays.asList("test@gmail.com", "devops@gmail.com")))
//                .collect(Collectors.toList());
//
//        // 13. When to use map & flatMap
////        List<String> phoneNumbers = users.stream().map(User::getPhone).collect(Collectors.toList());
////        System.out.println(phoneNumbers);
////
////        List<List<String>> email = users.stream().map(User::getEmail).collect(Collectors.toList());
////        System.out.println(email);
//
////        List<String> emailFlatMap = users.stream().flatMap(u -> u.getEmail().stream()).collect(Collectors.toList());
////        System.out.println(emailFlatMap);
//
//        //--- 14. WAP using stream to Find frequency of each character in a given String?
////        String input = "Jirapong Bualuang";
////
////        Map<String, Long> countMap = Arrays.stream(input.split(""))
////                .collect(
////                        groupingBy(
////                                Function.identity(),counting()
////                        )
////                );
////        System.out.println(countMap);
//
//
//        // 15. Assume you have list of employee in various dept, WAP to find highest paid employee from each dept?
//        List<Employee> employees = Stream.of(
//                        new Employee(1, "Basant", "DEV", 50000),
//                        new Employee(8, "Santosh", "DEV", 80000),
//                        new Employee(3, "Pratik", "QA", 60000),
//                        new Employee(9, "Dipak", "QA", 90000),
//                        new Employee(4, "Bikash", "DEVOPS", 40000))
//                .collect(Collectors.toList());
//
//        Map<String, List<Employee>> employeeMap = employees.stream().collect(groupingBy(Employee::getDept));
//        System.out.println(employeeMap);
//
//        // --- compare by salary use groupingBy and reducing + binaryOperator.maxBy
//        // approach 1
//        Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
//        Map<String, Optional<Employee>> employeeMapCompareBySalary = employees.stream().
//                collect(
//                        groupingBy(Employee::getDept,
//                                Collectors.reducing(BinaryOperator.maxBy(compareBySalary)))
//                );
////        System.out.println(employeeMapCompareBySalary);
//
//        // approach 2
//        Map<String, Employee> employeeMapCompareBySalary2  = employees.stream()
//                .collect(groupingBy(
//                        Employee::getDept,
//                        collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)
//                ));
////        System.out.println(employeeMapCompareBySalary2);
//
//
//        // --- 16. Stream VS parallel stream ?
//        // Sequential Stream OR Parallel Stream
//        IntStream.rangeClosed(1,10).forEach(t -> System.out.println(Thread.currentThread().getName()+t));
//        System.out.println("==============================");
//        IntStream.rangeClosed(1,10).parallel().forEach(t -> System.out.println(Thread.currentThread().getName()+" : "+t));
//
//        // --- 17. What is CompletableFuture ?
////        CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a
////        means of writing non-blocking code by running a task on a separate thread than the main
////        application thread and notifying the main thread about its progress, completion or failure.
//
//
//        // --- 18. Why CompletableFuture why not Future ?
//        // 1. It cannot be manualy completed
//        // 2. Multiple Futures cannot be chained together
//        // 3. You can not combine multiple Futures together
//        // No Exception Handling
//
//        // --- 19. How to decide Thread Pool Size ?
//        // 1. CPU Intensive Tasks
//        // 2. IO Intensive Tasks
//
//        // --- 20. WAP to print even and odd using 2 threads.

    }

    private static <T> Optional<T> createOptional(T value) {
//        return value == null ? Optional.empty() : Optional.of(value);
        return Optional.ofNullable(value);
    }

    public static void printElement(int i) {
        System.out.println(i);
    }
}
