package rodolfo.com.br.headerrecyclerview.model

data class Contato(val nome:String) : HeaderContato {

    override fun getTipoContato(): TipoContato {
        return TipoContato.CONTATO
    }
}

data class Header(val value:String):HeaderContato{

    override fun getTipoContato(): TipoContato {
       return TipoContato.HEADER
    }

}

enum class TipoContato{
    CONTATO,HEADER
}

interface HeaderContato{
    fun getTipoContato():TipoContato
}