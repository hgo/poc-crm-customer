package tr.com.turkcell.crm.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tr.com.turkcell.crm.ws.customers.ListCustomersRequest;
import tr.com.turkcell.crm.ws.customers.ListCustomersResponse;

import java.util.List;


@Endpoint
public class CustomerEndpoint
{
    private static final String NAMESPACE_URI = "http://ws.crm.turkcell.com.tr/customers";

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerEndpoint(CustomerRepository countryRepository)
    {
        this.customerRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listCustomersRequest")
    @ResponsePayload
    public ListCustomersResponse listCustomers(@RequestPayload ListCustomersRequest request)
    {
        ListCustomersResponse response = new ListCustomersResponse();
        final List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers)
        {

            tr.com.turkcell.crm.ws.customers.Customer wsCustomer = new tr.com.turkcell.crm.ws.customers.Customer();
            wsCustomer.setId(customer.getId());
            wsCustomer.setName(customer.getName());
            wsCustomer.setTckn(customer.getTckn());
            response.getCustomers().add(wsCustomer);
        }
        return response;
    }
}