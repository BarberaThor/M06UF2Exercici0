package com.example.demo.utilities

import java.sql.Connection
import java.sql.DriverManager

class Database {

    var connection: Connection

    init{
        //Class.forName("")
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_test","root","1234")
    }

}