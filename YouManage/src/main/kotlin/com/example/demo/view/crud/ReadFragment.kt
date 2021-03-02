package com.example.demo.view.crud

import com.example.demo.controller.HyperlinkController
import com.example.demo.utilities.PopupDialog
import javafx.beans.property.SimpleStringProperty
import javafx.stage.StageStyle
import tornadofx.*

class ReadFragment: Fragment("Read") {

    private val tableString = SimpleStringProperty()
    private val hyperlinkController: HyperlinkController by inject()

    override val root = vbox{

            button("Read Table") {
                action {
                    runAsync {
                        hyperlinkController.readHyperlink()//tableString.value
                    }.ui {
                        tableString.value = "";
                        find<PopupDialog>(params = mapOf("message" to "Readed!")).openModal(StageStyle.UTILITY)
                    }
                }
            }
        }
    }
