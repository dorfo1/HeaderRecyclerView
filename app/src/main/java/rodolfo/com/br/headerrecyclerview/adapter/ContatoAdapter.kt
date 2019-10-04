package rodolfo.com.br.headerrecyclerview.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_row.view.*
import kotlinx.android.synthetic.main.name_row.view.*
import rodolfo.com.br.headerrecyclerview.R
import rodolfo.com.br.headerrecyclerview.model.Contato
import rodolfo.com.br.headerrecyclerview.model.Header
import rodolfo.com.br.headerrecyclerview.model.HeaderContato
import rodolfo.com.br.headerrecyclerview.model.TipoContato


class ContatoAdapter(private val contatos : List<HeaderContato>) :
    RecyclerView.Adapter<ContatoAdapter.ContatoHolder>() {


    val HEADER_TYPE = 10
    val CONTATO_TYPE = 11



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoHolder {
        val inflater = LayoutInflater.from(parent.context)
        var view:View
        view = if (viewType == HEADER_TYPE){
            inflater.inflate(R.layout.header_row,parent,false)
        }else {
            inflater.inflate(R.layout.name_row,parent,false)
        }
        return ContatoHolder(view)
    }

    override fun getItemCount(): Int {
        return contatos.size
    }

    override fun onBindViewHolder(holder: ContatoHolder, position: Int) {
        if(getItemViewType(position)==HEADER_TYPE){
            var header  = contatos[position] as Header
            holder.itemView.header.text = header.value
        }else if(getItemViewType(position)==CONTATO_TYPE){
            var contato = contatos[position] as Contato
            holder.itemView.name.text = contato.nome
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(contatos[position].getTipoContato()== TipoContato.HEADER) HEADER_TYPE else CONTATO_TYPE
    }


    class ContatoHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}













