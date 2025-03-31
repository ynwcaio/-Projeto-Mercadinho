package Controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;



public class Relatorio_DAO {
    public static void Relatorio()throws Exception {

        Document doc = null;
        OutputStream os = null;
    String e = JOptionPane.showInputDialog(null, "Digite a Data: ");
    String x = JOptionPane.showInputDialog(null, "Digite o Nome do Cliente: ");
    String a = JOptionPane.showInputDialog(null, "Digite os Produtos do Cliente: ");
    String z = JOptionPane.showInputDialog(null, "Digite a Quantidade dos Produtos: "); 
    String y = JOptionPane.showInputDialog(null, "Valor Individual: ");  
    String c = JOptionPane.showInputDialog(null, "Valor Final: ");
    String b = JOptionPane.showInputDialog(null, "Digite a forma de Pagamento(PIX, DEBITO,CREDITO,DINHEIRO): ");  
   
  try {

            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72) {};

            //cria a stream de saída
            os = new FileOutputStream("F:\\Mercado\\Relatorio.pdf");

            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);

            //abre o documento
            doc.open();

            //adiciona o texto ao PDF a data é o y
            Paragraph par = new Paragraph("Data: " + e);
            doc.add(par);
           
            Paragraph par2 = new Paragraph("Cliente: " + x + " \nProdutos do Cliente: " + a + "\nQuantidade dos Produtos: " + z );
            doc.add(par2);
            
            Paragraph par3 = new Paragraph("Valor Individual: " + y + " \nValor Final: " + c + "\nForma de Pagamento: " + b );
            doc.add(par3);

        } finally {

            if (doc != null) {

                //fechamento do documento
                doc.close();
            }

            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
       
        Desktop.getDesktop().open(new File("F:\\Mercado\\Relatorio.pdf"));
    }
    
}
