package com.example.projetofinal.modelclass


import android.graphics.Bitmap

class MembroEquipa(nome: String, linkedin: String, mail: String, imagemUrl: Bitmap, cargo: String) {
    var nome: String = ""
    var linkedin: String = ""
    var mail: String = ""
    var imagemUrl: Bitmap
    var cargo: String = ""

    init{
        this.imagemUrl = imagemUrl
        this.linkedin = linkedin
        this.mail = mail
        this.nome = nome
        this.cargo = cargo
    }
}