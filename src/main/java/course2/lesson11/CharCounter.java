package course2.lesson11;

public class CharCounter {

    public static void main(String[] args) {

        final CharCounter counter = new CharCounter();
        counter.count("aaabbbSSSS");
        // анонимный класс
        // лямбда-выражение - это "синтаксический сахар" - синтаксическая обертка для записи анонимных классов
        final Reader reader = (a, b) -> a.repeat(b);


    }
    public void count(String text){
        int [] c = new int[127];
        final char[] chars = text.toCharArray();
        for (char ch : chars){
            c[ch]++;
        }
        for (int i = 0; i < c.length; i++) {
            if(c[i] !=0){
                System.out.println(((char)i) + " " + c[i]);
            }
        }
    }
}
