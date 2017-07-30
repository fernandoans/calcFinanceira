import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import java.net.URL
import javax.swing.border.Border

/**
 * Projeto: Calculadora Financeira
 * Desenvolvedor: Fernando Anselmo
 * Função: Janela Inicial
 * Vídeos Disponíveis no meu canal
 *   1. Criação do Visor: https://youtu.be/yAWLiyPY-28
 *   2. Criação dos Botões: https://youtu.be/nhH2sOIQnyY
 *   3. Simulação do Pressionamento: https://youtu.be/CLz7dtaHxLw
 */
class Principal private constructor() :
        JFrame("Calculadora Finaceira") {
    private val painel = arrayOfNulls<Painel>(10)

    init {
        this.setSize(650, 400)
        val visor = JPanel()
        for (i in painel.indices) {
            painel[i] = Painel()
            painel[i]?.setNumero(("" + i)[0])
            visor.add(painel[i])
        }

        val pnBotoes = JPanel()
        pnBotoes.layout = GridLayout(4, 10)

        // Linha 01
        val btN = Botao("AMORT", "n", "12×")
        val btI = Botao("INT", "i", "12÷")
        val btPV = Botao("NPV", "PV", "CFo")
        val btPMT = Botao("RND", "PMT", "CFj")
        val btFV = Botao("IRR", "FV", "Nj")
        val btCHS = Botao("", "CHS", "DATE")
        val bt07 = Botao("", "7", "BEG")
        val bt08 = Botao("", "8", "END")
        val bt09 = Botao("", "9", "MEN")
        val btDv = Botao("", "÷", "")

        pnBotoes.add(btN)
        pnBotoes.add(btI)
        pnBotoes.add(btPV)
        pnBotoes.add(btPMT)
        pnBotoes.add(btFV)
        pnBotoes.add(btCHS)
        pnBotoes.add(bt07)
        pnBotoes.add(bt08)
        pnBotoes.add(bt09)
        pnBotoes.add(btDv)

        // Linha 02
        val btYX = Botao("PRICE", "y ͯ ", "√x͞")
        val bt1X = Botao("YTM", "1/x", "e ͯ ")
        val btPT = Botao("SL", "%T", "LN")
        val btDP = Botao("SOYD", "Δ%", "FRAC")
        val btP = Botao("DB", "%", "INTG")
        val btEEX = Botao("", "EEX", "ΔDYS")
        val bt04 = Botao("", "4", "D.MY")
        val bt05 = Botao("", "5", ".MDY")
        val bt06 = Botao("", "6", "x̅w")
        val btMl = Botao("", "✕", "")

        pnBotoes.add(btYX)
        pnBotoes.add(bt1X)
        pnBotoes.add(btPT)
        pnBotoes.add(btDP)
        pnBotoes.add(btP)
        pnBotoes.add(btEEX)
        pnBotoes.add(bt04)
        pnBotoes.add(bt05)
        pnBotoes.add(bt06)
        pnBotoes.add(btMl)

        // Linha 03
        val btRS = Botao("P/R", "R/S", "PSE")
        val btSST = Botao("∑", "SST", "BST")
        val btRD = Botao("PRGM", "R⬇", "GTO")
        val btXcY = Botao("FIN", "X⬌Y", "x≤y")
        val btCLX = Botao("REG", "CLX", "x=0")
        val btENT = Botao("PREFIX", "ENT", "LST x")
        val bt01 = Botao("", "1", "x̂,r")
        val bt02 = Botao("", "2", "ŷ,r")
        val bt03 = Botao("", "3", "n!")
        val btSb = Botao("", "−", "")

        pnBotoes.add(btRS)
        pnBotoes.add(btSST)
        pnBotoes.add(btRD)
        pnBotoes.add(btXcY)
        pnBotoes.add(btCLX)
        pnBotoes.add(btENT)
        pnBotoes.add(bt01)
        pnBotoes.add(bt02)
        pnBotoes.add(bt03)
        pnBotoes.add(btSb)

        // Linha 04
        val btON = Botao("", "ON", "")
        val btF = Botao("", "f", "")
        val btG = Botao("", "g", "")
        val btSTO = Botao("", "STO", "")
        val btRCL = Botao("", "RCL", "")
        val btHLP = Botao("", "HLP", "")
        val bt00 = Botao("", "0", "x̅")
        val btPnt = Botao("", ".", "S")
        val btSo = Botao("", "∑+", "∑-")
        val btSm = Botao("", "+", "")

        pnBotoes.add(btON)
        pnBotoes.add(btF)
        pnBotoes.add(btG)
        pnBotoes.add(btSTO)
        pnBotoes.add(btRCL)
        pnBotoes.add(btHLP)
        pnBotoes.add(bt00)
        pnBotoes.add(btPnt)
        pnBotoes.add(btSo)
        pnBotoes.add(btSm)


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
        border = BordaBotao(false)
        cursor = Cursor(Cursor.HAND_CURSOR)

        fnAlternativa1.font = Font("SansSerif", Font.BOLD, 12)
        fnAlternativa1.foreground = Color.YELLOW
        this.add(fnAlternativa1)

        fnPrimaria.font = Font("SansSerif", Font.BOLD, 20)
        fnPrimaria.foreground = Color.WHITE
        this.add(fnPrimaria)

        fnAlternativa2.font = Font("SansSerif", Font.BOLD, 12)
        fnAlternativa2.foreground = Color.BLUE
        this.add(fnAlternativa2)

        this.addMouseListener(object : MouseAdapter() {
            override fun mousePressed(ev: MouseEvent?) {
                border = BordaBotao(true)
            }
            override fun mouseReleased(ev: MouseEvent?) {
                border = BordaBotao(false)
            }
        })

    }
}
internal  class BordaBotao constructor(inverte: Boolean): Border {
    val inverte = inverte

    override fun getBorderInsets(p0: Component?): Insets {
        return Insets(6, 6, 6, 6)
    }
    override fun isBorderOpaque(): Boolean {
        return true
    }

    override fun paintBorder(c: Component,
        g: Graphics, x: Int, y: Int, w: Int, h: Int) {
        if (inverte) {
            g.color = Color.GRAY
        } else {
            g.color = Color.WHITE
        }
        g.drawLine(x+1, y+3, x+1, y+h-4)
        g.drawLine(x+3, y+1, x+w-4, y+1)
        g.drawLine(x+1, y+3, x+3, y+1)
        g.drawLine(x+1, y+h-4, x+3, y+h-2)
        if (inverte) {
            g.color = Color.WHITE
        } else {
            g.color = Color.GRAY
        }
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












