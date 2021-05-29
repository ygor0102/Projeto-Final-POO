
package Model;
import java.util.Date;


public class ClienteVip extends Cliente implements ApplicableVip {
    
    private String Vip;
    private int NivelVip;
    
    public ClienteVip(String nome, Date Nascimento, String CPF, String sexo, 
                      String estado, String UF, String logradouro, int numero, 
                      String complemento, String telefone, String celular, 
                      String email, String Vip, int NivelVip) {
        
        super(nome, Nascimento, CPF, sexo, estado, UF, logradouro, numero, complemento, telefone, celular, email);
        this.Vip = Vip;
        this.NivelVip = NivelVip;
    }

    public ClienteVip() {
    }

    public String getVip() {
        return Vip;
    }

    public void setVip(String Vip) {
        this.Vip = Vip;
    }

    public int getNivelVip() {
        return NivelVip;
    }

    public void setNivelVip(int NivelVip) {
        this.NivelVip = NivelVip;
    }
    
    //Vip 01 = 5% de desconto. Cada vip incrementa +5%;
    @Override
    public double getDescontoFixo() {
        return getNivelVip()*0.05; 
    }
    
}