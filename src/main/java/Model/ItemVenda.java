
package Model;

public class ItemVenda {
    private  int idItem;
    private int FkIdVenda;
    private int FkIdProduto;
    private String nome;
    private String modelo;
    private String tipo;
    private double precoUnitario;
    
     public ItemVenda(){
     
    }
     
    /**
     * Método acessor do campo nome do produto.
     * @return String nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Método modificador do campo nome do produto.
     * @param nome variável do tipo String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método acessor do campo modelo do produto.
     * @return String modelo
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * Método modificador do campo modelo do produto.
     * @param modelo variável do tipo String
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Método acessor do campo tipo do produto.
     * @return String tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método modificador do campo tipo do produto.
     * @param tipo variável do tipo String
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método acessor do campo preço do produto.
     * @return double precoUnitario
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * Método modificador do campo preço do produto.
     * @param precoUnitario variável do tipo Double
     */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    /**
     * Método acessor da chave estrangeira do produto.
     * @return int FkIdProduto
     */
    public int getFkIdProduto() {
        return FkIdProduto;
    }
    
    /**
     * Método modificador da chave estrangeira do produto.
     * @param FkIdProduto variável do tipo int
     */
    public void setFkIdProduto(int FkIdProduto) {
        this.FkIdProduto = FkIdProduto;
    }
     
    /**
     * Método acessor do id do item.
     * @return int idItem
     */
    public int getIdItem() {
        return idItem;
    }
    /**
     * Método modificador do id do item.
     * @param idItem variável do tipo int
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    /**
     * Método acessor da chave estrangeira do id da venda.
     * @return int FkIdVenda
     */
    public int getFkIdVenda() {
        return FkIdVenda;
    }
    
    /**
     * Método modificador da chave estrangeira do id da venda
     * @param FkIdVenda variável do tipo int
     */
    public void setFkIdVenda(int FkIdVenda) {
        this.FkIdVenda = FkIdVenda;
    }
  
    
}
