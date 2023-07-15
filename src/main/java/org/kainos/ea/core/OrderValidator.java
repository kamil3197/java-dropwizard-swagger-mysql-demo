package org.kainos.ea.core;

import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.db.CustomerDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OrderValidator {
    public String isValidOrder(OrderRequest order) throws SQLException {
        CustomerDao customerDao = new CustomerDao();
        if (customerDao.getCustomerById(order.getCustomerId()) == null) {
            return "Invalid customer";
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate oneYearAgo = currentDate.minus(1, ChronoUnit.YEARS);
        LocalDate orderDate = order.getOrderDate().toLocalDate();

        if (orderDate.isBefore(oneYearAgo)) {
            return "Order date is over a year ago";
        }

        return null;
    }
}
