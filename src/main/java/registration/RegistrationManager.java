package registration;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistrationManager {
    private ArrayList<Registration> registrations = new ArrayList<>();
    private int nextId = 1; // Автоинкремент ID, который никогда не сбрасывается и не переиспользуется

    public void addRegistration(String fullName, String email, String studentGroup, int eventChoice) {
        String eventTitle = Registration.getEventTitleByChoice(eventChoice);
        Registration reg = new Registration(nextId++, fullName, email, studentGroup, eventTitle);
        registrations.add(reg);
        System.out.println("Registration created. ID: " + reg.getId());
    }

    public void displayAll() {
        if (registrations.isEmpty()) {
            System.out.println("No registrations found.");
            return;
        }
        for (Registration reg : registrations) {
            System.out.println(reg);
        }
    }

    public void findById(int id) {
        for (Registration reg : registrations) {
            if (reg.getId() == id) {
                System.out.println(reg);
                return;
            }
        }
        System.out.println("Registration not found.");
    }

    public void deleteById(int id) {
        Iterator<Registration> iterator = registrations.iterator();
        while (iterator.hasNext()) {
            Registration reg = iterator.next();
            if (reg.getId() == id) {
                iterator.remove();
                System.out.println("Registration with ID " + id + " has been deleted.");
                return;
            }
        }
        System.out.println("Registration not found. Deletion failed.");
    }

    public void displayByEvent(int eventChoice) {
        String targetEvent = Registration.getEventTitleByChoice(eventChoice);
        boolean found = false;
        for (Registration reg : registrations) {
            if (reg.getEventTitle().equals(targetEvent)) {
                System.out.println(reg);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No registrations found for this event.");
        }
    }
}
