package course1.lesson2;

public class PrintUtil {

    /**
     *
     * @param str
     */
    public static void printFormatted(String str) {
        System.out.println("***" + str + "***");
        System.out.printf("***%s***", str);
        System.out.println();
    }

    /**
     *
     * @param str
     * @return
     */
    public static String getFormatted(String str) {
        return "***" + str + "***";
    }
}
