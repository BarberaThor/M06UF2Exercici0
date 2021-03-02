package com.example.demo.view.crud

import com.example.demo.controller.HyperlinkController
import com.example.demo.model.Hyperlink
import com.example.demo.utilities.PopupDialog
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.stage.StageStyle
import tornadofx.*

class UpdateFragment: Fragment("Update") {

    private val comboboxObject = SimpleObjectProperty<Hyperlink>()
    private val newTitleString = SimpleStringProperty()
    private val newUrlString = SimpleStringProperty()
    private val hyperlinkController: HyperlinkController by inject()

    override val root = vbox{
        form {
            combobox<Hyperlink>(comboboxObject, values = hyperlinkController.hyperlinks.observable()){
                cellFormat{
                    text = this.item.title
                }
            }

            fieldset{
                field("New Title")
                textfield(newTitleString)
                field("New Url")
                textfield(newUrlString)
            }
            button("Update Hyperlink") {
                action {
                        hyperlinkController.updateHyperlink(
                            comboboxObject.get(),
                            newTitleString.value,
                            newUrlString.valueSafe
                        )
                        newTitleString.value = "";newUrlString.value = "";comboboxObject.value = null
                        find<PopupDialog>(mapOf("message" to "Hyperlink Updated")).openModal(StageStyle.UTILITY)
                }
            }
        }
    }
}