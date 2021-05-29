
package Model;

import java.util.Date;

/**
 *
 * @author ygor.oliveira
 */
public class VendaVip extends Venda implements ApplicableDiscount{
    
    private String brindeAdicional;

    public VendaVip(String brindeAdicional, Date dataVenda, double precoTotal, double desconto, int fkIdCliente,
                    String nome, String CPF, String telefone, String celular) {
        
        super(dataVenda, precoTotal, desconto, fkIdCliente, nome, CPF, telefone, celular);        
        this.brindeAdicional = brindeAdicional;
    }

    public String getBrindeAdicional() {
        return brindeAdicional;
    }

    public void setBrindeAdicional(String brindeAdicional) {
        this.brindeAdicional = brindeAdicional;
    }

    @Override
    public double calcularDesconto() {
        
        return getPrecoTotal()-super.getDesconto();
        
    }  
    
}
