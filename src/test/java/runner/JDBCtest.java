package runner;

import utilities.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCtest {
    //JDBC==>Java DataBase Connectivity
    public static void main(String[] args) throws IOException, SQLException {
        //Connection
        //Statement
        //ResultSet
        Connection connection= (Connection) DriverManager.getConnection(Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from employees");
        System.out.println( resultSet.getRow());
        resultSet.next();
        resultSet.next();
        resultSet.next();
        String myFirtsData=resultSet.getString("FIRST_NAME");
        System.out.println(myFirtsData);
        resultSet.next();
        System.out.println(resultSet.getObject("employee_id"));
        System.out.println(resultSet.getRow());
        ResultSetMetaData rsMeta=resultSet.getMetaData();
        System.out.println( rsMeta.getColumnCount());
        System.out.println(rsMeta.getColumnName(1));
        System.out.println(rsMeta.getColumnType(5));
        List<Map<String, Object>> listOfMaps = new ArrayList<>();
        while(resultSet.next()){

            Map<String,Object> row = new HashMap();
            for(int i=1; i<=rsMeta.getColumnCount(); i++) {
                row.put(rsMeta.getColumnName(i), resultSet.getObject(rsMeta.getColumnName(i)));
            }
            listOfMaps.add(row);
        }
    }
}
