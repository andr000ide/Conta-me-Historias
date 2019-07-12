package com.app.projetofinal.Fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

import com.app.projetofinal.R
import kotlinx.android.synthetic.main.fragment_credits.view.*
import org.jetbrains.anko.toast


class fragment_credits : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_credits, container, false)

        view.img_github2.setOnClickListener {
            var link: String = "https://github.com/simaosamouco"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!.applicationContext, intent, null)
        }
        view.img_github.setOnClickListener {
            var link: String = "https://github.com/andr000ide"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!.applicationContext, intent, null)
        }
        view.img_linkedin.setOnClickListener {
            var link: String = "https://www.linkedin.com/in/jo%C3%A3o-ricardo-campos-869918167/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!.applicationContext, intent, null)
        }
        view.img_linkedin2.setOnClickListener {
            var link: String = "https://www.linkedin.com/in/sim%C3%A3o-samouco-48916915b/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!.applicationContext, intent, null)
        }
        view.img_linkedin3.setOnClickListener {
            var link: String = "https://www.linkedin.com/in/camposricardo/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!.applicationContext, intent, null)
        }
        view.img_mail.setOnClickListener(){
            var mail = "andr1ide@hotmail.com"
            val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("copy text", mail)
            clipboard.primaryClip = clip
            context!!.toast(mail +"\n"+ getString(R.string.mail_foi_copiado))
        }
        view.img_mail2.setOnClickListener(){
            var mail = "simao.samouco@hotmail.com"
            val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("copy text", mail)
            clipboard.primaryClip = clip
            context!!.toast(mail +"\n"+ getString(R.string.mail_foi_copiado))
        }
        view.img_mail3.setOnClickListener(){
            var mail = "ricardo.campos@ipt.pt"
            val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("copy text", mail)
            clipboard.primaryClip = clip
            context!!.toast(mail +"\n"+ getString(R.string.mail_foi_copiado))
        }


        return view
    }


}
