package Nobuk.Core_System;

import java.util.List;

public interface Base_core
{
    boolean add_quantity(int ID, int quantity);
    boolean remove_quantity(int ID, int quantity);
    boolean add_product(int code, String name, int quantity);
    boolean delete_product(int ID);
    boolean att_product(int ID, int code, String name, int quantity);

    List<Object> getProducts();
}
