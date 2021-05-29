
package Controller;

import DAO.ClienteDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.Venda;
import Model.VendaVip;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */

public class VendaController {
    
    public static boolean Salvar(Date pDataVenda, double pPrecoTotal, double pDescontoVenda, String pBrindeVip, int pFkIdCliente){
     
    boolean retorno = false;
    VendaVip objVenda = new VendaVip();
    
    objVenda.setDataVenda(pDataVenda);
    objVenda.setPrecoTotal(pPrecoTotal);
    objVenda.setDesconto(pDescontoVenda);
    objVenda.setBrindeAdicional(pBrindeVip);
    objVenda.setFkIdCliente(pFkIdCliente);
    
        try {
            VendaDAO.Salvar(objVenda);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
            return retorno;
        
    }
  
    public static ArrayList<String[]> listar(Date pDataInicial, Date pDataFinal) {
    
        ArrayList<VendaVip> listaVendas = VendaDAO.listar(pDataInicial, pDataFinal);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (VendaVip obj : listaVendas) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdVenda())
                                        ,String.valueOf(obj.getDataVenda())
                                        ,String.valueOf(obj.getPrecoTotal())
                                        ,String.valueOf(obj.getDesconto())
                                        ,String.valueOf(obj.getBrindeAdicional())
                                        
                });
        }
        
        return listaRetorno;
    }
    
    /**
     * Método para listar as vendas a partir do id de venda.
     * @param idVenda int - Id da venda procurada
     * @return <code>String[]</code> - Linha gerada a partir deste id.
     */
    public static String[] consultarPorID(int idVenda) {
    
        Venda obj = VendaDAO.consultarPorID(idVenda);
        
        String[] clienteRetorno  = null;
        
        if(obj.getIdVenda() > 0){
            clienteRetorno = new String[]{String.valueOf(obj.getIdVenda())
                                        ,String.valueOf(obj.getFkIdCliente())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getCPF())
                                        ,String.valueOf(obj.getTelefone())
                                        ,String.valueOf(obj.getCelular())
            };
        }
        
        return clienteRetorno;
    }
}