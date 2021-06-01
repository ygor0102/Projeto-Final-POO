/**
 * @author Ygor Oliveira - Yasmim Candelária - Juan Gonçalves Dias - Filipe Vital da Silva
 * @since 17/05/2021
 */

package DAO;

import Model.Cliente;
import Model.ClienteVip;
import Utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ClienteDAO {
    
    
    public static boolean Salvar(ClienteVip obj){
       
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
              conexao = GerenciadorConexao.abrirConexao();

              instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome, nascimento, CPF, sexo, estado, UF, logradouro, numero_residencia, complemento, telefone, celular, email, vip, nivel_vip) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                      , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setDate(2, new java.sql.Date(obj.getNascimento().getTime()));
            instrucaoSQL.setString(3, obj.getCPF());
            instrucaoSQL.setString(4, obj.getSexo());
            instrucaoSQL.setString(5, obj.getEstado());
            instrucaoSQL.setString(6, obj.getUF());
            instrucaoSQL.setString(7, obj.getLogradouro());
            instrucaoSQL.setInt(8, obj.getNumero());
            instrucaoSQL.setString(9, obj.getComplemento());
            instrucaoSQL.setString(10, obj.getTelefone());
            instrucaoSQL.setString(11, obj.getCelular());
            instrucaoSQL.setString(12, obj.getEmail());
            instrucaoSQL.setString(13, obj.getVip());
            instrucaoSQL.setInt(14, obj.getNivelVip());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                        obj.setIdCliente(generatedKeys.getInt(1));
                }else {
                        throw new SQLException("Falha ao obter o ID do cliente!");
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
  
     public static ArrayList<ClienteVip> listar() {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<ClienteVip> listaClientes = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente;");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                ClienteVip obj = new ClienteVip();
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setNascimento(rs.getDate("nascimento"));
                obj.setCPF(rs.getString("CPF"));
                obj.setSexo(rs.getString("sexo"));
                obj.setEstado(rs.getString("estado"));
                obj.setUF(rs.getString("UF"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero_residencia"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setEmail(rs.getString("email"));
                obj.setVip(rs.getString("vip"));
                obj.setNivelVip(rs.getInt("nivel_vip"));
                
                listaClientes.add(obj);
            }
            
        }catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaClientes = null;
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
        
        return listaClientes;

    }
     public static Cliente consultarPorCPF(String pCPF) {
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Cliente retorno = new Cliente();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE CPF = ?");  //Caso queira retornar o ID
            instrucaoSQL.setString(1, pCPF);
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                ClienteVip obj = new ClienteVip();
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setNascimento(rs.getDate("nascimento"));
                obj.setCPF(rs.getString("CPF"));
                obj.setSexo(rs.getString("sexo"));
                obj.setEstado(rs.getString("estado"));
                obj.setUF(rs.getString("UF"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero_residencia"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setEmail(rs.getString("email"));
                obj.setVip(rs.getString("vip"));
                obj.setNivelVip(rs.getInt("nivel_vip"));
                
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
     public static ArrayList<ClienteVip> listarPorNome(String pNome) {

        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<ClienteVip> listaClientes = new ArrayList<>();
        ResultSet rs = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE nome like ?;");
            instrucaoSQL.setString(1, "%" + pNome + "%");
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next())
            {
                ClienteVip obj = new ClienteVip();
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setNascimento(rs.getDate("nascimento"));
                obj.setCPF(rs.getString("CPF"));
                obj.setSexo(rs.getString("sexo"));
                obj.setEstado(rs.getString("estado"));
                obj.setUF(rs.getString("UF"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getInt("numero_residencia"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setEmail(rs.getString("email"));
                obj.setVip(rs.getString("vip"));
                obj.setNivelVip(rs.getInt("nivel_vip"));
                
                listaClientes.add(obj);
            }}catch (SQLException | ClassNotFoundException ex ) {
            System.out.println(ex.getMessage());
            listaClientes = null;
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
        
        return listaClientes;

    }
     public static boolean excluir(int pIdCliente){
    
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, pIdCliente);
            
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
      public static boolean atualizar(ClienteVip obj) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE cliente set nome = ?, nascimento = ?, CPF = ?, sexo = ?, estado = ?, UF = ?, logradouro = ?, numero_residencia = ?, complemento = ?, telefone = ?, celular = ?, email = ?, vip = ?, nivel_vip = ? WHERE id_cliente = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setDate(2, new java.sql.Date(obj.getNascimento().getTime()));
            instrucaoSQL.setString(3, obj.getCPF());
            instrucaoSQL.setString(4, obj.getSexo());
            instrucaoSQL.setString(5, obj.getEstado());
            instrucaoSQL.setString(6, obj.getUF());
            instrucaoSQL.setString(7, obj.getLogradouro());
            instrucaoSQL.setInt(8, obj.getNumero());
            instrucaoSQL.setString(9, obj.getComplemento());
            instrucaoSQL.setString(10, obj.getTelefone());
            instrucaoSQL.setString(11, obj.getCelular());
            instrucaoSQL.setString(12, obj.getEmail());
            instrucaoSQL.setString(13, obj.getVip());
            instrucaoSQL.setInt(14, obj.getNivelVip());
            instrucaoSQL.setInt(15, obj.getIdCliente());

            
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
     
     
     
     
