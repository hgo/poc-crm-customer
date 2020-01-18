package tr.com.turkcell.crm.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String>
{
    Optional<Customer> findByTckn(String tckn);
}
