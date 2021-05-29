package Model;

public class Lanche {

    private int idLanche;
    private String nome;
    private String sabor;
    private String tipo;
    private double precoUnitario;
    private int qtdEstoque;

    public Lanche(String nome, String sabor, String tipo, double precoUnitario, int qtdEstoque) {
        this.nome = nome;
        this.sabor = sabor;
        this.tipo = tipo;
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
 
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
  
    public double getPrecoProduto() {
        return precoUnitario;
    }
   
    public void setPrecoProduto(double precoProduto) {
        this.precoUnitario = precoProduto;
    }

    public int getIdLanche() {
        return idLanche;
    }

    public void setIdLanche(int idLanche) {
        this.idLanche = idLanche;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    
}
