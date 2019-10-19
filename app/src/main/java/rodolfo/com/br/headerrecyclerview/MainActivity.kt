package rodolfo.com.br.headerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import rodolfo.com.br.headerrecyclerview.adapter.ContatoAdapter
import rodolfo.com.br.headerrecyclerview.model.Contato
import rodolfo.com.br.headerrecyclerview.model.Header
import rodolfo.com.br.headerrecyclerview.model.HeaderContato

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = arrayListOf<String>(
            "Maria",
            "Amanda",
            "Ana",
            "Bruno",
            "Rafael",
            "Rodolfo",
            "João",
            "Felipe",
            "Matheus",
            "José",
            "Paulo",
            "Paula"
        )
        val letras = gerarLetras()


        list.sort()
        val adapter = ContatoAdapter(gerarLista(letras, list))
        rvNomes.adapter = adapter
        rvNomes.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun gerarLetras(): ArrayList<String> {
        var list = ArrayList<String>()
        for (s in 'a'..'z'){
            list.add(s.toString().toUpperCase())
        }
        return list
    }

    private fun gerarLista(
        letras: ArrayList<String>,
        contato: ArrayList<String>
    ): List<HeaderContato> {
        var temp = ""
        var lista: MutableList<HeaderContato> = ArrayList()
        letras.forEach { letra ->
            contato.forEach { nome ->
                if (nome.startsWith(letra)) {
                    if (letra != temp) {
                        lista.add(Header(letra))
                        temp = letra
                    }
                    if (temp == letra) {
                        lista.add(Contato(nome))
                    }
                }
            }
        }

        return lista
    }
}
