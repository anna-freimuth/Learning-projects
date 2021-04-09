package anna.demo.repo;

import anna.demo.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContactRepoMap implements IContactRepo {

    private final HashMap<Integer, Contact> contactById = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public void save(Contact contact) {
        if (contact.getId() == 0) {
            contact.setId(createId());
            contactById.put(contact.getId(), contact);
        } else {
            contactById.put(contact.getId(), contact);
        }
    }

    @Override
    public Contact find(int id) {
        return contactById.getOrDefault(id, null);
    }

    @Override
    public Contact remove(int id) {
        return contactById.remove(id);
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contactById.values());
    }

    public int createId() {
        return idCounter.getAndIncrement();
    }
}
