package home.pdm.dao;

import home.pdm.model.Orders;

import java.util.List;

public interface IOrderDAO {

    void save(Orders orders);

    List<Orders> findAllOrder();


}
