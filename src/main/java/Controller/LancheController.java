
package Controller;
import DAO.LancheDAO;
import Model.Lanche;
import java.util.ArrayList;

/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */


public class LancheController {
    
    /**
     * Método para salvar o cadastro do produto.
     * @param pNome String - Nome do produto
     * @param pModelo String - Modelo do produto
     * @param pTipo String - Tipo do produto
     * @param pPreco String - Preço do produto
     * @param pQtdEstoque int - Qtd para estoque do produto
     * @return <code>boolean</code> - true: Conseguir salvar o produto, false: Falha ao salvar, verifique o pacote DAO.
     */
    public static boolean Salvar(String pNome, String pModelo, String pTipo, double pPreco, int pQtdEstoque){
     
    boolean retorno = false;
    Lanche objProduto = new Lanche();
    
    //Recebi os parâmetros da View e criei um objeto da classe Cliente
    objProduto.setNomeProduto(pNome);
    objProduto.setModeloProduto(pModelo);
    objProduto.setTipoProduto(pTipo);
    objProduto.setPrecoProduto(pPreco);
    objProduto.setQtdEstoque(pQtdEstoque);
    
    
    //Mandar gravar no banco de dados com o objeto todo;
    try {
            LancheDAO.Salvar(objProduto);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
        return retorno;
    }
    /**
     * Método para listar os produtos do banco.
     * @return <code>String[]</code> - Lista gerada.
     */
    public static ArrayList<String[]> listar() {
    
        ArrayList<Lanche> listaProdutos = LancheDAO.listar();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Lanche obj : listaProdutos) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdProduto())
                                        ,String.valueOf(obj.getNomeProduto())
                                        ,String.valueOf(obj.getModeloProduto())
                                        ,String.valueOf(obj.getTipoProduto())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                    });
        }
        
        return listaRetorno;
    }
    /**
     * Método para listar os produtos do banco a partir do nome.
     * @return <code>String[]</code> - Lista gerada pela pesquisa do nome.
     */
    public static ArrayList<String[]> listarPorNome(String nome) {
    
        ArrayList<Lanche> listaProdutos = LancheDAO.listarPorNome(nome);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Lanche obj : listaProdutos) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdProduto())
                                        ,String.valueOf(obj.getNomeProduto())
                                        ,String.valueOf(obj.getModeloProduto())
                                        ,String.valueOf(obj.getTipoProduto())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                    });
        }
        
        return listaRetorno;
    }
    
    /**
     * Método para listar os produtos do banco a partir do tipo.
     * @return <code>String[]</code> - Lista gerada pela pesquisa do tipo produto.
     */
    public static ArrayList<String[]> listarPorTipo(String tipo) {
    
        ArrayList<Lanche> listaProdutos = LancheDAO.listarPorTipo(tipo);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Lanche obj : listaProdutos) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdProduto())
                                        ,String.valueOf(obj.getNomeProduto())
                                        ,String.valueOf(obj.getModeloProduto())
                                        ,String.valueOf(obj.getTipoProduto())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                    });
        }
        
        return listaRetorno;
    }
    
     /**
     * Método para excluir o cadastro do produto.
     * @param idProduto int - id do produto.
     * @return <code>boolean</code> - true: Conseguiu excluir o produto, false: Falha ao excluir, verifique o pacote DAO.
     */
     public static boolean excluir(int idProduto){
        
        return LancheDAO.excluir(idProduto);
        
    }
     /**
     * Método para alterar o cadastro do produto.
     * @param pIdProduto int - id do produto
     * @param pNome String - Nome do produto
     * @param pModelo String - Modelo do produto
     * @param pTipo String - Tipo do produto
     * @param pPreco String - Preço do produto
     * @param pQtdEstoque int - Qtd para estoque do produto
     * @return <code>boolean</code> - true: Conseguiu alterar o produto, false: Falha ao alterar, verifique o pacote DAO.
     */
     public static boolean atualizar(int pIdProduto, String pNome, String pModelo, String pTipo, double pPreco, int pQtdEstoque) {
    
        boolean retorno = false;
        Lanche objProduto = new Lanche();
        
        objProduto.setNomeProduto(pNome);
        objProduto.setModeloProduto(pModelo);
        objProduto.setTipoProduto(pTipo);
        objProduto.setPrecoProduto(pPreco);
        objProduto.setQtdEstoque(pQtdEstoque);
        objProduto.setIdProduto(pIdProduto);


        return  LancheDAO.atualizar(objProduto);
        
    }
  
}
    
    
