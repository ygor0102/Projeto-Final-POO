
package Controller;

import DAO.ClienteDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.Venda;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */

public class VendaController {
    
    /**
     * Método para salvar a venda.
     * @param pDataVenda Date - Data de venda (hoje)
     * @param pPrecoTotal Double - Valor total dos produtos
     * @param pFkIdCliente int - chave estrangeira do cliente resposável pela compra
     * @return <code>boolean</code> - true: Conseguiu salvar a venda, false: Falha ao salvar, verifique o pacote DAO.
     */
    public static boolean Salvar(Date pDataVenda, double pPrecoTotal, int pFkIdCliente){
     
    boolean retorno = false;
    Venda objVenda = new Venda();
    
    objVenda.setDataVenda(pDataVenda);
    objVenda.setPrecoTotal(pPrecoTotal);
    objVenda.setFkIdCliente(pFkIdCliente);
    
        try {
            VendaDAO.Salvar(objVenda);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
            return retorno;
        
    }
    /**
     * Método para listar as vendas do sistema.
     * @param pDataInicial Date - Data inicial do período desejado
     * @param pDataFinal Double - Data final do período desejado
     * @return <code>String[]</code> - Lista gerada.
     */
    public static ArrayList<String[]> listar(Date pDataInicial, Date pDataFinal) {
    
        ArrayList<Venda> listaVendas = VendaDAO.listar(pDataInicial, pDataFinal);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Venda obj : listaVendas) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdVenda())
                                        ,String.valueOf(obj.getDataVenda())
                                        ,String.valueOf(obj.getPrecoTotal())
                                        
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