
package Model;

import java.util.Date;
/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */
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
    

public Cliente(){
    
}
    /**
     * Método acessor do id do cliente.
     * @return int idCliente
     */


    public int getIdCliente() {
        return idCliente;
    }
    /**
     * Método modificador do id do cliente.
     * @param idCliente variável do tipo int
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    /**
     * Método acessor do campo sexo do cliente.
     * @return String sexo
     */ 
    public String getSexo() {
        return sexo;
    }
    
    /**
     * Método modificador do campo sexo do cliente.
     * @param sexo variável do tipo String
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /**
     * Método acessor do campo nome do cliente.
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
     * Método acessor do campo nascimento do cliente.
     * @return Date nascimento
     */ 
    public Date getNascimento() {
        return nascimento;
    }
    
    /**
     * Método modificador do campo nascimento do cliente.
     * @param nascimento variável do tipo Date
     */ 
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    /**
     * Método acessor do campo CPF do cliente.
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
     * Método acessor do campo estado do cliente.
     * @return String estado
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Método modificador do campo estado do cliente.
     * @param estado variável do tipo String
     */ 
    public void setEstado(String estado) {
        this.estado = estado;
    }
     
    /**
     * Método acessor do campo UF do cliente.
     * @return String UF
     */
    public String getUF() {
        return UF;
    }

    /**
     * Método modificador do campo UF do cliente.
     * @param UF variável do tipo String
     */
    public void setUF(String UF) {
        this.UF = UF;
    }
    
    /**
     * Método acessor do campo logradouro do cliente.
     * @return String logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }
    
    /**
     * Método modificador do campo logradouro do cliente.
     * @param logradouro variável do tipo String
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
     /**
     * Método acessor do campo numero de residencia do cliente.
     * @return int numero
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * Método modificador do campo numero de residencia do cliente.
     * @param numero variável do tipo int
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método acessor do campo complemento do cliente.
     * @return String complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Método modificador do campo complemento do cliente.
     * @param complemento variável do tipo String
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    /**
     * Método acessor do campo telefone do cliente.
     * @return String telefone
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
     * Método acessor do campo celular do cliente.
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
     * Método acessor do campo email do cliente.
     * @return String email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Método modificador do campo email do cliente.
     * @param email variável do tipo String
     */
    public void setEmail(String email) {
        this.email = email;
    }

   
}

