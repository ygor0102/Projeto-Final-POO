
package DAO;

import Model.ItemVenda;
import Model.Lanche;
import Utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ItemVendaDAO {

   public static boolean Salvar(ItemVenda obj){
       
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
              conexao = GerenciadorConexao.abrirConexao();

              instrucaoSQL = conexao.prepareStatement("INSERT INTO item_venda (FK_id_venda, FK_id_lanche) VALUES (?,?)"
                      , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, obj.getFkIdVenda());
            instrucaoSQL.setInt(2, obj.getFkIdLanche());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                        obj.setIdItem(generatedKeys.getInt(1));
                        
                }else {
                        throw new SQLException("Falha ao obter o ID do item!");
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
   
   public static ArrayList<ItemVenda> listarItens(int pIdVenda) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<ItemVenda> listaItens = new ArrayList<>();
        ResultSet rs = null;
            
            try {   
            conexao = GerenciadorConexao.abrirConexao();            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM item_venda INNER JOIN lanche ON item_venda.FK_id_lanche = lanche.id_lanche WHERE FK_id_venda = ?;"); 
            instrucaoSQL.setInt(1, pIdVenda);
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                ItemVenda obj = new ItemVenda();
                obj.setIdItem(rs.getInt("id_item"));
                obj.setNome(rs.getString("nome"));
                obj.setSabor(rs.getString("sabor"));
                obj.setTipo(rs.getString("tipo"));
                obj.setPrecoUnitario(rs.getDouble("preco"));
                
                listaItens.add(obj);
       
            }}catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaItens = null;
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
        
        return listaItens;

    }
   
   
    
}
