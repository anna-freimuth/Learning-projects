package anna.demo.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class ContactList {
    List<Contact> contacts = new ArrayList<>();


    public List<Contact> getContacts() {
        return contacts;
    }

    private int getLastId(){
       return contacts.stream()
               .map(Contact::getId)
               .max(Integer::compare)
               .orElse(0);
    }
    public void addContact(Contact contact){
        contact.setId(getLastId() + 1);
        contacts.add(contact);
    }

    public void editContact(Contact contact){
      int contactIndex = contacts.indexOf(contact);
        contacts.set(contactIndex,contact);
    }

    public void deleteContact(Contact contact){
        contacts.remove(contact);
    }

    public Contact getContactById(int id){
        for (Contact contact:contacts) {
            if(contact.getId()==id){
                return  contact;
            }
        }
        return  null;
    }
}
