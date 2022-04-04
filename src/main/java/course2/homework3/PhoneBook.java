package course2.homework3;

import java.util.*;

public class PhoneBook {
    final private HashMap<String, String> map = new HashMap<>();

    public PhoneBook() {

    }

    public void addEntry(String phoneNumber, String surname) {
        map.put(phoneNumber, surname);
    }

    public String getByPhone(String phoneNumber) {
        String name = map.get(phoneNumber);
        return name.isEmpty() ? "Ничего не найдено" : name;
    }

    public ArrayList<String> getByName(String surname) {

        ArrayList<String> phones = new ArrayList<>();

        for (Map.Entry<String, String> i : map.entrySet()) {
            if (i.getValue().equals(surname)) {
                phones.add(i.getKey());
            }
        }
        if (phones.size() == 0) {
            phones.add("Ничего не найдено");
        }
        return phones;
    }
}
