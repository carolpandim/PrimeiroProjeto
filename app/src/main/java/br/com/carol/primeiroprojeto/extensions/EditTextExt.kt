package br.com.carol.primeiroprojeto.extensions

import android.widget.EditText

fun EditText.meuclear() = this.setText("")

fun EditText.value() = this.text.toString()