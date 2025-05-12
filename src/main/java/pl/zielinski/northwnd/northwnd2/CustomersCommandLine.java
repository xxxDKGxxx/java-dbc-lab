package pl.zielinski.northwnd.northwnd2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.zielinski.northwnd.northwnd2.model.CreateCustomerRequest;
import pl.zielinski.northwnd.northwnd2.model.CustomerResponse;
import pl.zielinski.northwnd.northwnd2.model.DeleteCustomerRequest;
import pl.zielinski.northwnd.northwnd2.model.UpdateCustomerRequest;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CustomersCommandLine implements CommandLineRunner {

    private final CustomersService customersService;
    @Override
    public void run(String... args) throws Exception {
        log.info("Run Customers validator.");

        int numberOfCustomersWithoutOrders = customersService.findNoOfCustomersWithoutOrders();
        log.info("Number of Customers without orders: {}", numberOfCustomersWithoutOrders);

        List<CustomerResponse> customersWithOutOrders = customersService.findCustomersWithoutOrders();

        for(CustomerResponse res : customersWithOutOrders)
        {
            log.info("User with id {} does not have an order. Data: {}", res.getCustomerId(), res);
        }

        CreateCustomerRequest request = new CreateCustomerRequest();
        request.setCustomerId("WRONA");
        request.setCompanyName("iGeoLAB");
        request.setContactName("Warszawa");

        boolean isCustomerCreated = customersService.createCustomer(request);
        if(isCustomerCreated)
        {
            log.info("Customer with id {} has been created.", request.getCustomerId());
        }
        else
        {
            log.info("Customer with id {} has not been created.", request.getCustomerId());
        }

        UpdateCustomerRequest request1 = new UpdateCustomerRequest();
        request1.setCustomerId("WRONA");
        request1.setCompanyName("iGeoLAB Company z.o.o");
        request1.setContactName("Warszawa");

        boolean isCustomerUpdated = customersService.updateCustomer(request1);
        if(isCustomerUpdated)
        {
            log.info("Customer with id {} has been updated.", request.getCustomerId());
        }
        else
        {
            log.info("Customer with id {} has not been updated.", request.getCustomerId());
        }

        DeleteCustomerRequest request2 = new DeleteCustomerRequest();
        request2.setCustomerId("WRONA");
        boolean isCustomerDeleted = customersService.deleteCustomer(request2);
        if(isCustomerDeleted)
        {
            log.info("Customer with id {} has been deleted.", request.getCustomerId());
        }
        else
        {
            log.info("Customer with id {} has not been deleted.", request.getCustomerId());
        }
    }
}
