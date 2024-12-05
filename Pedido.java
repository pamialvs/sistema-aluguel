
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String id;
    private Cliente cliente;
    private List<ItemPedido> itens;

    // Construtor do pedido
    public Pedido(Cliente cliente, List<ItemPedido> itens) {
        this.id = "P" + System.currentTimeMillis();  // Gerando um ID único para o pedido
        this.cliente = cliente;
        this.itens = new ArrayList<>(itens);  // Cria uma cópia dos itens
    }

    // Método para adicionar um item ao pedido
    public void adicionarItem(ItemPedido item) {
        itens.add(item);  // Adiciona o item à lista de itens do pedido
    }

    // Método para calcular o total do pedido
    public double calcularTotalPedido() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getPrecoUnitario() * item.getQuantidade();  // Soma o valor dos itens
        }
        return total;  // Retorna o total calculado
    }

    // Métodos getters e setters
    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}

// import java.util.ArrayList;
// import java.util.List;

// public class Pedido {
//     private String idPedido;
//     private String idCliente;
//     private List<ItemAluguel> itens; // Lista agora aceita ItemAluguel

//     // Construtor
//     public Pedido(String idPedido, String idCliente) {
//         this.idPedido = idPedido;
//         this.idCliente = idCliente;
//         this.itens = new ArrayList<>();
//     }

//     // Método para adicionar um item ao pedido
//     public void adicionarItem(ItemPedido item) {
//         itens.add(item); // Adiciona o item à lista de itens
//     }

//     // Método para calcular o total do pedido (se necessário)
//     public double calcularTotalPedido() {
//         double total = 0.0;
//         for (ItemAluguel item : itens) {
//             total += item.getPrecoUnitario() * item.getQuantidade(); // Ajuste se necessário
//         }
//         return total;
//     }

//     // Getters e Setters
//     public String getIdPedido() {
//         return idPedido;
//     }

//     public void setIdPedido(String idPedido) {
//         this.idPedido = idPedido;
//     }

//     public String getIdCliente() {
//         return idCliente;
//     }

//     public void setIdCliente(String idCliente) {
//         this.idCliente = idCliente;
//     }

//     public List<ItemAluguel> getItens() {
//         return itens;
//     }

//     public void setItens(List<ItemAluguel> itens) {
//         this.itens = itens;
//     }

//     @Override
//     public String toString() {
//         return "Pedido{" +
//                "idPedido='" + idPedido + '\'' +
//                ", idCliente='" + idCliente + '\'' +
//                ", itens=" + itens +
//                '}';
//     }
// }



//     // Método para adicionar um item ao pedido
//     public void adicionarItem(ItemPedido item) {
//         this.itens.add(item);
//     }

//     // Método para remover um item do pedido
//     public void removerItem(ItemPedido item) {
//         this.itens.remove(item);
//     }

//     // Método para calcular o valor total do pedido
//     public double calcularValorTotal() {
//         double total = 0.0;
//         for (ItemPedido item : itens) {
//             total += item.getValorTotal();
//         }
//         return total;
//     }

//     // Método para atualizar o status do pedido
//     public void atualizarStatus(String novoStatus) {
//         this.status = novoStatus;
//     }

//     // Método para confirmar o pedido (ex: status "pendente" -> "confirmado")
//     public void confirmarPedido() {
//         if ("pendente".equals(this.status)) {
//             this.status = "confirmado";
//         }
//     }

//     // Getters e Setters
//     public String getIdPedido() {
//         return idPedido;
//     }

//     public void setIdPedido(String idPedido) {
//         this.idPedido = idPedido;
//     }

//     public Cliente getCliente() {
//         return cliente;
//     }

//     public void setCliente(Cliente cliente) {
//         this.cliente = cliente;
//     }

//     public List<ItemPedido> getItens() {
//         return itens;
//     }

//     public void setItens(List<ItemPedido> itens) {
//         this.itens = itens;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public Date getDataPedido() {
//         return dataPedido;
//     }

//     public void setDataPedido(Date dataPedido) {
//         this.dataPedido = dataPedido;
//     }

//     public Date getDataEntrega() {
//         return dataEntrega;
//     }

//     public void setDataEntrega(Date dataEntrega) {
//         this.dataEntrega = dataEntrega;
//     }

//     @Override
//     public String toString() {
//         return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente + ", status=" + status
//                 + ", dataPedido=" + dataPedido + ", dataEntrega=" + dataEntrega + "]";
//     }
// }
