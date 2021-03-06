package com.example.demo.view

import com.example.demo.view.crud.CreateFragment
import com.example.demo.view.crud.DeleteFragment
import com.example.demo.view.crud.ReadFragment
import com.example.demo.view.crud.UpdateFragment
import javafx.scene.control.TabPane
import tornadofx.View
import tornadofx.tab
import tornadofx.tabpane

class Header : View() {
    override val root = tabpane{
        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
        tab<CreateFragment>()
        tab<ReadFragment>()
        tab<UpdateFragment>()
        tab<DeleteFragment>()
    }
}