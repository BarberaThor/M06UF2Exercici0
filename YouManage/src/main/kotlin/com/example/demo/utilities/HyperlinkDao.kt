package com.example.demo.utilities

import com.example.demo.model.Hyperlink


class HyperlinkDao {
    fun addHyperlink(hyperlink: Hyperlink){
        val connection = Database().connection
        val preparedStatement = connection.prepareStatement("INSERT INTO HyperLink(title, url) VALUES(?, ?)")
        preparedStatement.setString(1, hyperlink.title)
        preparedStatement.setString(2, hyperlink.url)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }

    fun deleteHyperlink(hyperlink: Hyperlink){
        val connection = Database().connection
        val preparedStatement = connection.prepareStatement("DELETE FROM Hyperlink WHERE title = ? AND url = ?")
        preparedStatement.setString(1, hyperlink.title)
        preparedStatement.setString(2, hyperlink.url)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }

    fun readHyperlink(): List<Hyperlink> {
        val connection = Database().connection

        val resultSet = connection
            .createStatement()
            .executeQuery("Select * FROM hyperlink")
        val hyperlinkList = ArrayList<Hyperlink>()
        while(resultSet.next()){

            val title = resultSet.getString("title")
            val url = resultSet.getString("url")
            hyperlinkList += Hyperlink(title, url)
        }
        println("Els valors de la Taula Hyperlink son els següents: ")
        println(hyperlinkList)
        resultSet.close()
        connection.close()
        return hyperlinkList
    }

    fun updateHyperlink(title: String, hyperlink: Hyperlink): Hyperlink{
        val connection = Database().connection
        var param = ""
        val paramUrl = ", url = ?"
        var optionalParamIndex = 2
        if(hyperlink.url.isNotEmpty()) param = paramUrl
        val preparedStatement = connection.prepareStatement("UPDATE Hyperlink SET title = ? $param WHERE title = ?")
        preparedStatement.setString(1, hyperlink.title)
        if(param.isNotEmpty()){
            preparedStatement.setString(optionalParamIndex, hyperlink.url)
            optionalParamIndex = optionalParamIndex.inc()
        }
        preparedStatement.setString(optionalParamIndex, title)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        return hyperlink
    }
}