
package DAO;

import Model.Lanche;
import Utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */


public class LancheDAO {
    
     /**
     * Método para salvar o prodto no banco.
     * @param obj Lanche - Objeto da classe produto
     * @return <code>boolean</code> - true: Conseguiu salvar o produto, false: Falha ao salvar, verifique a classe "GerenciadorConexao".
     */
    public static boolean Salvar(Lanche obj){
       
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
              conexao = GerenciadorConexao.abrirConexao();

              instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, modelo, tipo, preco, qtd_estoque) VALUES (?,?,?,?,?)"
                      , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNomeProduto());
            instrucaoSQL.setString(2, obj.getModeloProduto());
            instrucaoSQL.setString(3, obj.getTipoProduto());
            instrucaoSQL.setDouble(4, obj.getPrecoProduto());
            instrucaoSQL.setInt(5, obj.getQtdEstoque());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do produto
                if (generatedKeys.next()) {
                        obj.setIdProduto(generatedKeys.getInt(1));
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
    
    /**
     * Método para listar os produtos do banco.
     * @return <code>boolean</code> - true: Conseguiu listar os clientes, false: Falha ao listar, verifique a classe de conexão.
     */
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
                obj.setIdProduto(rs.getInt("id_produto"));
                obj.setNomeProduto(rs.getString("nome"));
                obj.setModeloProduto(rs.getString("modelo"));
                obj.setTipoProduto(rs.getString("tipo"));
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
    /**
     * Método para listar os produtos do banco a partir do nome.
     * @param pNome String nome do produto
     * @return <code>Arraylist</code> listaProdutos - retorna uma lista com os produtos do select.
     */
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
                obj.setIdProduto(rs.getInt("id_produto"));
                obj.setNomeProduto(rs.getString("nome"));
                obj.setModeloProduto(rs.getString("modelo"));
                obj.setTipoProduto(rs.getString("tipo"));
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
    
    /**
     * Método para listar os produtos do banco a partir do tipo.
     * @param pTipo String tipo do produto
     * @return <code>Arraylist</code> listaProdutos - retorna uma lista com os produtos do select.
     */
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
                obj.setIdProduto(rs.getInt("id_produto"));
                obj.setNomeProduto(rs.getString("nome"));
                obj.setModeloProduto(rs.getString("modelo"));
                obj.setTipoProduto(rs.getString("tipo"));
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
    
    /**
     * Método para excluir os produtos do banco.
     * @param pIdProduto int - ID do produto.
          * @return <code>boolean</code> - true: Conseguiu excluir o produto, false: Verifique se o produto já possui cadastro de compra, ou se for erro veja na classe "GerenciadorConexao".
     */
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
     /**
     * Método para alterar o cadastro do produto no banco.
     * @param obj Lanche - Objeto da classe Lanche
     * @return <code>boolean</code> - true: Conseguiu alterar o produto, false: Falha ao alterar, verifique a classe "GerenciadorConexao".
     */
    public static boolean atualizar(Lanche obj) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE produto set nome = ?, modelo = ?, tipo = ?, preco = ?, qtd_estoque= ? WHERE id_produto = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNomeProduto());
            instrucaoSQL.setString(2, obj.getModeloProduto());
            instrucaoSQL.setString(3, obj.getTipoProduto());
            instrucaoSQL.setDouble(4, obj.getPrecoProduto());
            instrucaoSQL.setInt(5, obj.getQtdEstoque());
            instrucaoSQL.setInt(6, obj.getIdProduto());

            
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
