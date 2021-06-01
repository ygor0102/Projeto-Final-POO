/**
 * @author Ygor Oliveira - Yasmim Candelária - Juan Gonçalves Dias - Filipe Vital da Silva
 * @since 17/05/2021
 */

package Model;

import java.util.Date;

public class Cliente {
    
    private int idCliente;
    private String nome;
    private Date nascimento;
    private String CPF;
    private String sexo;
    private String estado;
    private String UF;
    private String logradouro;
    private int numero;
    private String complemento;
    private String telefone;
    private String celular;
    private String email;
    
    
    public Cliente(String nome, Date Nascimento, String CPF, String sexo,
                      String estado, String UF, String logradouro, int numero, 
                      String complemento, String telefone, String celular, String email){
    }
    
    //Construtor para classe de venda;
    public Cliente(int IdCliente, String nome, String CPF, String telefone, String celular){
    
    
    }
    

    public Cliente(){
    
}
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNome() {
        return nome;
    }
     
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public Date getNascimento() {
        return nascimento;
    }
 
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCPF() {
        return CPF;
    }
  
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
  
    public String getLogradouro() {
        return logradouro;
    }
  
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
  
    public int getNumero() {
        return numero;
    }
 
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

   
}

