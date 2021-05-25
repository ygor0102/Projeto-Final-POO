
package Controller;

import DAO.ClienteDAO;
import Model.Cliente;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */

public class ClienteController {
     
    /**
     * Método para salvar o cadastro do cliente.
     * @param pNome String - Nome do cliente
     * @param pNascimento Date - Data de nascimento do cliente
     * @param pCPF String - CPF do cliente
     * @param pSexo String - Sexo do cliente
     * @param pEstado String - Estado do cliente
     * @param pUF String - UF do cliente
     * @param pLogradouro String - Logradouro do cliente
     * @param pNumero int - Número de residencia do cliente
     * @param pComplemento String - Complemento de residência
     * @param pTelefone String - Telefone do cliente
     * @param pCelular String - Celular do cliente
     * @param pEmail String - E-mail do cliente
     * @return <code>boolean</code> - true: Conseguiu salvar o cliente, false: Falha ao salvar, verifique o pacote DAO.
     */
    public static boolean Salvar(String pNome, Date pNascimento, String pCPF, String pSexo, 
                                 String pEstado, String pUF, String pLogradouro, int pNumero,
                                 String pComplemento, String pTelefone, String pCelular, String pEmail){
     
    boolean retorno = false;
    Cliente objCliente = new Cliente();
    
    objCliente.setNome(pNome);
    objCliente.setNascimento(pNascimento);
    objCliente.setCPF(pCPF);
    objCliente.setSexo(pSexo);
    objCliente.setEstado(pEstado);
    objCliente.setUF(pUF);
    objCliente.setLogradouro(pLogradouro);
    objCliente.setNumero(pNumero);
    objCliente.setComplemento(pComplemento);
    objCliente.setTelefone(pTelefone);
    objCliente.setCelular(pCelular);
    objCliente.setEmail(pEmail);

        try {
            ClienteDAO.Salvar(objCliente);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
            return retorno;
        
    }
    
    /**
     * Método para listar os clientes do banco.
     * @return <code>String[]</code> - Lista gerada.
     */
    public static ArrayList<String[]> listar() {
    
        ArrayList<Cliente> listaClientes = ClienteDAO.listar();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Cliente obj : listaClientes) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdCliente())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getNascimento())
                                        ,String.valueOf(obj.getCPF())
                                        ,String.valueOf(obj.getSexo())
                                        ,String.valueOf(obj.getEstado())
                                        ,String.valueOf(obj.getUF())
                                        ,String.valueOf(obj.getLogradouro())
                                        ,String.valueOf(obj.getNumero())
                                        ,String.valueOf(obj.getComplemento())
                                        ,String.valueOf(obj.getTelefone())
                                        ,String.valueOf(obj.getCelular())
                                        ,String.valueOf(obj.getEmail())
                    });
        }
        
        return listaRetorno;
    }
    
   /**
     * Método para listar os clientes do banco a partir do CPF.
     * @return <code>String[]</code> - Vetor gerado a partir da linha encontrada pelo CPF.
     */
   public static String[] consultarPorCPF(String pCPF) {
    
        Cliente obj = ClienteDAO.consultarPorCPF(pCPF);
        
        String[] clienteRetorno  = null;
        
        if(!obj.getCPF().equals("")){
            clienteRetorno = new String[]{String.valueOf(obj.getIdCliente())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getNascimento())
                                        ,String.valueOf(obj.getCPF())
                                        ,String.valueOf(obj.getSexo())
                                        ,String.valueOf(obj.getEstado())
                                        ,String.valueOf(obj.getUF())
                                        ,String.valueOf(obj.getLogradouro())
                                        ,String.valueOf(obj.getNumero())
                                        ,String.valueOf(obj.getComplemento())
                                        ,String.valueOf(obj.getTelefone())
                                        ,String.valueOf(obj.getCelular())
                                        ,String.valueOf(obj.getEmail())       
            };
        }
        
        return clienteRetorno;
    }
   
    /**
     * Método para listar os clientes do banco a partir do nome.
     * @return <code>String []</code> - Lista gerada pela pesquisa de nome.
     */
     public static ArrayList<String[]> listarPorNome(String nome) {
    
        ArrayList<Cliente> listaClientes = ClienteDAO.listarPorNome(nome);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Cliente obj : listaClientes) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdCliente())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getNascimento())
                                        ,String.valueOf(obj.getCPF())
                                        ,String.valueOf(obj.getSexo())
                                        ,String.valueOf(obj.getEstado())
                                        ,String.valueOf(obj.getUF())
                                        ,String.valueOf(obj.getLogradouro())
                                        ,String.valueOf(obj.getNumero())
                                        ,String.valueOf(obj.getComplemento())
                                        ,String.valueOf(obj.getTelefone())
                                        ,String.valueOf(obj.getCelular())
                                        ,String.valueOf(obj.getEmail())
                    });
        }
        
        return listaRetorno;
    }
     
     /**
     * Método para excluir o cadastro do cliente.
     * @param idCliente int - id do cliente
     * @return <code>boolean</code> - true: Conseguiu excluir o cliente, false: Falha ao excluir, verifique o pacote DAO.
     */
     public static boolean excluir(int idCliente){
        
        return ClienteDAO.excluir(idCliente);
        
    }
     /**
     * Método para alterar o cadastro do cliente.
     * @param pIdCliente int - id do cliente
     * @param pNome String - Nome do cliente
     * @param pNascimento Date - Data de nascimento do cliente
     * @param pCPF String - CPF do cliente
     * @param pSexo String - Sexo do cliente
     * @param pEstado String - Estado do cliente
     * @param pUF String - UF do cliente
     * @param pLogradouro String - Logradouro do cliente
     * @param pNumero int - Número de residencia do cliente
     * @param pComplemento String - Complemento de residência
     * @param pTelefone String - Telefone do cliente
     * @param pCelular String - Celular do cliente
     * @param pEmail String - E-mail do cliente
     * @return <code>boolean</code> - true: Conseguiu alterar o cliente, false: Falha ao alterar, verifique o pacote DAO.
     */
      public static boolean atualizar(int pIdCliente, String pNome, Date pNascimento, String pCPF, String pSexo, 
                                 String pEstado, String pUF, String pLogradouro, int pNumero,
                                 String pComplemento, String pTelefone, String pCelular, String pEmail) {
    
        boolean retorno = false;
        //Recebi os parâmetros da view e criei um objeto da classe nota fiscal
   
        Cliente objCliente = new Cliente();

        objCliente.setNome(pNome);
        objCliente.setNascimento(pNascimento);
        objCliente.setCPF(pCPF);
        objCliente.setSexo(pSexo);
        objCliente.setEstado(pEstado);
        objCliente.setUF(pUF);
        objCliente.setLogradouro(pLogradouro);
        objCliente.setNumero(pNumero);
        objCliente.setComplemento(pComplemento);
        objCliente.setTelefone(pTelefone);
        objCliente.setCelular(pCelular);
        objCliente.setEmail(pEmail);
        objCliente.setIdCliente(pIdCliente);


        return  ClienteDAO.atualizar(objCliente);
        
    }
    
    
    
    
    
    
      
}
