package pl.zielinski.northwnd.northwnd2;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.zielinski.northwnd.northwnd2.model.CreateCustomerRequest;
import pl.zielinski.northwnd.northwnd2.model.CustomerResponse;
import pl.zielinski.northwnd.northwnd2.model.DeleteCustomerRequest;
import pl.zielinski.northwnd.northwnd2.model.UpdateCustomerRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Repository
public class CustomerRepository {

    // private final HikariConfig dataBaseConfig;

    private final HikariDataSource hikariDataSource;
    public int findNoOfCustomersWithoutOrders() {
//        HikariConfig conifig = new HikariConfig();
//        conifig.setJdbcUrl("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;encrypt=true;trustServerCertificate=true;database=NORTHWND");
//        conifig.setUsername("sa");
//        conifig.setPassword("4801232004");
        // i driver do polaczen


        // HikariDataSource ds = new HikariDataSource(dataBaseConfig);
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = hikariDataSource.getConnection();
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Customers c WHERE NOT EXISTS (SELECT * FROM ORDERS o WHERE o.customerid = c.customerid )");
            rs.next();
            int numberOfCustomers = rs.getInt(1);

            rs.close();
            stmt.close();
            conn.close();
            return numberOfCustomers;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    public List<CustomerResponse> findCustomersWithoutOrders()
    {
//        HikariConfig conifig = new HikariConfig();
//        conifig.setJdbcUrl("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;encrypt=true;trustServerCertificate=true;database=NORTHWND");
//        conifig.setUsername("sa");
//        conifig.setPassword("4801232004");
        // i driver do polaczen


        // HikariDataSource ds = new HikariDataSource(dataBaseConfig);
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = hikariDataSource.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers c WHERE NOT EXISTS (SELECT * FROM ORDERS o WHERE o.customerid = c.customerid )");
            List<CustomerResponse> customerResponses = new ArrayList<>();

            while(rs.next())
            {
                CustomerResponse customerResponse = new CustomerResponse();
                customerResponse.setCustomerId(rs.getString("CustomerID"));
                customerResponse.setCompanyName(rs.getString("CompanyName"));
                customerResponse.setContactName(rs.getString("ContactName"));
                customerResponses.add(customerResponse);
            }
            rs.close();
            stmt.close();
            conn.close();
            return customerResponses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<CustomerResponse>();
    }

    public boolean createCustomer(CreateCustomerRequest request)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            conn = hikariDataSource.getConnection();
            String query = "INSERT INTO Customers(CustomerID, CompanyName, ContactName) VALUES (?,?,?)";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, request.getCustomerId());
            stmt.setString(2, request.getCompanyName());
            stmt.setString(3, request.getContactName());

            int numberOfCustomers = stmt.executeUpdate();

            stmt.close();
            conn.close();

            return numberOfCustomers == 1;

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public boolean updateCustomer(UpdateCustomerRequest request)
    {

        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            conn = hikariDataSource.getConnection();
            String query = "UPDATE Customers SET CompanyName = ?, ContactName = ? WHERE CustomerID = ?";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, request.getCompanyName());
            stmt.setString(2, request.getContactName());
            stmt.setString(3, request.getCustomerId());

            int numberOfCustomers = stmt.executeUpdate();

            stmt.close();
            conn.close();

            return numberOfCustomers == 1;

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public boolean deleteCustomer(DeleteCustomerRequest request)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            conn = hikariDataSource.getConnection();
            String query = "DELETE FROM Customers WHERE CustomerID = ?";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, request.getCustomerId());

            int numberOfCustomers = stmt.executeUpdate();

            stmt.close();
            conn.close();

            return numberOfCustomers == 1;

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return false;
    }
}
