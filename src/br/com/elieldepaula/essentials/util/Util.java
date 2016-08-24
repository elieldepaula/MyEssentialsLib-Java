
package br.com.elieldepaula.essentials.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Esta classe reúne alguns métodos usados com frequência em meus projetos.
 * 
 * @since 0.0.1 22/08/2016
 * @version 0.0.1
 * @author Eliel de Paula <dev@elieldepaula.com.br>
 */
public class Util {
    
    /**
     * Coloca o ícone no cantinho da janela - somente para windows e linux.
     * @param jf Objeto JFrame
     * @param iconName Nome do ícone, ex: "/icones/icone.png"
     */
    public void setIcon(JFrame jf, String iconName){
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconName)));
    }
    
    /**
     * Este metodo redimensioa uma janela JFrame.
     * @param jf Objeto JFrame
     * @param width Largura
     * @param height Altura
     */
    public static void resizeJFrame(JFrame jf, int width, int height){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds((screenSize.width - width) / 2, (screenSize.height - height) / 2, width, height);
    }
    
    /**
     * Este metodo retorna o texto digitado em um campo de senha.
     * @param var Valor digitado no campo.
     * @return String
     */
    public static String getTextFromPasswordField(char[] var) {
        char pass[] = var;
        return new String(pass);
    }
}
