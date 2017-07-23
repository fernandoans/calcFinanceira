import java.awt.*
import javax.swing.*
import java.net.URL
import javax.swing.border.Border

/**
 * Projeto: Calculadora Financeira
 * Desenvolvedor: Fernando Anselmo
 * Função: Janela Inicial
 * Vídeos Disponíveis no meu canal
 *   1. Criação do Visor: https://www.youtube.com/watch?v=yAWLiyPY-28&t=25s
 *   2. Criação dos Botões: https://www.youtube.com/watch?v=nhH2sOIQnyY&t=25s
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
        val pnBotoes = JPanel()
        pnBotoes.layout = GridLayout(4, 10)
        for (i in 1..4)
            for (j in 1..10)
                pnBotoes.add(Botao("F1:"+i+","+j, "P:"+i+","+j, "F2:"+i+","+j ))

        this.add(visor, BorderLayout.NORTH)
        this.add(pnBotoes)
        this.isVisible = true
    }
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            Principal().defaultCloseOperation =
                JFrame.EXIT_ON_CLOSE
        }
    }

}
internal class Botao constructor(fnA1: String, fnP: String, fnA2: String): JPanel() {
    var fnAlternativa1 = JLabel(fnA1, SwingConstants.CENTER)
    var fnPrimaria = JLabel(fnP, SwingConstants.CENTER)
    var fnAlternativa2 = JLabel(fnA2, SwingConstants.CENTER)

    init {
        background = Color.BLACK
        layout = GridLayout(3, 1)
        border = BordaBotao()

        fnAlternativa1.font = Font("SansSerif", Font.BOLD, 12)
        fnAlternativa1.foreground = Color.YELLOW
        this.add(fnAlternativa1)

        fnPrimaria.font = Font("SansSerif", Font.BOLD, 20)
        fnPrimaria.foreground = Color.WHITE
        this.add(fnPrimaria)

        fnAlternativa2.font = Font("SansSerif", Font.BOLD, 12)
        fnAlternativa2.foreground = Color.BLUE
        this.add(fnAlternativa2)
    }
}
internal  class BordaBotao: Border {
    override fun getBorderInsets(p0: Component?): Insets {
        return Insets(6, 6, 6, 6)
    }
    override fun isBorderOpaque(): Boolean {
        return true
    }

    override fun paintBorder(c: Component,
         g: Graphics, x: Int, y: Int, w: Int, h: Int) {
        g.color = Color.WHITE
        g.drawLine(x+1, y+3, x+1, y+h-4)
        g.drawLine(x+3, y+1, x+w-4, y+1)
        g.drawLine(x+1, y+3, x+3, y+1)
        g.drawLine(x+1, y+h-4, x+3, y+h-2)
        g.color = Color.GRAY
        g.drawLine(x+w-2, y+3, y+w-2, y+h-4)
        g.drawLine(x+3, y+h-2, x+w-4, y+h-2)
        g.drawLine(x+w-4, y+1, x+w-2, y+3)
        g.drawLine(x+w-2, y+h-4, x+w-4, y+h-2)
    }
}
internal class Painel : JPanel() {
    fun setNumero(valor: Char) {
        val fundo = JLabel()
        fundo.icon = Atributo.getImage("lcd_$valor.png")
        this.add(fundo)
    }
}
internal object Atributo {
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












