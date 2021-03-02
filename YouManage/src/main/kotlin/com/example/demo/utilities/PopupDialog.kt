package com.example.demo.utilities

import com.example.demo.app.Styles
import tornadofx.Fragment
import tornadofx.addClass
import tornadofx.label
import tornadofx.vbox

class PopupDialog :Fragment(){
    val message: String by param()
    override val root = vbox {
        label(message){
            addClass(Styles.heading)
        }


    }
}