package anna.demo.repo;

import anna.demo.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ContactRepoMap implements IContactRepo {

    HashMap<Integer, Contact> contactById = new HashMap<>();

    @Override
    public void save(Contact contact) {
        if (contact.getId()==0) {
            contact.setId(getMaxId() + 1);
            contactById.put(contact.getId(), contact);
        }
        else {
            contactById.put(contact.getId(), contact);
        }
    }

    private int getMaxId() {

        return contactById.keySet().stream().max(Integer::compare).orElse(0);
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
}
