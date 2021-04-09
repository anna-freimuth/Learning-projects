package anna.demo.service;

import anna.demo.entity.Contact;
import anna.demo.repo.IContactRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//The domain logic lies here (business logic)
@Service
public class ContactService {
    IContactRepo contactRepo;

    public ContactService(@Qualifier("contactRepoMap") IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    public Contact get(int id) {
        return contactRepo.find(id);
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact remove(int id) {
        return contactRepo.remove(id);
    }
}
