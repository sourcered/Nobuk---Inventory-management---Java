package Nobuk.DB_Mysql;

import Nobuk.Core_System.Product;

import java.util.List;

public interface Mysql_OperationsI
{
    //Insert
    boolean SQL_add_product(int code, String name, int quantity);
    //Delete
    boolean SQL_delete_product(int id);
    //Update
    boolean SQL_add_quantity(int id, int quantity);
    //Update
    boolean SQL_remove_quantity(int id, int quantity);
    //Update
    boolean SQL_att_product(int ID, int code, String name, int quantity);
    //Select
    List<Product> SQL_getProducts();
    //Select a product
    Product SQL_getProduct(int id);
    ////Select a product by code
    Product SQL_getProductByCode(int code);
}
