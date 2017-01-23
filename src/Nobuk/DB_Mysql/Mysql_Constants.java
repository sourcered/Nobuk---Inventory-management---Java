package Nobuk.DB_Mysql;

public interface Mysql_Constants
{
    String DB_NAME = "nobuk";
    String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false";
    String USER = "root";
    String PASS = "1234";
    String DRIVER = "com.mysql.jdbc.Driver";

    String SQL_INSERT = "INSERT INTO ce (code, name, quantity) VALUES (?,?,?)";
    String SQL_UPDATE = "UPDATE ce SET quantity=? WHERE ID=?";
    String SQL_ATT = "UPDATE ce SET code=?, name=?, quantity=? WHERE ID=?";
    String SQL_DELETE = "DELETE FROM ce WHERE ID=?";
    String SQL_SELECT = "SELECT * FROM ce";
    String SQL_SELECT_ONE = "SELECT * FROM ce WHERE ID=?";
    String SQL_DELETE_AFTER[] = {"ALTER TABLE CE DROP ID" , "ALTER TABLE CE AUTO_INCREMENT = 1" , "ALTER TABLE CE ADD ID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST"};
}
