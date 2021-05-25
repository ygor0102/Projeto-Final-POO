/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ygor.oliveira
 */
public class LancheEspecial extends Lanche{
    String brinde;

    public LancheEspecial(String brinde, String nomeProduto, String modeloProduto, 
                          String tipoProduto, double precoUnitario,  int qtdEstoque) {
        
        super(nomeProduto, modeloProduto, tipoProduto, precoUnitario, qtdEstoque);
        
        this.brinde = brinde;
    }

    public String getBrinde() {
        return brinde;
    }

    public void setBrinde(String brinde) {
        this.brinde = brinde;
    }
    
    
    
    
    
}
