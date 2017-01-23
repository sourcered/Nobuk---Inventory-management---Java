package Nobuk.DB_Mysql;

import java.sql.*;

public class Mysql_ConnectionFactory implements Mysql_Constants
{

    public static Connection makeConnection()
    {
        Connection con = null;
        try
        {
            try {Class.forName(DRIVER);}
            catch (ClassNotFoundException ex) {ex.printStackTrace(); System.out.print("Falha DRIVER");}

            con = DriverManager.getConnection(URL, USER, PASS);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            System.out.print("Falha Conexão.");
            try {con.rollback();}
            catch (SQLException ex1) {ex1.printStackTrace(); System.out.print("Falha rollback() -< Connection.");}
        }
        return con;
    }

    public static boolean closeConnection(Connection con)
    {
        if(con != null)
        {
            try
            {
                con.close();
                return true;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static boolean closePreparedStatement(PreparedStatement pstm)
    {
        if(pstm != null)
        {
            try
            {
                pstm.close();
                return true;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static boolean closeStatement(Statement stm)
    {
        if(stm != null)
        {
            try
            {
                stm.close();
                return true;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static boolean closeResultSet(ResultSet rs)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
                return true;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
        return false;
    }
}
