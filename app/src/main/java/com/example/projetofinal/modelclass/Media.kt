package com.example.projetofinal.modelclass

class Media(organizacao: String, titulo: String, texto: String, link: String) {
    var organizacao: String = ""
    var titulo: String = ""
    var texto: String = ""
    var link: String = ""
    private var expanded: Boolean = false

    init {
        this.organizacao = organizacao
        this.titulo = titulo
        this.texto = texto
        this.link = link
    }

    fun setExpanded(expanded: Boolean){
        this.expanded = expanded
    }

    fun isExpanded() : Boolean{
        return expanded
    }
}