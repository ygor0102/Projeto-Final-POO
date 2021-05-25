
package Controller;

import DAO.ItemVendaDAO;
import Model.ItemVenda;
import java.util.ArrayList;

/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */

public class ItemVendaController {
    
    /**
     * Método para salvar os itens da venda realizada
     * @param pFkIdVenda int - Chave estrangeira da venda
     * @param pFkIdProduto int - Chave estrangeira dos produtos vendidos.
     * @return <code>boolean</code> - true: Conseguiu salvar os itens da venda, false: Falha ao salvar, verifique o pacote DAO.
     */
    public static boolean Salvar(int pFkIdVenda, int pFkIdProduto){
     
    boolean retorno = false;
    ItemVenda objItemVenda = new ItemVenda();
    
    //Recebi os parâmetros da View e criei um objeto da classe Cliente
    objItemVenda.setFkIdVenda(pFkIdVenda);
    objItemVenda.setFkIdProduto(pFkIdProduto);
    
    //Mandar gravar no banco de dados com o objeto todo;
    try {
            ItemVendaDAO.Salvar(objItemVenda);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
        return retorno;
    }
    
    
    /**
     * Método para listar os itens de venda do sistema.
     * @param pIdVenda Date - Id de venda procurada
     * @return <code>String[]</code> - Lista gerada com os itens.
     */
    public static ArrayList<String[]> listarItens(int pIdVenda) {
    
        ArrayList<ItemVenda> listaVendas = ItemVendaDAO.listarItens(pIdVenda);
        ArrayList<String[]>  listaRetorno = new ArrayList<>();
        
        for (ItemVenda obj : listaVendas) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdItem())
                                         ,String.valueOf(obj.getNome())
                                         ,String.valueOf(obj.getModelo())
                                         ,String.valueOf(obj.getTipo())
                                         ,String.valueOf(obj.getPrecoUnitario())  
                    });
        }
        
        return listaRetorno;
    }
    
}
