package com.example.demo.controller

import com.example.demo.utilities.HyperlinkDao
import com.example.demo.model.Hyperlink
import tornadofx.Controller
import tornadofx.SortedFilteredList
import tornadofx.observable

class HyperlinkController:Controller() {

    val hyperlinks = SortedFilteredList(items = getAllHyperlink().observable())

    private fun getAllHyperlink(): List<Hyperlink> = HyperlinkDao().readHyperlink()

    fun postHyperlink(title: String, url: String){
        val hyperlink = Hyperlink(title, url)
        val dao = HyperlinkDao()
        dao.addHyperlink(hyperlink)
    }

    fun readHyperlink(){
        val dao = HyperlinkDao()
        dao.readHyperlink()
    }

    fun sendHyperlink(title: String, url: String){
        val hyperlink = Hyperlink(title, url)
        val dao = HyperlinkDao()
        dao.deleteHyperlink(hyperlink)
    }

    fun updateHyperlink(oldHyperlink: Hyperlink, newTitleString: String, newUrlString: String){
        val newHyperlink = Hyperlink(newTitleString, newUrlString)
        val dao = HyperlinkDao()
        dao.updateHyperlink(oldHyperlink.title, newHyperlink)
        with(hyperlinks){
            remove(oldHyperlink)
            add(newHyperlink)
        }
    }
}