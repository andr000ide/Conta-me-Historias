package com.app.projetofinal.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.app.projetofinal.LangHelper

import com.app.projetofinal.R
import kotlinx.android.synthetic.main.fragment_fragment_agradecimentos.view.*


class FragmentAgradecimentos() : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private lateinit var langHelper: LangHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_agradecimentos, container, false)

        view.ola1.setOnClickListener {
            var link: String = "http://portal2.ipt.pt/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!, intent, null)
        }
        view.ola2.setOnClickListener {
            var link: String = "https://sigarra.up.pt/fcup/pt/web_page.inicial"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!, intent, null)
        }
        view.ola6.setOnClickListener {
            var link: String = "https://www.kyoto-u.ac.jp/en/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!, intent, null)
        }
        view.ola4.setOnClickListener {
            var link: String = getString(R.string.liaad_url)
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!, intent, null)
        }

        view.ola5.setOnClickListener {
            var link: String = "http://foureyes.inesctec.pt/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!, intent, null)
        }

        view.ola7.setOnClickListener {
            var link: String = "https://www.fct.pt/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!, intent, null)
        }

        view.ola8.setOnClickListener {
            var link: String = "https://arquivo.pt/"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

            ContextCompat.startActivity(activity!!, intent, null)
        }

        langHelper = LangHelper(activity!!.applicationContext)

        if(langHelper.getLanguageSaved().equals("en")){
            view.ola3.setImageResource(R.drawable.logoci2en_tamanho)
            view.ola3.setOnClickListener {
                var link: String = "http://www.ci2.ipt.pt/en/"
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

                ContextCompat.startActivity(activity!!, intent, null)
            }
        }
        else{
            view.ola3.setImageResource(R.drawable.logoci2pt_tamanho)
            view.ola3.setOnClickListener {
                var link: String = "http://www.ci2.ipt.pt/"
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))

                ContextCompat.startActivity(activity!!, intent, null)
            }
        }






       // view.texto_outros.setText(Html.fromHtml(getString(R.string.outros_texto),3))
        view.texto_outros.movementMethod = LinkMovementMethod.getInstance()

        return view
    }




}
