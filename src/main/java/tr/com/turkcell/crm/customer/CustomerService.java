package tr.com.turkcell.crm.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService
{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    public Optional<Customer> findByTckn(String tckn)
    {
        if (tckn == null || tckn.length() != 11)
        {
            throw new IllegalArgumentException("findCustomer.tckn.invalid");
        }
        return customerRepository.findByTckn(tckn);
    }
}
