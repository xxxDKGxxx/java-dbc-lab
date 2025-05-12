package pl.zielinski.northwnd.northwnd2;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zielinski.northwnd.northwnd2.model.CreateCustomerRequest;
import pl.zielinski.northwnd.northwnd2.model.CustomerResponse;
import pl.zielinski.northwnd.northwnd2.model.DeleteCustomerRequest;
import pl.zielinski.northwnd.northwnd2.model.UpdateCustomerRequest;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomersService {
    private final CustomerRepository customerRepository;

    public int findNoOfCustomersWithoutOrders() {
        return customerRepository.findNoOfCustomersWithoutOrders();
    }

    public List<CustomerResponse> findCustomersWithoutOrders()
    {
        return customerRepository.findCustomersWithoutOrders();
    }

    public boolean createCustomer(CreateCustomerRequest request)
    {
        return customerRepository.createCustomer(request);
    }

    public boolean updateCustomer(UpdateCustomerRequest request)
    {
        return customerRepository.updateCustomer(request);
    }

    public boolean deleteCustomer(DeleteCustomerRequest request)
    {
        return customerRepository.deleteCustomer(request);
    }
}
