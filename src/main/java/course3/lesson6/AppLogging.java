package course3.lesson6;

import java.util.Arrays;

public class AppLogging {
    // Возможность выбора, куда логировать - консоль, файл, бд, отправлять по сети
    // Возможность управлять уровнем логирования
    // Информация о имени класса, номере строки, имени потока и тд
    // Возможность ротирования при достижении к-л размера файла
    // Системы хранения логов и поиска по ним (Sentry, Kibana)

    public static void main(String[] args) {
        System.out.println("Program started " + Arrays.toString(args));
        final AppLogging app = new AppLogging();
        app.m("abc", 3);
        System.out.println("Program ended");
    }

    private void m(String abc, int i) {
        System.out.println(new Exception().getStackTrace()[0].getLineNumber() + " Method m() start a = " + abc + ", i = " + i);
        try {
            i /= 0;
        } catch (Exception e) {
            System.err.println(new Exception().getStackTrace()[0].getLineNumber() + " Error " + e.getMessage());
            e.printStackTrace();
        }
    }

}
