public class ItemPedido {
    private String idProduto;
    private int quantidade;
    private double precoUnitario;

    // Construtor
    public ItemPedido(String idProduto, int quantidade, double precoUnitario) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Getters e Setters
    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
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
        return "ItemPedido{" +
               "idProduto='" + idProduto + '\'' +
               ", quantidade=" + quantidade +
               ", precoUnitario=" + precoUnitario +
               '}';
    }
}
