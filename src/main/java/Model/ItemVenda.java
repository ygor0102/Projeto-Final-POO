/**
 * @author Ygor Oliveira - Yasmim Candelária - Juan Gonçalves Dias - Filipe Vital da Silva
 * @since 17/05/2021
 */


package Model;

public class ItemVenda extends Lanche {
    private int idItem;
    private int FkIdVenda;
    private int FkIdLanche;
    
    public ItemVenda(int FKIdVenda, int FKIdLanche, String nome, String sabor, String tipo, double precoUnitario, int qtdEstoque){
        
        super(nome, sabor, tipo, precoUnitario, qtdEstoque);
     
    }
    
     public ItemVenda(){
     
    }
    
    public int getFkIdLanche() {
        return FkIdLanche;
    }

    public void setFkIdLanche(int FkIdLanche) {
        this.FkIdLanche = FkIdLanche;
    }

    
    public int getIdItem() {
        return idItem;
    }
  
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
   
    public int getFkIdVenda() {
        return FkIdVenda;
    }
    
    public void setFkIdVenda(int FkIdVenda) {
        this.FkIdVenda = FkIdVenda;
    }
  
    
}
