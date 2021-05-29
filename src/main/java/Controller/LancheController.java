
package Controller;
import DAO.LancheDAO;
import Model.Lanche;
import java.util.ArrayList;



public class LancheController {

    public static boolean Salvar(String pNome, String pModelo, String pTipo, double pPreco, int pQtdEstoque){
     
    boolean retorno = false;
    Lanche objProduto = new Lanche();
    
    //Recebi os parâmetros da View e criei um objeto da classe Cliente
    objProduto.setNome(pNome);
    objProduto.setSabor(pModelo);
    objProduto.setTipo(pTipo);
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
 
    public static ArrayList<String[]> listar() {
    
        ArrayList<Lanche> listaProdutos = LancheDAO.listar();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Lanche obj : listaProdutos) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdLanche())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getSabor())
                                        ,String.valueOf(obj.getTipo())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                    });
        }
        
        return listaRetorno;
    }
   
    public static ArrayList<String[]> listarPorNome(String nome) {
    
        ArrayList<Lanche> listaProdutos = LancheDAO.listarPorNome(nome);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Lanche obj : listaProdutos) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdLanche())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getSabor())
                                        ,String.valueOf(obj.getTipo())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                    });
        }
        
        return listaRetorno;
    }
    
  
    public static ArrayList<String[]> listarPorTipo(String tipo) {
    
        ArrayList<Lanche> listaProdutos = LancheDAO.listarPorTipo(tipo);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (Lanche obj : listaProdutos) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdLanche())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getSabor())
                                        ,String.valueOf(obj.getTipo())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                    });
        }
        
        return listaRetorno;
    }
    
  
     public static boolean excluir(int idProduto){
        
        return LancheDAO.excluir(idProduto);
        
    }

     public static boolean atualizar(int pIdProduto, String pNome, String pModelo, String pTipo, double pPreco, int pQtdEstoque) {
    
        boolean retorno = false;
        Lanche objProduto = new Lanche();
        
        objProduto.setNome(pNome);
        objProduto.setSabor(pModelo);
        objProduto.setTipo(pTipo);
        objProduto.setPrecoProduto(pPreco);
        objProduto.setQtdEstoque(pQtdEstoque);
        objProduto.setIdLanche(pIdProduto);


        return  LancheDAO.atualizar(objProduto);
        
    }
  
}
    
    
