/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author joseg
 */
public class Conexion {

    private static Connection con;
    private static BasicDataSource dataSource;

    private Conexion() {
    }
    
    public static DataSource getDataSource(){
        if(dataSource == null){
            try {
            Class.forName("com.mysql.jdbc.Driver");            
            //String JDBC_URL = "jdbc:mysql://root:admin@localhost:3306/heroesapp";
            String JDBC_URL = "jdbc:mysql://bf95d46bebfd32:c03ee9d1@us-cdbr-east-06.cleardb.net/heroku_868dcc0725966ea?reconnect=true";
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setInitialSize(0);
            } catch (Exception e) {
                throw new RuntimeException("Error al conectad la BD" + e);
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
