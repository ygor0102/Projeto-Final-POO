
package Controller;

import DAO.ClienteDAO;
import Model.Cliente;
import Model.ClienteVip;
import java.util.ArrayList;
import java.util.Date;


public class ClienteController {
     
 
    public static boolean Salvar(String pNome, Date pNascimento, String pCPF, String pSexo, 
                                 String pEstado, String pUF, String pLogradouro, int pNumero,
                                 String pComplemento, String pTelefone, String pCelular, String pEmail, String pVip, int pNivelVip){
     
    boolean retorno = false;
    ClienteVip objCliente = new ClienteVip();
    
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
    objCliente.setVip(pVip);
    objCliente.setNivelVip(pNivelVip);

        try {
            ClienteDAO.Salvar(objCliente);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
            return retorno;
        
    }
 
    public static ArrayList<String[]> listar() {
    
        ArrayList<ClienteVip> listaClientes = ClienteDAO.listar();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (ClienteVip obj : listaClientes) {
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
                                        ,String.valueOf(obj.getVip())
                                        ,String.valueOf(obj.getNivelVip())
                    });
        }
        
        return listaRetorno;
    }
    
   public static String[] consultarPorCPF(String pCPF) {
    
        ClienteVip obj = (ClienteVip) ClienteDAO.consultarPorCPF(pCPF);
        
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
                                        ,String.valueOf(obj.getVip())
                                        ,String.valueOf(obj.getNivelVip())
            };
        }
        
        return clienteRetorno;
    }
   
     public static ArrayList<String[]> listarPorNome(String nome) {
    
        ArrayList<ClienteVip> listaClientes = ClienteDAO.listarPorNome(nome);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (ClienteVip obj : listaClientes) {
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
                                        ,String.valueOf(obj.getVip())
                                        ,String.valueOf(obj.getNivelVip())
                    });
        }
        
        return listaRetorno;
    }
     
     public static boolean excluir(int idCliente){
        
        return ClienteDAO.excluir(idCliente);
        
    }

      public static boolean atualizar(int pIdCliente, String pNome, Date pNascimento, String pCPF, String pSexo, 
                                 String pEstado, String pUF, String pLogradouro, int pNumero,
                                 String pComplemento, String pTelefone, String pCelular, String pEmail, 
                                 String pVip, int pNivelVip) {
    
        boolean retorno = false;
        //Recebi os parâmetros da view e criei um objeto da classe nota fiscal
   
        ClienteVip objCliente = new ClienteVip();

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
        objCliente.setVip(pVip);
        objCliente.setNivelVip(pNivelVip);
        


        return  ClienteDAO.atualizar(objCliente);
        
    }
      
}
