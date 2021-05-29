
package Controller;
import DAO.LancheDAO;
import Model.Lanche;
import Model.LancheEspecial;
import java.util.ArrayList;



public class LancheController {

    public static boolean Salvar(String pNome, String pModelo, String pTipo, double pPreco, int pQtdEstoque, String pAcompanhamento){
     
    boolean retorno = false;
    LancheEspecial objLanche = new LancheEspecial();
    
    //Recebi os parâmetros da View e criei um objeto da classe Lanche especial;
    objLanche.setNome(pNome);
    objLanche.setSabor(pModelo);
    objLanche.setTipo(pTipo);
    objLanche.setPrecoProduto(pPreco);
    objLanche.setQtdEstoque(pQtdEstoque);
    objLanche.setAcompanhamentoAdicional(pAcompanhamento);
    
    
    //Mandar gravar no banco de dados com o objeto todo;
    try {
            LancheDAO.Salvar(objLanche);
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
     
        return retorno;
    }
 
    public static ArrayList<String[]> listar() {
    
        ArrayList<LancheEspecial> listaLanches = LancheDAO.listar();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (LancheEspecial obj : listaLanches) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdLanche())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getSabor())
                                        ,String.valueOf(obj.getTipo())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                                        ,String.valueOf(obj.getAcompanhamentoAdicional())
                    });
        }
        
        return listaRetorno;
    }
   
    public static ArrayList<String[]> listarPorNome(String nome) {
    
        ArrayList<LancheEspecial> listaLanches = LancheDAO.listarPorNome(nome);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (LancheEspecial obj : listaLanches) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdLanche())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getSabor())
                                        ,String.valueOf(obj.getTipo())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                                        ,String.valueOf(obj.getAcompanhamentoAdicional())
                    });
        }
        
        return listaRetorno;
    }
    
  
    public static ArrayList<String[]> listarPorTipo(String tipo) {
    
        ArrayList<LancheEspecial> listaLanches = LancheDAO.listarPorTipo(tipo);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        
        for (LancheEspecial obj : listaLanches) {
            listaRetorno.add(new String[]{String.valueOf(obj.getIdLanche())
                                        ,String.valueOf(obj.getNome())
                                        ,String.valueOf(obj.getSabor())
                                        ,String.valueOf(obj.getTipo())
                                        ,String.valueOf(obj.getPrecoProduto())
                                        ,String.valueOf(obj.getQtdEstoque())
                                        ,String.valueOf(obj.getAcompanhamentoAdicional())
                    });
        }
        
        return listaRetorno;
    }
    
  
     public static boolean excluir(int idProduto){
        
        return LancheDAO.excluir(idProduto);
        
    }

     public static boolean atualizar(int pIdProduto, String pNome, String pModelo, String pTipo, double pPreco, int pQtdEstoque, String pAcompanhamentoAdicional) {
    
        boolean retorno = false;
        LancheEspecial objLanche = new LancheEspecial();
        
        objLanche.setNome(pNome);
        objLanche.setSabor(pModelo);
        objLanche.setTipo(pTipo);
        objLanche.setPrecoProduto(pPreco);
        objLanche.setQtdEstoque(pQtdEstoque);
        objLanche.setIdLanche(pIdProduto);
        objLanche.setAcompanhamentoAdicional(pAcompanhamentoAdicional);


        return  LancheDAO.atualizar(objLanche);
        
    }
  
}
    
    
