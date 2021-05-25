package Model;

import java.util.Date;
     
/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */ 

public class Venda {
    
     private int idVenda;
     private Date dataVenda;
     private double precoTotal;
     private int fkIdCliente;
     private String nome;
     private String CPF;
     private String telefone;
     private String celular;
     
     public Venda(Date dataVenda, double precoTotal, int fkIdCliente,
                    String nome, String CPF, String telefone, String celular){
     
     
     }

 public Venda(){
     
    }
    /**
     * Método acessor do nome do cliente.
     * @return String nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Método modificador do campo nome do cliente.
     * @param nome variável do tipo String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método acessor do CPF do cliente.
     * @return String CPF
     */
    public String getCPF() {
        return CPF;
    }
    
    /**
     * Método modificador do campo CPF do cliente.
     * @param CPF variável do tipo String
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    /**
     * Método acessor do CPF do cliente.
     * @return String CPF
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método modificador do campo telefone do cliente.
     * @param telefone variável do tipo String
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Método acessor do celular do cliente.
     * @return String celular
     */
    public String getCelular() {
        return celular;
    }
    
    /**
     * Método modificador do campo celular do cliente.
     * @param celular variável do tipo String
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Método acessor da chave estrangeira do cliente.
     * @return int fkIdCliente
     */
    public int getFkIdCliente() {
        return fkIdCliente;
    }
    
    /**
     * Método modificador do campo chave estrangeira do cliente.
     * @param fkIdCliente variável do tipo int
     */
    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }
 
    /**
     * Método acessor do id da venda.
     * @return int fkIdCliente
     */
    public int getIdVenda() {
        return idVenda;
    }
    
    /**
     * Método modificador do campo id da venda.
     * @param idVenda variável do tipo int
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
     /**
     * Método acessor da data de venda.
     * @return Date dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }
    
    /**
     * Método modificador do campo data de venda.
     * @param dataVenda variável do tipo Date
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
     /**
     * Método acessor do preço da venda.
     * @return double precoTotal
     */
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
 

}

