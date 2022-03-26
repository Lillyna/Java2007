package course2.lesson2_22_03;

public class App {
    public static void main(String[] args) {
        final Gender female = Gender.FEMALE;
        final Gender male = Gender.MALE;
        System.out.println("male = " + male.ordinal()); //порядковый номер в enum
        System.out.println("male.name = " + male.name());
        final Gender[] values = Gender.values();
        for(Gender value: values){
            System.out.println(value  + " " + value.getShortName());
        }
        Gender s = male.byShortName("Ж");
        System.out.println(s);

    }
    public static void m(){
        int a = 10/0;
    }
}
