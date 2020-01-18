package tr.com.turkcell.crm.customer;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tr.com.turkcell.crm.ws.customer.FindCustomerRequest;
import tr.com.turkcell.crm.ws.customer.FindCustomerResponse;
import tr.com.turkcell.crm.ws.customer.ListCustomersRequest;
import tr.com.turkcell.crm.ws.customer.ListCustomersResponse;

import java.util.List;
import java.util.Optional;


@Endpoint
public class CustomerEndpoint
{
    private static final String NAMESPACE_URI = "http://ws.crm.turkcell.com.tr/customer";

    private final CustomerService customerService;

    public CustomerEndpoint(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listCustomersRequest")
    @ResponsePayload
    public ListCustomersResponse listCustomers(@RequestPayload ListCustomersRequest request)
    {
        ListCustomersResponse response = new ListCustomersResponse();
        final List<Customer> customers = customerService.findAll();
        for (Customer customer : customers)
        {

            tr.com.turkcell.crm.ws.customer.Customer wsCustomer = new tr.com.turkcell.crm.ws.customer.Customer();
            wsCustomer.setId(customer.getId());
            wsCustomer.setName(customer.getName());
            wsCustomer.setTckn(customer.getTckn());
            response.getCustomers().add(wsCustomer);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findCustomerRequest")
    @ResponsePayload
    public FindCustomerResponse findCustomer(@RequestPayload FindCustomerRequest request)
    {
        FindCustomerResponse response = new FindCustomerResponse();
        final Optional<Customer> _customer = customerService.findByTckn(request.getTckn());

        _customer.ifPresent(customer -> {
            tr.com.turkcell.crm.ws.customer.Customer wsCustomer = new tr.com.turkcell.crm.ws.customer.Customer();
            wsCustomer.setId(customer.getId());
            wsCustomer.setName(customer.getName());
            wsCustomer.setTckn(customer.getTckn());
            response.setCustomer(wsCustomer);
        });

        return response;
    }
}