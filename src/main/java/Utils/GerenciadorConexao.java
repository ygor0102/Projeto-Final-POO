package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GerenciadorConexao {
    
    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    
    public static String SERVER = "localhost";
    public static String DATABASE = "DBLanches";
    
    public static String LOGIN = "root";                   
    public static String SENHA = "";                         
    
    public static String URL = "";
    
    public static Connection CONEXAO;

    public GerenciadorConexao() {
    }
    
    /**
     * Método responsável por abrir a conexão com o driver mysql <b>(com.mysql.cj.jdbc.Driver)</b>
     * @return <code>Connection</code> CONEXAO
     * @throws ClassNotFoundException Exceção lançada caso não encontre o Driver de conexão.
     * @throws SQLException Exceção lançada caso tenha erro no login ou senha do usuário.
     */
    public static Connection abrirConexao() throws ClassNotFoundException,SQLException {
 
        URL = "jdbc:mysql://" + SERVER + ":3306/" +DATABASE + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
        
        if(CONEXAO==null)      
        {    
            try {

                //Carrega a classe responsável pelo driver
                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                } else {
                    STATUS = "Não foi possivel realizar a conexão";
                }

            } catch (ClassNotFoundException e) {  //Driver não encontrado

                throw new ClassNotFoundException("O driver expecificado nao foi encontrado.");

            } catch (SQLException e) {  //Erro ao estabelecer a conexão (Ex: login ou senha errados)

                //Outra falha de conexão
                throw new SQLException("Erro ao estabelecer a conexão (Ex: login ou senha errados).");
            }
            
        }
        else
        {
            try {
                //Se a conexão estiver fechada, reabro a conexão
                if(CONEXAO.isClosed())
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
            } catch (SQLException ex) {
                throw new SQLException("Falha ao abrir a conexão.");
            }
        }
        return CONEXAO;
    }
    
    /**
     * Método responsável por retornar o status da conexão.
     * @return <code>String</code> STATUS
     */
    public static String getStatusConexao() {
        return STATUS;
    }
    
    /**
     * Método responsável por fechar a conexão.
     * @return <code>boolean</code> retorno
     * @throws SQLException Exceção lançada caso o driver não esteja previamente conectado.
     */
    public static boolean fecharConexao() throws SQLException {
 
        boolean retorno = false;
        
        try {
            if(CONEXAO!=null){
                if(!CONEXAO.isClosed())
                    CONEXAO.close();
            }
            
            STATUS = "Não conectado";
            retorno = true;
            
         } catch (SQLException e) {
            retorno = false;
        }
        
        return retorno;
    }
   
}