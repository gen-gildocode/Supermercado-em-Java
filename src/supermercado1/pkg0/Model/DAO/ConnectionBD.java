/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gildo
 */
public class ConnectionBD 
{
    protected static Connection connection = null;
    protected static String usedatabase = "src/database/MinhasVendas.sql";
    protected static String sql= "show tables";
    private final String userName = "root";
    private final String password = "";
    private String jdbcDriver = null;
    private final String SERVIDOR = "localhost";
    private final String PORTA = "3306";
    private final String BANCO_DE_DADOS = "mysql";
    private final String bd = "supermercado";
    private final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DE_DADOS;
    private final String url = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + bd;

    public ConnectionBD(){   
    }
    
    public Connection getConnection() 
    {
        while(connection==null)
        {
            try 
            {
                connection=DriverManager.getConnection(url,userName,password);
                System.out.println("Conectado!!!!");
            }catch (SQLException e) 
            {
                System.out.println("Criar BD");
                JOptionPane.showMessageDialog(null, "Criando o Banco de Dado", "BANCO DE DADO-supermercado", JOptionPane.INFORMATION_MESSAGE);
                createdBD();
            }
        }
        return connection;
    }
    
    private void getSQL(String path)
    {
        File file=new File(path);
        String n2="", n="";
        try {
            FileReader ler=new FileReader(file);
            BufferedReader arq=new BufferedReader(ler);
            sql=arq.readLine();
            while(sql!=null)
            {
                if(sql.startsWith("--")||sql.startsWith("/"))
                {
                    sql=arq.readLine();
                }else {
                    n=n+sql+"\n";
                    if(sql.endsWith(";"))
                    {
                        n2=n;n="";
                        createdTB(n2);
                    }
                }
                sql=arq.readLine();
            }
            
        } catch (Exception e) 
        {
            System.err.println("Error ler->"+e.getMessage());
        }
    }
    
    
    private boolean createdTB(String texto)
    {
        boolean isExist=false;
        try 
            {
                connection.createStatement();
                connection=DriverManager.getConnection(url,userName,password);
                PreparedStatement stm=connection.prepareStatement(texto);
                isExist=stm.execute();
                System.out.println("Table  is created!!");
                isExist=true;
            } catch(SQLException e) 
            {
                System.err.println("Error created table->"+e.getMessage());
                isExist=false;
            } 
        
        return isExist;
    }
    private boolean createdBD()
    {
        boolean isExist=false;
        try 
        {
            connection=DriverManager.getConnection(URL,userName,password);
            PreparedStatement stm=connection.prepareStatement("CREATE DATABASE IF NOT EXISTS supermercado");
            stm.execute();
            System.out.println("Database  is created!!");
            JOptionPane.showMessageDialog(null, "BANCO DE DADO CRIADO COM SUCESSO!", "BANCO DE DADO-supermercado", JOptionPane.INFORMATION_MESSAGE);
            getSQL(usedatabase);
            isExist=true;
        } catch(SQLException e) 
        {
            System.err.println("Error created database->"+e.getMessage());
            isExist=false;
        }
        return isExist;
    }
    
    public static void main(String[] args) {
        ConnectionBD bd=new ConnectionBD();
        bd.getConnection();
    }
}

