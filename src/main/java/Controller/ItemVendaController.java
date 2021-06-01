/**
 * @author Ygor Oliveira - Yasmim Candelária - Juan Gonçalves Dias - Filipe Vital da Silva
 * @since 17/05/2021
 */
package Controller;

import DAO.ItemVendaDAO;
import Model.ItemVenda;
import java.util.ArrayList;


public class ItemVendaController {
  
    public static boolean Salvar(int pFkIdVenda, int pFkIdLanche){
     
    boolean retorno = false;
    ItemVenda objItemVenda = new ItemVenda();
    
    objItemVenda.setFkIdVenda(pFkIdVenda);
    objItemVenda.setFkIdLanche(pFkIdLanche);
    
    try {
            ItemVendaDAO.Salvar(objItemVenda);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
        return retorno;
    }
    
   
    public static ArrayList<String[]> listarItens(int pIdVenda) {
    
        ArrayList<ItemVenda> listaVendas = ItemVendaDAO.listarItens(pIdVenda);
        ArrayList<String[]>  listaRetorno = new ArrayList<>();
        
        for (ItemVenda obj : listaVendas) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdItem())
                                         ,String.valueOf(obj.getNome())
                                         ,String.valueOf(obj.getSabor())
                                         ,String.valueOf(obj.getTipo())
                                         ,String.valueOf(obj.getPrecoUnitario())  
                    });
        }
        
        return listaRetorno;
    }
    
}
