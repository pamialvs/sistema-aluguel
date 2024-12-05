// public class ItemAluguel {

//     // Atributos
//     private String idProduto;
//     private int quantidade;
//     private double valor;
//     private double total;

//     // Construtor
//     public ItemAluguel(String idProduto, int quantidade, double valor) {
//         this.idProduto = idProduto;
//         this.quantidade = quantidade;
//         this.valor = valor;
//         calcularTotal();
//     }

//     // Método para calcular o total do item (quantidade * preço unitário)
//     private void calcularTotal() {
//         this.total = this.quantidade * this.valor;
//     }

//     // Getters e Setters
//     public String getCodigoProduto() {
//         return idProduto;
//     }

//     public void setCodigoProduto(String codigoProduto) {
//         this.idProduto = codigoProduto;
//     }

//     public int getQuantidade() {
//         return quantidade;
//     }

//     public void setQuantidade(int quantidade) {
//         this.quantidade = quantidade;
//         calcularTotal(); // Recalcula o total se a quantidade for alterada
//     }

//     public double getValor() {
//         return valor;
//     }

//     public void setTotal(double valor) {
//         this.valor = valor;
//         calcularTotal(); // Recalcula o total se o preço for alterado
//     }

//     public double getTotal() {
//         return total;
//     }

//     // Método para exibir os detalhes do item (opcional)
//     public void exibirDetalhes() {
//         System.out.println("Código: " + idProduto);
//         System.out.println("Quantidade: " + quantidade);
//         System.out.println("Preço Unitário: " + valor);
//         System.out.println("Total: " + total);
//     }

//     // Método toString para fácil visualização do item
//     @Override
//     public String toString() {
//         return "ItemPedido{" +
//                 "codigoProduto='" + idProduto + '\'' +
//                 ", quantidade=" + quantidade +
//                 ", precoUnitario=" + valor +
//                 ", total=" + total +
//                 '}';
//     }
// }

public class ItemAluguel {
    private String idProduto;
    private int quantidade;
    private double precoUnitario;

    // Construtor
    public ItemAluguel(String idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = 10.0;  // Exemplo de preço fixo, isso pode ser ajustado conforme necessidade
    }

    // Getters e Setters
    public String getCodProduto() {
        return idProduto;
    }

    public void setCodProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemAluguel{" +
               "idProduto='" + idProduto + '\'' +
               ", quantidade=" + quantidade +
               ", precoUnitario=" + precoUnitario +
               '}';
    }
}

