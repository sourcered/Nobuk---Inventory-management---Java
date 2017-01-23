package Nobuk.DB_Mysql;

import Nobuk.Core_System.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mysql_Operations implements Mysql_OperationsI , Mysql_Constants
{
    @Override
    public boolean SQL_add_product(int code, String name, int quantity)
    {
        boolean state = false;
        Connection con = null;
        PreparedStatement pstm = null;

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            pstm = con.prepareStatement(SQL_INSERT);

            pstm.setInt(1, code);
            pstm.setString(2, name);
            pstm.setInt(3, quantity);

            pstm.execute();

            state = true;

            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closePreparedStatement(pstm);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return state;
    }

    @Override
    public boolean SQL_delete_product(int id)
    {
        boolean state = false;
        Connection con;
        PreparedStatement pstm;

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            pstm = con.prepareStatement(SQL_DELETE);

            pstm.setInt(1, id);

            pstm.execute();

            state = true;

            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closePreparedStatement(pstm);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Falha Deletar produto.");
        }

        return state;
    }

    @Override
    public boolean SQL_add_quantity(int id, int quantity)
    {
        boolean state = false;
        Connection con;
        PreparedStatement pstm;
        Product p;

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            pstm = con.prepareStatement(SQL_UPDATE);

            p = SQL_getProduct(id);

            int qtd = p.getQuantity() + quantity;

            pstm.setInt(1, qtd);
            pstm.setInt(2, id);

            pstm.executeUpdate();

            state = true;

            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closePreparedStatement(pstm);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return state;
    }

    @Override
    public boolean SQL_remove_quantity(int id, int quantity)
    {
        boolean state = false;
        Connection con;
        PreparedStatement pstm;
        Product p;

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            pstm = con.prepareStatement(SQL_UPDATE);

            p = SQL_getProduct(id);
            int qtd = p.getQuantity() - quantity;

            if (qtd >= 0)
            {
                pstm.setInt(1, qtd);
                pstm.setInt(2, id);
                pstm.executeUpdate();
                state = true;
            }

            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closePreparedStatement(pstm);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return state;
    }

    @Override
    public boolean SQL_att_product(int ID, int code, String name, int quantity)
    {
        boolean state = false;
        Connection con;
        PreparedStatement pstm;

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            pstm = con.prepareStatement(SQL_ATT);

            pstm.setInt(1, code);
            pstm.setString(2, name);
            pstm.setInt(3, quantity);
            pstm.setInt(4, ID);

            pstm.execute();

            state = true;

            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closePreparedStatement(pstm);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return state;
    }

    @Override
    public List<Product> SQL_getProducts()
    {
        Connection con;
        ResultSet rs;
        Statement stm;
        List<Product> listProducts = new ArrayList<Product>();
        Product p = null;

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            stm = con.createStatement();

            String sql = "SELECT * FROM CE";
            rs = stm.executeQuery(sql);
            while(rs.next())
            {
                p = new Product();
                p.setId(rs.getInt("ID"));
                p.setCode(rs.getInt("code"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));

                listProducts.add( p );
            }
            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closeStatement(stm);
            Mysql_ConnectionFactory.closeResultSet(rs);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return listProducts;
    }

    @Override
    public Product SQL_getProduct(int id)
    {
        Connection con;
        Statement stm;
        Product p = new Product();

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            stm = con.createStatement();

            String sql = "SELECT * FROM CE WHERE ID=" + id;
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                p.setId(rs.getInt("ID"));
                p.setCode(rs.getInt("code"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                rs.next();
            }

            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closeStatement(stm);
            Mysql_ConnectionFactory.closeResultSet(rs);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return p;
    }


    @Override
    public Product SQL_getProductByCode(int code)
    {
        Connection con;
        Statement stm;
        Product p = new Product();

        try
        {
            con = Mysql_ConnectionFactory.makeConnection();
            stm = con.createStatement();

            String sql = "SELECT * FROM CE WHERE code=" + code;
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                p.setId(rs.getInt("ID"));
                p.setCode(rs.getInt("code"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                rs.next();
            }

            Mysql_ConnectionFactory.closeConnection(con);
            Mysql_ConnectionFactory.closeStatement(stm);
            Mysql_ConnectionFactory.closeResultSet(rs);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return p;
    }
}
