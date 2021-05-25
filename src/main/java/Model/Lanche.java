package Model;

/**
 * @author Grupo 2 - Projeto Integrador
 * @since 01/11/2020
 */ 
public class Lanche {

    private int idProduto;
    private String nomeProduto;
    private String modeloProduto;
    private String tipoProduto;
    private double precoUnitario;
    private int qtdEstoque;

    public Lanche(String nomeProduto, String modeloProduto, String tipoProduto, double precoUnitario, int qtdEstoque) {
        this.nomeProduto = nomeProduto;
        this.modeloProduto = modeloProduto;
        this.tipoProduto = tipoProduto;
        this.precoUnitario = precoUnitario;
        this.qtdEstoque = qtdEstoque;
    }
    
    
    
    
    public Lanche(){
        
    }
    
    /**
     * Método acessor do campo quantidade do produto.
     * @return int qtdEstoque
     */
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    
    /**
     * Método modificador do campo quantidade do produto.
     * @param qtdEstoque variável do tipo int
     */
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
   
    /**
     * Método acessor do campo tipo do produto.
     * @return String tipoProduto
     */
    public String getTipoProduto() {
        return tipoProduto;
    }

    /**
     * Método modificador do campo tipo do produto.
     * @param tipoProduto variável do tipo String
     */
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    /**
     * Método acessor do campo id do produto.
     * @return int idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }
    
    /**
     * Método modificador do campo id do produto.
     * @param idProduto variável do tipo int
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
     
    /**
     * Método acessor do campo nome do produto.
     * @return String nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }
    
    /**
     * Método modificador do campo nome do produto.
     * @param nomeProduto variável do tipo String
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
     
    /**
     * Método acessor do campo preço do produto.
     * @return double precoUnitario
     */
    public double getPrecoProduto() {
        return precoUnitario;
    }

    /**
     * Método modificador do campo preço do produto.
     * @param precoProduto variável do tipo Double
     */
    public void setPrecoProduto(double precoProduto) {
        this.precoUnitario = precoProduto;
    }
    
    /**
     * Método acessor do campo modelo do produto.
     * @return String modeloProduto
     */
    public String getModeloProduto() {
        return modeloProduto;
    }
    
    /**
     * Método modificador do campo modelo do produto.
     * @param modeloProduto variável do tipo String
     */
    public void setModeloProduto(String modeloProduto) {
        this.modeloProduto = modeloProduto;
    }
}
