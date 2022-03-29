package course2.homework3;

import static java.lang.String.format;

public class PhoneBookApp {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("910-123-23-45", "Иванов");
        phoneBook.addEntry("920-127-23-45", "Иванов");
        phoneBook.addEntry("900-125-23-47", "Иванов");
        phoneBook.addEntry("911-127-23-48", "Петров");
        phoneBook.addEntry("910-123-23-46", "Смирнов");

        System.out.printf("Тел: 910-123-23-46 - имя: %s%n",phoneBook.getByPhone("910-123-23-46"));
        System.out.printf("Имя: Иванов - тел: %s%n",phoneBook.getByName("Ивановa"));



    }

}
