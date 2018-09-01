package br.com.carol.primeiroprojeto.extensions

fun Double.format(digitos: Int) = String.format("%.${digitos}f",this)