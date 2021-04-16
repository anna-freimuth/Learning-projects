package anna.contacts_db.repo;

import anna.contacts_db.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IContactRepo extends CrudRepository<Contact, Integer> {

    List<Contact> findByLastNameStartingWithAndNameStartingWith(String lastName, String name);
}

