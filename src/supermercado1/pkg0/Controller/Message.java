/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Controller;

import javax.swing.JOptionPane;

/**
 *
 * @author gildo
 */
public class Message
{
    public Message() {
    }
    
    public void messageAlerta(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, "AVISO", JOptionPane.WARNING_MESSAGE);
    }
    public void messageError(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    public void messageSucesso(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
    }
    public void messageConfirmar(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, "CONFIRMAR", JOptionPane.QUESTION_MESSAGE);
    }
}
