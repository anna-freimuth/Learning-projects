package anna.contacts_db.repo;

import anna.contacts_db.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IContactRepo extends CrudRepository<Contact, Integer> {

    List<Contact> findByLastNameStartingWithAndNameStartingWith(String lastName, String name);

//    Collection<Contact> findAllByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String partialName, String partialLastName);
//
//    @Query("select c from Contact c where UPPER(c.name) like concat('%',UPPER(:pattern),'%') or UPPER(c.lastName) like concat('%',UPPER(:pattern),'%')")
//    Collection<Contact> findAllContainingPattern(@Param("pattern") String pattern);
}

