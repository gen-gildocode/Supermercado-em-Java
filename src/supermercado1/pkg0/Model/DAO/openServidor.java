/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.DAO;

/**
 *
 * @author gildo
 */
public class openServidor 
{
    public static void abrirServidor()
    {
        String[] comando={"cmd.exe","/c","start","c://Xampp/mysql_start"};
        String[] exit={"exit"};
        try 
        {
            Process proc= Runtime.getRuntime().exec(comando,exit);
            System.out.println("Servidor aberto!!");
            Runtime.runFinalizersOnExit(true);
        } catch (Exception e) {
            
        }
    }
    
    public static void fechadoServidor()
    {
        String[] comando={"/c","start","c://Xampp/mysql_stop"};
        String[] exit={"exit"};
        try 
        {
            Process proc= Runtime.getRuntime().exec(comando,exit);
            System.out.println("Servidor fechado!!");
            Runtime.runFinalizersOnExit(true);
        } catch (Exception e) {
            
        }
    }
}
