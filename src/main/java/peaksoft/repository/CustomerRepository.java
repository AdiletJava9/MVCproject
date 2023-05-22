package peaksoft.repository;

import peaksoft.entity.Agency;
import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    void saveCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    void updateCustomer(Long id, Customer customer);

    void deleteCustomerById(Long id);

    List<Agency> searchCustomer(String word);
}
