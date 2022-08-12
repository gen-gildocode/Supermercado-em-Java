/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.Bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author gildo
 */
public class DataHora 
{
    public static String dataActual()
    {
        Date data=new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        String Data=format.format(data);
        return Data;
    }
    
    public static String Hora()
    {
        Date data=new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        String hora=format.format(data);
        return hora;
    }
    
}
