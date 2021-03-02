package com.example.demo.view.crud

import com.example.demo.controller.HyperlinkController
import com.example.demo.utilities.PopupDialog
import javafx.beans.property.SimpleStringProperty
import javafx.stage.StageStyle
import tornadofx.*

class DeleteFragment: Fragment("Delete") {

    private val titleString = SimpleStringProperty()
    private val urlString = SimpleStringProperty()
    private val hyperlinkController: HyperlinkController by inject()

    override val root = vbox{
        form {
            fieldset{
                field("Title")
                textfield(titleString)
                field("Url")
                textfield(urlString)
            }
            button("Delete Hyperlink") {
                action {
                    runAsync {
                        hyperlinkController.sendHyperlink(titleString.value, urlString.value)
                    }.ui {
                        titleString.value = ""; urlString.value = ""
                        find<PopupDialog>(params = mapOf("message" to "Hyperlink Deleted")).openModal(StageStyle.UTILITY)
                    }
                }
            }
        }
    }
}