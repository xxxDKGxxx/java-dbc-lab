package pl.zielinski.northwnd.northwnd2.model;


import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String customerId;
    private String companyName;
    private String contactName;
}
