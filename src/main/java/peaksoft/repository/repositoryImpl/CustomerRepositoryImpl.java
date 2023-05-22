package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("SELECT s from Customer s ", Customer.class).getResultList();
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Customer customer1 = entityManager.find(Customer.class, id);
        customer1.setName(customer.getName());
        customer1.setSurName(customer.getSurName());
        customer1.setEmail(customer.getEmail());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setGender(customer.getGender());
        customer1.setDateOfBirth(customer.getDateOfBirth());
    }

    @Override
    public void deleteCustomerById(Long id) {
        entityManager.remove(entityManager.find(Customer.class, id));
    }

    @Override
    public List<Agency> searchCustomer(String word) {
        return null;
    }
}
