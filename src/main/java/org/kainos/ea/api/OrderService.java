package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.OrderValidator;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.OrderDao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderService {
    private static OrderDao orderDao = new OrderDao();
    private static OrderValidator orderValidator = new OrderValidator();


    public static int createOrder(OrderRequest order) throws FailedToCreateOrderException, InvalidOrderException {
        try {
            String validation = orderValidator.isValidOrder(order);

            if (validation != null) {
                throw new InvalidOrderException(validation);
            }
            int id = orderDao.createOrder(order);

            if (id == -1) {
                throw new FailedToCreateOrderException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateOrderException();
        }
    }
    public void updateOrder(int id, OrderRequest order) throws InvalidOrderException, OrderDoesNotExistException, FailedToCreateOrderException{
        try {
            String validation = orderValidator.isValidOrder(order);

            if (validation != null) {
                throw new InvalidOrderException(validation);
            }
            Order orderToUpdate = orderDao.getOrderById(id);
            if (orderToUpdate == null) {
                throw new OrderDoesNotExistException();
            }
            orderDao.updateOrder(id, order);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateOrderException();
        }
    }
    public void deleteOrder(int id) throws OrderDoesNotExistException, FailedToDeleteOrderException{
        try {
            Order orderToDelete = orderDao.getOrderById(id);

            if (orderToDelete == null) {
                throw new OrderDoesNotExistException();
            }
            orderDao.deleteOrder(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteOrderException();
        }
    }

    public List<Order> getAllOrders() throws FailedToGetOrdersException {
        List<Order> orderList = null;
        try {
            orderList = orderDao.getAllOrders();
        } catch (SQLException e) {
            throw new FailedToGetOrdersException();
        }

        return orderList;
    }
    public Order getOrderById (int id) throws FailedToGetOrderException, OrderDoesNotExistException {
        try {
            Order order = orderDao.getOrderById(id);
            if (order == null) {
                throw new OrderDoesNotExistException();
            }
            return order;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetOrderException();
        }
    }
}

