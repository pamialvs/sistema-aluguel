import java.util.ArrayList;
import java.util.List;

public class ModuloPedido {

    // Instância única do ModuloPedido
    private static ModuloPedido instancia;

    // Lista de pedidos registrados
    private List<Pedido> pedidos;

    // Construtor privado para evitar instância externa
    private ModuloPedido() {
        pedidos = new ArrayList<>();
    }

    // Método para acessar a instância única (Singleton)
    public static ModuloPedido getInstancia() {
        if (instancia == null) {
            instancia = new ModuloPedido();  // Cria a instância se não existir
        }
        return instancia;
    }

    // Método para cadastrar um pedido
    public void cadastrarPedido(Cliente cliente, List<ItemPedido> itens) {
        Pedido pedido = new Pedido(cliente, itens);  // Cria um novo pedido
        pedidos.add(pedido);  // Adiciona o pedido à lista
        System.out.println("Pedido cadastrado com sucesso para o cliente: " + cliente.getNome());
    }

    // Método para adicionar um item a um pedido
    public void adicionarItemAoPedido(String idPedido, ItemPedido item) {
        Pedido pedido = localizarPedido(idPedido);  // Localiza o pedido pelo ID
        if (pedido != null) {
            pedido.adicionarItem(item);  // Adiciona o item ao pedido
            System.out.println("Item adicionado ao pedido com ID: " + idPedido);
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    // Método para localizar um pedido pelo ID
    public Pedido localizarPedido(String idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(idPedido)) {
                return pedido;  // Retorna o pedido encontrado
            }
        }
        return null;  // Retorna null se o pedido não for encontrado
    }

    // Método para calcular o total de todos os pedidos
    public double calcularTotalPedidos() {
        double total = 0.0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotalPedido();  // Soma o total de cada pedido
        }
        return total;  // Retorna o total acumulado
    }
}

