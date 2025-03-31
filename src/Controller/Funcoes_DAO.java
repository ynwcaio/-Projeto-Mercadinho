
package Controller;

import View.Caixa_GUI;
import static View.Caixa_GUI.cod_txt3;
import static View.Caixa_GUI.preco_txt3;
import static View.Caixa_GUI.qtd_txt3;
import static View.Caixa_GUI.res_txt3;
import View.Pedido_GUI;
import static View.Pedido_GUI.cod2_txt;
import static View.Pedido_GUI.contato_txt2;
import static View.Pedido_GUI.cpf_txt2;
import static View.Pedido_GUI.data_txt2;
import static View.Pedido_GUI.nome_txt2;
import static View.Pedido_GUI.produto_txt2;
import static View.Pedido_GUI.qtd_txt2;
import View.Produto_GUI;
import static View.Produto_GUI.categoria_txt;
import static View.Produto_GUI.cod_txt;
import static View.Produto_GUI.desc_txt;
import static View.Produto_GUI.nome_txt;
import static View.Produto_GUI.preco_txt;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Funcoes_DAO {

    public static int cod, mesa, produto, quantidade, mult;
 public static String nom, desc, categoria, status, data, cliente, nome, cpf, contato;
 public static double val, total, preco, res;
 
 public static String url = "jdbc:mysql://localhost/MERCADO"; // endereço do BD
 public static String username = "root";        //nome de um usuário de seu BD
 public static String password = "";  // senha do BD
 
 public static void total(){
      mult = Integer.valueOf(qtd_txt3.getText());
      preco = Double.parseDouble(preco_txt3.getText());
      res = preco * mult;
      DecimalFormat df = new DecimalFormat("0.00"); 
      res_txt3.setText(String.valueOf(df.format(res)));
    }
    
    public static void limpa(){
        res_txt3.setText("");
        preco_txt3.setText("");
        qtd_txt3.setText("");
    }
 
 public static void salvar(){
        // Início 
      nom = nome_txt.getText(); // recebendo o nome
      desc = desc_txt.getText();
      categoria = categoria_txt.getText();
      val = Float.valueOf(preco_txt.getText());// recebendo o preco

       Controller.Conecta_DAO.carregaDriver();
       
      try { 
               
                   
               
            Connection con = null;
            
            
    try {
    con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Produto_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }

            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO produto(nome_produto,desc_produto,preco_produto,categ_produto) VALUES('"+nom+"','"+desc+"','"+val+"','"+categoria+"')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nome_txt.setText("");
                desc_txt.setText("");
                preco_txt.setText("");
                categoria_txt.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            preco_txt.setText("");
        }
        
        //Fim
    }
 
 public static void salvar2(){
        // Início 
      data = data_txt2.getText();
      nome = nome_txt2.getText();
      cpf = cpf_txt2.getText();
      contato = contato_txt2.getText();
      produto = Integer.valueOf(produto_txt2.getText());
      quantidade = Integer.valueOf(qtd_txt2.getText());// recebendo o preco

       Controller.Conecta_DAO.carregaDriver();
       
      try { 
               
                   
               
            Connection con = null;
            
            
    try {
    con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Pedido_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }

            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO pedido(data_pedido,nome_pedido,contato_pedido,cpf_pedido,cod_produto,quantidade) VALUES('"+data+"','"+nome+"','"+contato+"','"+cpf+"','"+produto+"','"+quantidade+"')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                data_txt2.setText("");
                nome_txt2.setText("");
                contato_txt2.setText("");
                cpf_txt2.setText("");
                produto_txt2.setText("");
                qtd_txt2.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            qtd_txt2.setText("");
        }
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
        
        //Fim
    }
        
public static void consultar(){
        //inicio
        
        try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código

            int codigo = Integer.valueOf(cod_txt.getText());


            Controller.Conecta_DAO.carregaDriver(); // Carregando o driver

            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão

                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Produto_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta

                String sql = "SELECT nome_produto, desc_produto, preco_produto, categ_produto FROM produto where cod_produto = "+codigo;


                // Criando variavel que executara o comando da string sql

                Statement stm = (Statement) con.createStatement();

                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs

                ResultSet rs = stm.executeQuery(sql);

                int i=0; // Variavel utilizada para saber se ha dados cadastrados

                while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String nome = rs.getString("nome_produto");
                        String valor = rs.getString("preco_produto");
                        String descricao = rs.getString("desc_produto");
                        String categoria = rs.getString("categ_produto");
                        i++;

  //JOptionPane.showMessageDialog(null,"Nome: " + nome + "\nEmail: " +telefone + "\nTelefone: " +telefone, "Resultado",-1);
                        nome_txt.setText(String.valueOf(nome));
                        preco_txt.setText(String.valueOf(valor));
                        desc_txt.setText(String.valueOf(descricao));
                        categoria_txt.setText(String.valueOf(categoria));
                        

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod_txt.setText("");
        }
        
        //fim
    }

 
 public static void consultar2(){
        //inicio
        
        try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código

            int codigo = Integer.valueOf(cod2_txt.getText());

            Controller.Conecta_DAO.carregaDriver(); // Carregando o driver

            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão

                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Pedido_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta

                String sql = "SELECT data_pedido, nome_pedido, contato_pedido, cpf_pedido, cod_produto, quantidade FROM PEDIDO where codigo_pedido = "+codigo;


                // Criando variavel que executara o comando da string sql

                Statement stm = (Statement) con.createStatement();

                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs

                ResultSet rs = stm.executeQuery(sql);

                int i=0; // Variavel utilizada para saber se ha dados cadastrados

                while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String data = rs.getString("data_pedido");
                        String nome = rs.getString("nome_pedido");
                        String contato = rs.getString("contato_pedido");
                        String cpf = rs.getString("cpf_pedido");
                        String produto = rs.getString("cod_produto");
                        String quantidade = rs.getString("quantidade");
                        i++;

  //JOptionPane.showMessageDialog(null,"Nome: " + nome + "\nEmail: " +telefone + "\nTelefone: " +telefone, "Resultado",-1);
                        data_txt2.setText(String.valueOf(data));
                        nome_txt2.setText(String.valueOf(nome));
                        contato_txt2.setText(String.valueOf(contato));
                        cpf_txt2.setText(String.valueOf(cpf));
                        produto_txt2.setText(String.valueOf(produto));
                        qtd_txt2.setText(String.valueOf(quantidade));
                        

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod2_txt.setText("");
        }
        
        //fim
    }
 
 public static void alterar(){
        //inicio
        
         nom = nome_txt.getText(); // recebendo o nome  
         val = Float.valueOf(preco_txt.getText());// recebendo o telefone
         desc = desc_txt.getText(); // recebendo o email 
         categoria = categoria_txt.getText();
         int codigo = Integer.parseInt(cod_txt.getText());

       Controller.Conecta_DAO.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url, username, password);
      }catch (SQLException ex) {
            Logger.getLogger(Produto_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE produto SET nome_produto='"+nom+"',preco_produto='"+val+"',desc_produto='"+desc+"' WHERE cod_produto="+codigo;
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                cod_txt.setText("");
                nome_txt.setText("");
                preco_txt.setText("");
                desc_txt.setText("");
                categoria_txt.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException e){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            preco_txt.setText("");
        }
        
        //fim
    }
 
 public static void alterar2(){
        //inicio
      data = data_txt2.getText();
      nome = nome_txt2.getText();
      contato = contato_txt2.getText();
      cpf = cpf_txt2.getText(); 
      produto = Integer.valueOf(produto_txt2.getText());
      quantidade = Integer.valueOf(qtd_txt2.getText());
       int codigo = Integer.parseInt(cod2_txt.getText());

       Controller.Conecta_DAO.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url, username, password);
      }catch (SQLException ex) {
            Logger.getLogger(Pedido_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE pedido SET data_pedido='"+data+"',nome_pedido='"+nome+"',contato_pedido='"+contato+"', cpf_pedido='"+cpf+"', cod_produto='"+produto+"', quantidade='"+quantidade+"' WHERE codigo_pedido="+codigo;
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                data_txt2.setText("");
                nome_txt2.setText("");
                contato_txt2.setText("");
                cpf_txt2.setText("");
                produto_txt2.setText("");
                qtd_txt2.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException e){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            qtd_txt2.setText("");
        }
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
        
        //fim
    }
 
 public static void excluir(){
        //inicio
        Controller.Conecta_DAO.carregaDriver(); // Carregando o driver


        int codigo = Integer.valueOf(cod_txt.getText()); // Recebendo o código

                

        try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Produto_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM PRODUTO WHERE cod_produto = "+codigo;

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod_txt.setText("");

        }
        //fim
    }
 
 public static void excluir2(){
        //inicio
        Controller.Conecta_DAO.carregaDriver(); // Carregando o driver


        int codigo = Integer.valueOf(cod2_txt.getText()); // Recebendo o código

                

        try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Pedido_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM pedido WHERE codigo_pedido = "+codigo;

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod2_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod2_txt.setText("");

        }
        //fim
    }
 
 public static void excluir3(){
        //inicio
        Controller.Conecta_DAO.carregaDriver(); // Carregando o driver


        int codigo = Integer.valueOf(cod_txt3.getText()); // Recebendo o código

                

        try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Caixa_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM pedido WHERE codigo_pedido = "+codigo;

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod_txt3.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod_txt3.setText("");

        }
        //fim
        //fim
    }
    
}
