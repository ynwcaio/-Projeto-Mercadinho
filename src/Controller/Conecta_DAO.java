package Controller;


public class Conecta_DAO {
    public static  void carregaDriver(){
       try { // Conectando o driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver carregado com sucesso!");




       } catch (Exception ex) { // Erro driver não encontrado
            System.out.println("Driver nao pode ser carregado!");
        }

    }
}