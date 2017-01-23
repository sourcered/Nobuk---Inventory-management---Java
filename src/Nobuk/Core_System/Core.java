package Nobuk.Core_System;

import Nobuk.DB_Mysql.Mysql_Operations;
import Nobuk.DB_Mysql.Mysql_OperationsI;

import java.util.ArrayList;
import java.util.List;

public class Core implements Base_core
{
    Mysql_OperationsI db_product = new Mysql_Operations();

    @Override
    public boolean add_quantity(int ID, int quantity)
    {
        return db_product.SQL_add_quantity(ID, quantity);
    }

    @Override
    public boolean remove_quantity(int ID, int quantity)
    {
        return db_product.SQL_remove_quantity(ID, quantity);
    }

    @Override
    public boolean add_product(int code, String name, int quantity)
    {
        return db_product.SQL_add_product(code, name, quantity);
    }

    @Override
    public boolean delete_product(int ID)
    {
        return db_product.SQL_delete_product(ID);
    }

    @Override
    public boolean att_product(int ID, int code, String name, int quantity)
    {
        return db_product.SQL_att_product(ID, code, name, quantity);
    }

    //Metodo para gerar uma lista de obj para ser trabalhada com a JTable
    @Override
    public List<Object> getProducts()
    {
        List<Object> product_OBJ = new ArrayList<>();

        List<Product> produtos = new ArrayList<>();
        //Para cada produto na lista que foi scaneada com QUERY de mysql
        for(Product product : produtos) //for(Product product : ClassOperacaoBancoDeDados.read())
        {
            product_OBJ.add(product);
        }

        return product_OBJ;
    }
}
