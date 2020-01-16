package tr.com.turkcell.crm.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class DataSupplier
{

    private final CustomerRepository repo;

    @Autowired
    public DataSupplier(CustomerRepository repo)
    {
        this.repo = repo;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event)
    {

        if (repo.count() == 0)
        {
            Customer c = new Customer();
            c.setName("G OX");
            c.setTckn("12332112345");
            repo.save(c);
        }

    }
}
