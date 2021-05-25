
package DAO;

import Model.Cliente;
import Model.Venda;
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

    /**
     * Método para salvar as vendas realizadas no banco.
     * @param obj Venda - Objeto da classe Venda
     * @return <code>boolean</code> - true: Conseguiu salvar a venda, false: Falha ao salvar, verifique a classe "GerenciadorConexão".
     */
    public static boolean Salvar(Venda obj){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        
        try {
              conexao = GerenciadorConexao.abrirConexao();

              instrucaoSQL = conexao.prepareStatement("INSERT INTO venda (data_venda, preco_total, fk_id_cliente) VALUES (?,?,?)"
                      , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
            instrucaoSQL.setDouble(2, obj.getPrecoTotal());
            instrucaoSQL.setInt(3, obj.getFkIdCliente());
            
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
    
    /**
     * Método para listar as vendas a partir de um período (relatório sintético).
     * @param pDataInicial Date - Data inicial do período desejado.
     * @param pDataFinal Date - Data final do período desejado.
     * @return <code>boolean</code> - true: Conseguiu listar as vendas, false: Falha ao listar, verifique a classe "GerenciadorConexao".
     */
    public static ArrayList<Venda> listar(Date pDataInicial, Date pDataFinal) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Venda> listaVendas = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from venda where data_venda between ? and ?;");
            instrucaoSQL.setDate(1, new java.sql.Date(pDataInicial.getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(pDataFinal.getTime()));
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                Venda obj = new Venda();
                obj.setIdVenda(rs.getInt("id_venda"));
                obj.setDataVenda(rs.getDate("data_venda"));
                obj.setPrecoTotal(rs.getDouble("preco_total"));
               
                
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
        Venda retorno = new Venda();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda INNER JOIN cliente ON venda.Fk_id_cliente = cliente.id_cliente WHERE id_venda = ?;"); 
            instrucaoSQL.setInt(1, pIdVenda);
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                Venda obj = new Venda();
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
