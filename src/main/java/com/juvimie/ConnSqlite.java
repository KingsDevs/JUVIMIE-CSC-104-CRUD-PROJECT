package com.juvimie;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnSqlite 
{
    private static Connection connection;
    private static Statement statement;

    private static String getDatabasePath() throws IOException
    {
        String path = new File(".").getCanonicalPath();
        path += "/data/data.db";

        return path;
    }

    public static Statement getStatement() throws SQLException, IOException 
    {
        if(statement == null)
        {
            statement = getConnection().createStatement();
        }

        return statement;
    }

    public static Connection getConnection() throws IOException 
    {
        if(connection == null)
        {
            String databasePath = ConnSqlite.getDatabasePath();
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:/" + databasePath);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    
        return connection;
    }
}
