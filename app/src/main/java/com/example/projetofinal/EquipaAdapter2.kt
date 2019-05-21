package com.example.projetofinal

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinal.modelclass.MembroEquipa
import kotlinx.android.synthetic.main.layout_listitem.view.*
import org.jetbrains.anko.toast

class EquipaAdapter2(val membros : ArrayList<MembroEquipa>, val context: Context) : RecyclerView.Adapter<ViewHolderThree>(){

    private var myClipboard: ClipboardManager? = null
    private var myClip: ClipData? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolderThree {
        val view = ViewHolderThree(LayoutInflater.from(context).inflate(R.layout.layout_listitem, p0, false))
/*
        view.membrolinkedin.setOnClickListener(){
            var lindin: String = membros.get(p1).linkedin
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(lindin))
            startActivity(context,intent, null)
        }*/


        return view
    }

    override fun getItemCount(): Int {
        return membros.size
    }

    @SuppressLint("ServiceCast")
    override fun onBindViewHolder(p0: ViewHolderThree, p1: Int) {
        p0.membroNome?.text = membros.get(p1).nome
        p0.membroCargo.text = membros.get(p1).cargo
        p0.membroImagem.setImageBitmap(membros.get(p1).imagemUrl)
        p0.membrolinkedin.setOnClickListener(){
            var lindin: String = membros.get(p1).linkedin
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(lindin))
            startActivity(context,intent, null)
        }
        p0.membroMail.setOnClickListener(){
            var mail: String = membros.get(p1).mail
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("copy text", mail)
            clipboard.primaryClip = clip
            context.toast(mail + "\n O email foi copiado.")
        }



    }

}

class ViewHolderThree (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    //val tvAnimalType = view.tv_animal_type
    val membroNome = view.nome
    val membroImagem = view.image
    val membroCargo = view.cargo
    val membrolinkedin = view.img_linkedin
    val membroMail = view.img_mail
}