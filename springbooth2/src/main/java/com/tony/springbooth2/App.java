package com.tony.springbooth2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	@Autowired
	ActionRepository actionRepository;
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    //@PreDestroy
    public void init(){
    	 Connection connection = null;
    	    ResultSet resultSet = null;
    	    Statement statement = null;
    	 try {
    	        Class.forName("org.h2.Driver");
    	        connection = DriverManager.getConnection(
    	                "jdbc:h2:file:D:\\h2\\mydb", "sa", "sa");
    	        statement = connection.createStatement();
    	        resultSet = statement
    	                .executeQuery("CALL CSVWRITE('action.csv', 'SELECT * FROM t_action');");
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    } finally {
    	        try {
    	            resultSet.close();
    	            statement.close();
    	            connection.close();
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	    }
    	        
    }
    
}
