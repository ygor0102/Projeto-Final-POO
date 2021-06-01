/**
 * @author Ygor Oliveira - Yasmim Candelária - Juan Gonçalves Dias - Filipe Vital da Silva
 * @since 17/05/2021
 */
package Model;

public interface ApplicableDiscount {
    
    public abstract double calcularDesconto(double precoTotal, double desconto);
    
}
