package course1.lesson2;

public class MethodApp {

    public static final String TEMPLATE = "int = %d string = %s";
    public static void main(String[] args) {
        int var1 = multiplication(4,10);
        int var2 = multiplication(5,6.0);

        PrintUtil.printFormatted("var 1 =" + var1 + ", var 2 =" + var2 + ", var 3 =" + multiplication(var1,var2));
        PrintUtil.printFormatted("var2");
        System.out.printf(TEMPLATE, 10, "str");
        System.out.println();
        System.out.printf(TEMPLATE, 1130, "srtyljkh");

        //TEMPLATE = "template"; -- так нельзя (final после создания переопределить нельзя)
    }

    public static int multiplication(int n1, int n2) {
        int result = n1 * n2;
        return result;
    }

    public static int multiplication(int n1, double n2) {
        int result =(int)(n1 * n2);
        return result;
    }
    //Метод = модификатор доступа (public, private, default, protected) + тип значения + набор параметров
}
