
package Model;

public class ItemVenda {
    private  int idItem;
    private int FkIdVenda;
    private int FkIdLanche;
    private String nome;
    private String sabor;
    private String tipo;
    private double precoUnitario;
    
     public ItemVenda(){
     
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
   
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
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
