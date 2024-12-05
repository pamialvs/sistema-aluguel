
// // import java.util.ArrayList;
// // import java.util.List;

// // public class Aluguel {

// //     String id;
// //     String data;
// //     Boolean devolvido;
// //     List itensAluguel = new ArrayList();

// //     public void adicionarItemAluguel(ItemAluguel itemAluguel) {

// //         this.itensAluguel.add(itemAluguel);

// //     }

// // }
// import java.util.ArrayList;
// import java.util.List;

// public class Aluguel {
//     private String id;
//     private String dataAluguel;
//     private String dataDevolucao;
//     private boolean devolvido;
//     private Cliente cliente;
//     private List<ItemAluguel> itensAluguel;

//     // Construtor
//     public Aluguel(String id, Cliente cliente, String dataAluguel, boolean devolvido) {
//         this.id = id;
//         this.cliente = cliente;
//         this.dataAluguel = dataAluguel;
//         this.devolvido = false;
//         this.itensAluguel = new ArrayList<>();
//     }

//     // Métodos
//     public void adicionarItemAluguel(ItemAluguel item) {
//         this.itensAluguel.add(item);
//     }

//     public void marcarComoDevolvido() {
//         this.devolvido = true;
//     }

//     public String getId() {
//         return id;
//     }

//     public String getDataAluguel() {
//         return dataAluguel;
//     }

//     public String getDataDevolucao() {
//         return dataDevolucao;
//     }

//     public Cliente getCliente() {
//         return cliente;
//     }

//     public List<ItemAluguel> getItensAluguel() {
//         return itensAluguel;
//     }
// }
import java.util.ArrayList;
import java.util.List;

public class Aluguel {
    private String id;
    private String idCliente;
    private List<ItemAluguel> itens;  // Lista de itens de aluguel

    // Construtor
    public Aluguel(String idCliente) {
        this.id = generateId();  // Gera um ID único para o aluguel
        this.idCliente = idCliente;
        this.itens = new ArrayList<>();
    }

    // Método para gerar um ID único (pode ser ajustado conforme necessário)
    private String generateId() {
        return "A" + System.currentTimeMillis();  // Gera um ID único baseado no tempo atual
    }

    // Método para adicionar um item ao aluguel
    public void adicionarItemAluguel(ItemAluguel item) {
        itens.add(item);  // Adiciona o item à lista de itens
    }

    // Método para calcular o total de um aluguel
    public double calcularTotalAluguel() {
        double total = 0.0;
        for (ItemAluguel item : itens) {
            total += item.getPrecoUnitario() * item.getQuantidade();  // Soma o preço unitário * quantidade de cada item
        }
        return total;  // Retorna o total
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemAluguel> getItens() {
        return itens;
    }

    public void setItens(List<ItemAluguel> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
               "id='" + id + '\'' +
               ", idCliente='" + idCliente + '\'' +
               ", itens=" + itens +
               '}';
    }
}


