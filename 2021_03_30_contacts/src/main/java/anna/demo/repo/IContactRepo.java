package anna.demo.repo;

import anna.demo.entity.Contact;

import java.util.List;

//TODO: implement this via List and via HashMap
public interface IContactRepo {
    void save(Contact contact);

    Contact find(int id);

    Contact remove(int id);

    List<Contact> findAll();

}
