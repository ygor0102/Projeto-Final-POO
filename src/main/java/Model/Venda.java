/**
 * @author Ygor Oliveira - Yasmim Candelária - Juan Gonçalves Dias - Filipe Vital da Silva
 * @since 17/05/2021
 */

package Model;
import java.util.Date;

public class Venda extends Cliente implements ApplicableDiscount{
    
     private int idVenda;
     private Date dataVenda;
     private double precoTotal;
     private double desconto;
     
     
     public Venda(Date dataVenda, double precoTotal, double desconto, int IdCliente,
                    String nome, String CPF, String telefone, String celular){
         super(IdCliente, nome, CPF, telefone,celular);
     
     }
    public Venda(){
     
    }
  
 
    public int getIdVenda() {
        return idVenda;
    }
    
  
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    

    public Date getDataVenda() {
        return dataVenda;
    }
    
  
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
    public double getPrecoTotal() {
        return precoTotal;
    }
    
    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double calcularDesconto(double precoTotal, double desconto) {
            return precoTotal - (desconto*precoTotal);
    }
 

}

