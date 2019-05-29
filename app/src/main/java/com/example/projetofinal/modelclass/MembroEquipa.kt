package com.example.projetofinal.modelclass


import android.graphics.Bitmap

class MembroEquipa(nome: String, linkedin: String, mail: String, github: String, imagemUrl: Int, cargo: String ) {
    var nome: String = ""
    var linkedin: String = ""
    var mail: String = ""
    var github: String = ""
    var imagemUrl: Int
    var cargo: String = ""

    init{
        this.imagemUrl = imagemUrl
        this.linkedin = linkedin
        this.mail = mail
        this.github = mail
        this.nome = nome
        this.cargo = cargo
    }
}