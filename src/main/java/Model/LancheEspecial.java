
package Model;

public class LancheEspecial extends Lanche{
    String acompanhamentoAdicional;

    public LancheEspecial(String nome, String sabor, String tipo, 
                            double precoUnitario, int qtdEstoque, String acompanhamentoAdicional) {
        super(nome, sabor, tipo, precoUnitario, qtdEstoque);
        this.acompanhamentoAdicional = acompanhamentoAdicional;
        
    }
    public LancheEspecial(){
    
    }

  
    public String getAcompanhamentoAdicional() {
        return acompanhamentoAdicional;
    }

    public void setAcompanhamentoAdicional(String acompanhamentoAdicional) {
        this.acompanhamentoAdicional = acompanhamentoAdicional;
    }
  
    
}
