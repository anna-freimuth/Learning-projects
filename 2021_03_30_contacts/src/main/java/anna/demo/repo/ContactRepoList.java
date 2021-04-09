package anna.demo.repo;

import anna.demo.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContactRepoList implements IContactRepo {

    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);


    @Override
    public void save(Contact contact) {
        if (contact.getId() == 0) {
            contact.setId(createId());
            contacts.add(contact);
        } else {
            int contactIndex = contacts.indexOf(contact);
            contacts.set(contactIndex, contact);
        }
    }

    @Override
    public Contact find(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact remove(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return Collections.unmodifiableList(contacts);
    }


    public int createId() {
        return idCounter.getAndIncrement();
    }
}
