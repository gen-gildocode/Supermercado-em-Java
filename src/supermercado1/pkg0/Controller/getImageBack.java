/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Controller;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author gildo
 */
public class getImageBack 
{
    private String urlico;

    public getImageBack() {
    }

    public Image getImage() 
    {
        URL caminhoImagem = this.getClass().getResource("/Icones/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        return iconeTitulo;
    }
    
    public ImageIcon getback()
    {
        ImageIcon iconeTitulo=new ImageIcon(getClass().getResource("/Icones/icone 2.png"));
        return iconeTitulo;
    }
    
}
