
package Model;

import java.util.Date;
import javax.swing.JOptionPane;

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
    
    public VendaVip(){
    
    }

    public String getBrindeAdicional() {
        return brindeAdicional;
    }

    public void setBrindeAdicional(String brindeAdicional) {
        this.brindeAdicional = brindeAdicional;
    }

    @Override
    public double calcularDesconto(double precoTotal, double desconto) {
        
        return precoTotal - (desconto*precoTotal);
        
    }
    
    public String escolhaBrinde(){
    
           int validaBrinde = 0;
           String brindeVip = "";
            
            do{
                
                try {
                    validaBrinde = Integer.parseInt(JOptionPane.showInputDialog(null,"O cliente é Vip, acrescente um brinde na compra: "
                       + "\n\n1 - Pedaço de bolo"
                       + "\n2 - Mini pastel"
                       + "\n3 - Mini coxinha"
                       + "\n4 - Mini pizza"
                       + "\n5 - Coca-cola 150ml"
                       + "\n6 - Suco natural 150ml"));
              
              if(validaBrinde!=1 && validaBrinde!=2 && validaBrinde!=3 && 
                    validaBrinde!=4 && validaBrinde!=5 && validaBrinde!=6){
                  JOptionPane.showMessageDialog(null,"Opção inválida!");
              
              }
                } catch (Exception e) {
                   JOptionPane.showMessageDialog(null,"Opção inválida!");

                }
                
            
            }while(validaBrinde!=1 && validaBrinde!=2 && validaBrinde!=3 && 
                    validaBrinde!=4 && validaBrinde!=5 && validaBrinde!=6);
            
            if(validaBrinde ==1){
                brindeVip="Pedaço de bolo";
            }
            if(validaBrinde ==2){
                brindeVip="Mini pastel";
            }
            if(validaBrinde ==3){
                brindeVip="Mini coxinha";
            }
            if(validaBrinde ==4){
                brindeVip="Mini pizza";
            }
            if(validaBrinde ==5){
                brindeVip="Coca-cola 150ml";
            }
            if(validaBrinde ==6){
                brindeVip="Suco natural 150ml";
            }
            
            return brindeVip;
    
        
    }
    
}
