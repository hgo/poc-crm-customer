package tr.com.turkcell.crm.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String>
{
    Customer findByTckn(String tckn);
}
