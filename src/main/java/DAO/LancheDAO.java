
package DAO;

import Model.Lanche;
import Model.LancheEspecial;
import Utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class LancheDAO {
    
  
    public static boolean Salvar(LancheEspecial obj){
       
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
              conexao = GerenciadorConexao.abrirConexao();

              instrucaoSQL = conexao.prepareStatement("INSERT INTO lanche (nome, sabor, tipo, preco, qtd_estoque, acompanhamento_adicional) VALUES (?,?,?,?,?,?)"
                      , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getSabor());
            instrucaoSQL.setString(3, obj.getTipo());
            instrucaoSQL.setDouble(4, obj.getPrecoProduto());
            instrucaoSQL.setInt(5, obj.getQtdEstoque());
            instrucaoSQL.setString(6, obj.getAcompanhamentoAdicional());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do lanche
                if (generatedKeys.next()) {
                        obj.setIdLanche(generatedKeys.getInt(1));
                }else {
                        throw new SQLException("Falha ao obter o ID do lanche!");
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
    

    public static ArrayList<LancheEspecial> listar() {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<LancheEspecial> listaLanches = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM lanche;");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                LancheEspecial obj = new LancheEspecial();
                obj.setIdLanche(rs.getInt("id_lanche"));
                obj.setNome(rs.getString("nome"));
                obj.setSabor(rs.getString("sabor"));
                obj.setTipo(rs.getString("tipo"));
                obj.setPrecoProduto(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                obj.setAcompanhamentoAdicional(rs.getString("acompanhamento_adicional"));
                
                listaLanches.add(obj);
            }
            
        }catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaLanches = null;
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
        
        return listaLanches;

    }

    public static ArrayList<LancheEspecial> listarPorNome(String pNome) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<LancheEspecial> listaLanches = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM lanche WHERE nome like ?;");
            instrucaoSQL.setString(1, "%" + pNome + "%");
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                LancheEspecial obj = new LancheEspecial();
                obj.setIdLanche(rs.getInt("id_lanche"));
                obj.setNome(rs.getString("nome"));
                obj.setSabor(rs.getString("sabor"));
                obj.setTipo(rs.getString("tipo"));
                obj.setPrecoProduto(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                obj.setAcompanhamentoAdicional(rs.getString("acompanhamento_adicional"));
                
                listaLanches.add(obj);
            }}catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaLanches = null;
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
        
        return listaLanches;

    }
    
    public static ArrayList<LancheEspecial> listarPorTipo(String pTipo) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<LancheEspecial> listaLanches = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM lanche WHERE tipo like ?;");
            instrucaoSQL.setString(1, "%" + pTipo + "%");
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                LancheEspecial obj = new LancheEspecial();
                obj.setIdLanche(rs.getInt("id_lanche"));
                obj.setNome(rs.getString("nome"));
                obj.setSabor(rs.getString("sabor"));
                obj.setTipo(rs.getString("tipo"));
                obj.setPrecoProduto(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                obj.setAcompanhamentoAdicional(rs.getString("acompanhamento_adicional"));
                
                listaLanches.add(obj);
            }}catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaLanches = null;
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
        
        return listaLanches;

    }
    
     public static boolean excluir(int pIdProduto){
    
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM lanche WHERE id_lanche = ?");
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
 
    public static boolean atualizar(LancheEspecial obj) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE lanche set nome = ?, sabor = ?, tipo = ?, preco = ?, qtd_estoque= ?, acompanhamento_adicional = ? WHERE id_lanche = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getSabor());
            instrucaoSQL.setString(3, obj.getTipo());
            instrucaoSQL.setDouble(4, obj.getPrecoProduto());
            instrucaoSQL.setInt(5, obj.getQtdEstoque());
            instrucaoSQL.setString(6, obj.getAcompanhamentoAdicional());
            instrucaoSQL.setInt(7, obj.getIdLanche());


            
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
