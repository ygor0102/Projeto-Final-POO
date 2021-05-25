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
public class ClienteVip extends Cliente implements ApplicableVip {
    
    private String Vip;
    private int NivelVip;
    
    public ClienteVip(String Vip, int NivelVip, String nome, Date Nascimento, String CPF, String sexo, String estado, String UF, String logradouro, int numero, String complemento, String telefone, String celular, String email) {
        super(nome, Nascimento, CPF, sexo, estado, UF, logradouro, numero, complemento, telefone, celular, email);
        this.Vip = Vip;
        this.NivelVip = NivelVip;
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
    
    //Vip 01 = % de desconto. Cada vip incrementa +5%;
    @Override
    public double getDescontoFixo() {
        return getNivelVip()*0.05; 
    }
    
}
