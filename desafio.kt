// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String){
    var matricula:Int? = null

}

abstract class ControleMatriculas{
    var matriculas = 0
    abstract fun incrementar()
}
class ContadorConcreto : ControleMatriculas() {
    override fun incrementar() {
        matriculas++
    }
}
data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()
    private val contador = ContadorConcreto()

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).");
        contador.incrementar()
        usuario.matricula= contador.matriculas
        inscritos.add(usuario)
        println("Usuário ${usuario.matricula} - ${usuario.nome} matriculado no curso de $nome com sucesso")
    }


}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val ementaKotlin = mutableListOf<ConteudoEducacional>()

    val variaveis = ConteudoEducacional("Tipos de variáveis", 20, Nivel.BASICO)
    val poo = ConteudoEducacional("Programação Orientada a Objetos", 60, Nivel.DIFICIL)
    val bancoDeDados = ConteudoEducacional("Banco de Dados", 40, Nivel.INTERMEDIARIO)

    ementaKotlin.addAll(listOf(poo,bancoDeDados,variaveis))

    val kotlin = Formacao("Kotlin",ementaKotlin)

    val usuario1 = Usuario("Ian")
    kotlin.matricular(usuario1)
    val usuario2 = Usuario("Marcos")
    kotlin.matricular(usuario2)
    val usuario3 = Usuario("Pedro")
    kotlin.matricular(usuario3)

}
