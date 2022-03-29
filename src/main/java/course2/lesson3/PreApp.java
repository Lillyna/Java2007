package course2.lesson3;

public class PreApp {
    public static void main(String[] args) {
        byte b; //1 байт (8 бит) -127...128
        short s; //2 байта
        char c;
        int i = 200;
        long l;
        float f;
        double d;
        boolean bln;

        Byte b1; // класс-обертка, хранится в heap, дают доп. возможности.
        // Медленнее,
        // занимают места больше,
        // нельзя сравнивать ==
        //Ссылочные типы сравнивают через equals
        Integer i1 = 400;
        Integer i2 = 400;
        System.out.println(i1.equals(i2));
        Integer.parseInt("123");

        //Автобоксинг: можно сложить int и Integer
        System.out.println(i1+i);
        int i3 = i1 + i;

        //Такие строки будут хранится в пуле строк в heap
        String a = "abc";
        String bb = "abc";
        //В этом случае такое сравнение даст true
        boolean ss = (a==bb);

        //Сложение строк
        StringBuilder sb = new StringBuilder(a);
        for (int j = 0; j < 100; j++) {
            sb.append("ab");
        }
        System.out.println(sb);
    }
}
