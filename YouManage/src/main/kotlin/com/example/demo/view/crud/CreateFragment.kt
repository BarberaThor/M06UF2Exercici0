package com.example.demo.view.crud

import com.example.demo.controller.HyperlinkController
import com.example.demo.utilities.PopupDialog
import javafx.beans.property.SimpleStringProperty
import javafx.stage.StageStyle
import tornadofx.*

class CreateFragment:Fragment("Create") {

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
            button("Create Hyperlink") {
                action {
                runAsync {
                    hyperlinkController.postHyperlink(titleString.value, urlString.value)
                }.ui {
                    titleString.value = ""; urlString.value = ""
                    find<PopupDialog>(params = mapOf("message" to "New Hyperlink Added")).openModal(StageStyle.UTILITY)
                }
            }
            }
        }
    }
}