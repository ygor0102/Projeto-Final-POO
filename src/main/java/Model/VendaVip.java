/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ygor.oliveira
 */
public class VendaVip extends Venda implements ApplicableDiscount{
    
    private double desconto;

    public VendaVip(double desconto, Date dataVenda, double precoTotal, int fkIdCliente,
                    String nome, String CPF, String telefone, String celular) {
        
        super(dataVenda, precoTotal, fkIdCliente, nome, CPF, telefone, celular);        
        this.desconto = desconto;
    }
    
    
    

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    

    @Override
    public double calcularDesconto() {
        
        return getDesconto()*getPrecoTotal();
        
    }  
    
}
