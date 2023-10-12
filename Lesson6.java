import java.util.*;

public class Phonebook {
    private Map<String, Set<String>> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        contacts.computeIfAbsent(name, k -> new HashSet<>()).add(phone);
    }

    public void printContacts(boolean sort) {
        List<String> sortedNames = new ArrayList<>(contacts.keySet());
        if (sort) {
            Collections.sort(sortedNames);
        }

        System.out.println("Contacts:");
        for (String name : sortedNames) {
            Set<String> phones = contacts.get(name);
            System.out.println(name + " - " + phones.size() + " phones:");
            for (String phone : phones) {
                System.out.println("\t" + phone);
            }
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addContact("Vlad", "+71234567890");
        phonebook.addContact("Nastya", "+70987654321");
        phonebook.addContact("Sanya", "+75557778899");
        phonebook.addContact("Sanya", "+71112223344");
        phonebook.addContact("Nastya", "+78005553535");
        phonebook.addContact("Vlad", "+79991116688");

        phonebook.printContacts(false);
        System.out.println();

        phonebook.printContacts(true);
    }
}