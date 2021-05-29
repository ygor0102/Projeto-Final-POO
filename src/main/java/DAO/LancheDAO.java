
package DAO;

import Model.Lanche;
import Utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class LancheDAO {
    
  
    public static boolean Salvar(Lanche obj){
       
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
              conexao = GerenciadorConexao.abrirConexao();

              instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, modelo, tipo, preco, qtd_estoque) VALUES (?,?,?,?,?)"
                      , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getSabor());
            instrucaoSQL.setString(3, obj.getTipo());
            instrucaoSQL.setDouble(4, obj.getPrecoProduto());
            instrucaoSQL.setInt(5, obj.getQtdEstoque());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do produto
                if (generatedKeys.next()) {
                        obj.setIdLanche(generatedKeys.getInt(1));
                }else {
                        throw new SQLException("Falha ao obter o ID do produto!");
                }
            }else{
                retorno = false;
            }
            
        }catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            retorno = false;
        }finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                if(conexao!=null){
                    conexao.close();
                }
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    }
    

    public static ArrayList<Lanche> listar() {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Lanche> listaProdutos = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto;");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                Lanche obj = new Lanche();
                obj.setIdLanche(rs.getInt("id_produto"));
                obj.setNome(rs.getString("nome"));
                obj.setSabor(rs.getString("modelo"));
                obj.setTipo(rs.getString("tipo"));
                obj.setPrecoProduto(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                
                listaProdutos.add(obj);
            }
            
        }catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        }finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                if(conexao!=null){
                    conexao.close();
                }
                
              } catch (SQLException ex) {
             }
        }
        
        return listaProdutos;

    }

    public static ArrayList<Lanche> listarPorNome(String pNome) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Lanche> listaProdutos = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE nome like ?;");
            instrucaoSQL.setString(1, "%" + pNome + "%");
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                Lanche obj = new Lanche();
                obj.setIdLanche(rs.getInt("id_produto"));
                obj.setNome(rs.getString("nome"));
                obj.setSabor(rs.getString("modelo"));
                obj.setTipo(rs.getString("tipo"));
                obj.setPrecoProduto(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                
                listaProdutos.add(obj);
            }}catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        }finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                if(conexao!=null){
                    conexao.close();
                }
                
              } catch (SQLException ex) {
             }
        }
        
        return listaProdutos;

    }
    
    public static ArrayList<Lanche> listarPorTipo(String pTipo) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Lanche> listaProdutos = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE tipo like ?;");
            instrucaoSQL.setString(1, "%" + pTipo + "%");
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                Lanche obj = new Lanche();
                obj.setIdLanche(rs.getInt("id_produto"));
                obj.setNome(rs.getString("nome"));
                obj.setSabor(rs.getString("modelo"));
                obj.setTipo(rs.getString("tipo"));
                obj.setPrecoProduto(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                
                listaProdutos.add(obj);
            }}catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        }finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                if(conexao!=null){
                    conexao.close();
                }
                
              } catch (SQLException ex) {
             }
        }
        
        return listaProdutos;

    }
    
     public static boolean excluir(int pIdProduto){
    
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, pIdProduto);
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }else{
                retorno = false;
            }
            
        }catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            retorno = false;
        }finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                if(conexao!=null){
                    conexao.close();
                }
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    
    }
 
    public static boolean atualizar(Lanche obj) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE produto set nome = ?, modelo = ?, tipo = ?, preco = ?, qtd_estoque= ? WHERE id_produto = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getSabor());
            instrucaoSQL.setString(3, obj.getTipo());
            instrucaoSQL.setDouble(4, obj.getPrecoProduto());
            instrucaoSQL.setInt(5, obj.getQtdEstoque());
            instrucaoSQL.setInt(6, obj.getIdLanche());

            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }else{
                retorno = false;
            }
            
        }catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            retorno = false;
        }finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                if(conexao!=null){
                    conexao.close();
                }
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;

    }
    
    
    
    
    
}
