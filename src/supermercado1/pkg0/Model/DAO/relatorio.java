/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.DAO;

import static groovy.xml.Entity.para;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.charts.JRDataRange;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author gildo
 */
public class relatorio 
{
    private static String fileName;
    private static HashMap hm=null;
    private static Connection bd=null;
    
    public static void imprimir(String fileName,HashMap hm)
    {
        Connection bd=new ConnectionBD().getConnection();
        String caminho="C:\\Users\\gildo\\Desktop";
        try {
            
            JasperPrint print = JasperFillManager.fillReport(fileName, hm, bd);
            //JRViewer viewer = new JRViewer(print);
            JasperExportManager.exportReportToPdfFile(print, caminho);
        } catch (Exception e) 
        {
            System.err.println("Error->"+e.getMessage());
        }
 
    }
    
    
}
