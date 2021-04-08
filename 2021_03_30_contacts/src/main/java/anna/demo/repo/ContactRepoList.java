package anna.demo.repo;

import anna.demo.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ContactRepoList implements IContactRepo{

    ArrayList<Contact> contacts = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);


    @Override
    public void save(Contact contact) {
        if (contact.getId() == 0){
            contact.setId(createId());
            contacts.add(contact);
        } else {
            int contactIndex = contacts.indexOf(contact);
            contacts.set(contactIndex, contact);
        }
    }

    @Override
    public Contact find(int id) {
        for (Contact contact:contacts) {
            if(contact.getId()==id){
                return  contact;
            }
        }
        return  null;
    }

    @Override
    public Contact remove(int id) {
        for (Contact contact: contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    private int getLastId(){
        return contacts.stream()
                .map(Contact::getId)
                .max(Integer::compare)
                .orElse(0);
    }

    public int createId(){
        return (int) idCounter.getAndIncrement();
    }
}
