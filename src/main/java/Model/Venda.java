package Model;
import java.util.Date;

public class Venda implements ApplicableDiscount{
    
     private int idVenda;
     private Date dataVenda;
     private double precoTotal;
     private double desconto;
     private int fkIdCliente;
     private String nome;
     private String CPF;
     private String telefone;
     private String celular;
     
     public Venda(Date dataVenda, double precoTotal, double desconto, int fkIdCliente,
                    String nome, String CPF, String telefone, String celular){
     
     
     }
     

 public Venda(){
     
    }
  
    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }
    
   
    public String getCPF() {
        return CPF;
    }
    
   
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public String getTelefone() {
        return telefone;
    }

  
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
  
    public String getCelular() {
        return celular;
    }
    
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    public int getFkIdCliente() {
        return fkIdCliente;
    }
  
    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
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
    
    /**
     * Método modificador do campo preço de venda.
     * @param precoTotal variável do tipo double
     */
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

