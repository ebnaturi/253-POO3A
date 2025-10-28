package org.ej3b.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class ConfigDB {
    private static HikariDataSource dataSource;

    public static DataSource getDataSource(){
        if(dataSource == null){
                String host = "localhost";
                String port = "3306";
                String dbName = "ejemplo3a";
                String user = "root";
                String password = "";
                String url = "jdbc:mysql://" + host +
                        ":" + port + "/" + dbName;

                HikariConfig conf = new HikariConfig();
                conf.setJdbcUrl(url);
                conf.setUsername(user);
                conf.setPassword(password);
                conf.setDriverClassName("com.mysql.cj.jdbc.Driver");

            dataSource = new HikariDataSource(conf);
        }
        return dataSource;

    }
}








