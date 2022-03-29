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
        Optional<String> name = map.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(phoneNumber))
                .map(Map.Entry::getValue)
                .findFirst();
        return name.isEmpty() ? "Ничего не найдено" : name.get();
    }

    public ArrayList<String> getByName(String surname) {

        ArrayList<String> phones = new ArrayList<>();

        for (String i : map.keySet()) {
            if (map.get(i).equals(surname)) {
                phones.add(i);
            }
        }
        if (phones.size() == 0) {
            phones.add("Ничего не найдено");
        }
        return phones;
    }
}
