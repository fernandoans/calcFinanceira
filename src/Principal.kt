import javax.swing.*
import java.net.URL
import java.awt.BorderLayout
/**
 * Projeto: Calculadora Financeira
 * Desenvolvedor: Fernando Anselmo
 * Função: Janela Inicial
 * Vídeo Disponível:
 */
class Principal private constructor() :
        JFrame("Calculadora Finaceira") {
    private val painel = arrayOfNulls<Painel>(10)

    init {
        this.setSize(600, 400)
        val visor = JPanel()
        for (i in painel.indices) {
            painel[i] = Painel()
            painel[i]?.setNumero(("" + i)[0])
            visor.add(painel[i])
        }
        this.add(visor, BorderLayout.NORTH)
        this.isVisible = true
    }
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            Principal().defaultCloseOperation =
                JFrame.EXIT_ON_CLOSE
        }
    }

}
internal  class Painel : JPanel() {
    fun setNumero(valor: Char) {
        val fundo = JLabel()
        fundo.icon = Atributo.getImage("lcd_$valor.png")
        this.add(fundo)
    }
}
internal object  Atributo {
    fun getImage(s: String): ImageIcon? {
        val url = getResource("imagens/" + s)
        if (url != null)
            return ImageIcon(url)
        return null
    }
    private fun getResource(s: String): URL? {
        return ClassLoader.getSystemResource(s)
    }
}







