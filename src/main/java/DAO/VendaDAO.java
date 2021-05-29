
package DAO;

import Model.Cliente;
import Model.Venda;
import Model.VendaVip;
import Utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */


public class VendaDAO {

    public static int idVenda;

    public static boolean Salvar(VendaVip obj){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        
        try {
              conexao = GerenciadorConexao.abrirConexao();

              instrucaoSQL = conexao.prepareStatement("INSERT INTO venda (data_venda, preco_total, desconto, brinde_adicional, fk_id_cliente) VALUES (?,?,?,?,?)"
                      , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
            instrucaoSQL.setDouble(2, obj.getPrecoTotal());
            instrucaoSQL.setDouble(3, obj.getDesconto());
            instrucaoSQL.setString(4, obj.getBrindeAdicional());
            instrucaoSQL.setInt(5, obj.getFkIdCliente());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                       obj.setIdVenda(generatedKeys.getInt(1));
                       idVenda = obj.getIdVenda();
                        
                }else {
                        throw new SQLException("Falha ao obter o ID da venda!");
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
    
    public static ArrayList<VendaVip> listar(Date pDataInicial, Date pDataFinal) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<VendaVip> listaVendas = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from venda where data_venda between ? and ?;");
            instrucaoSQL.setDate(1, new java.sql.Date(pDataInicial.getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(pDataFinal.getTime()));
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                VendaVip obj = new VendaVip();
                obj.setIdVenda(rs.getInt("id_venda"));
                obj.setDataVenda(rs.getDate("data_venda"));
                obj.setPrecoTotal(rs.getDouble("preco_total"));
                obj.setDesconto(rs.getDouble("desconto"));
                obj.setBrindeAdicional(rs.getString("brinde_adicional"));
               
                
                listaVendas.add(obj);
            }}catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaVendas = null;
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
        
        return listaVendas;

    }
    
    /**
     * Método para listar as informações do responsável pela compra (relatório analítico).
     * @param pIdVenda int - ID da venda.
     * @return <code>obj</code> retorno - retorna um objeto com os dados do select.
     */
    public static Venda consultarPorID(int pIdVenda) {
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        VendaVip retorno = new VendaVip();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda INNER JOIN cliente ON venda.Fk_id_cliente = cliente.id_cliente WHERE id_venda = ?;"); 
            instrucaoSQL.setInt(1, pIdVenda);
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                VendaVip obj = new VendaVip();
                obj.setIdVenda(rs.getInt("id_venda"));
                obj.setFkIdCliente(rs.getInt("fk_id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("CPF"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                
                retorno = obj;
            }
            
        }catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            retorno = null;
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
