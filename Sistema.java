import java.util.ArrayList;
import java.util.List;

public class Sistema {

    // Instâncias únicas dos módulos
    private static Sistema instancia;
    private ModuloAluguel moduloAluguel;
    private ModuloPedido moduloPedido;
    
    // Listas para armazenar clientes, pedidos e aluguéis
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    // Construtor privado para evitar instâncias externas
    private Sistema() {
        // Inicializando os módulos
        moduloAluguel = ModuloAluguel.getInstancia();
        moduloPedido = ModuloPedido.getInstancia();
        
        // Inicializando as listas de clientes e pedidos
        clientes = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    // Método para acessar a instância única do Sistema (Singleton)
    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();  // Cria a instância se não existir
        }
        return instancia;
    }

    // Método para cadastrar um cliente
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente.getNome());
    }


    // Método para localizar um cliente
    public Cliente localizarCliente(String idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(idCliente)) {
                return cliente;  // Retorna o cliente encontrado
            }
        }
        return null;  // Retorna null se o cliente não for encontrado
    }

    // Método para cadastrar um pedido
    public void cadastrarPedido(String idCliente, List<ItemPedido> itens) {
        Cliente cliente = localizarCliente(idCliente);  // Localiza o cliente
        if (cliente != null) {
            Pedido pedido = new Pedido(cliente, itens);  // Cria um novo pedido
            pedidos.add(pedido);  // Adiciona o pedido à lista de pedidos
            System.out.println("Pedido cadastrado com sucesso para o cliente: " + idCliente);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    // Método para adicionar um item a um pedido
    public void adicionarItemAoPedido(String idPedido, ItemPedido item) {
        Pedido pedido = localizarPedido(idPedido);  // Localiza o pedido
        if (pedido != null) {
            pedido.adicionarItem(item);  // Adiciona o item ao pedido
            System.out.println("Item adicionado ao pedido com ID: " + idPedido);
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    // Método para listar todos os pedidos cadastrados
    public void listarPedidos() {
        System.out.println("--- Lista de Pedidos ---");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }


    // Método para localizar um pedido pelo ID
    public Pedido localizarPedido(String idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(idPedido)) {

                return pedido;  // Retorna o pedido encontrado
            }
        }
        return null;  // Retorna null se não encontrar o pedido
    }

    // Método para calcular o total de todos os pedidos
    public double calcularTotalPedidos() {
        double total = 0.0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotalPedido();  // Soma o total de cada pedido
        }
        return total;  // Retorna o total acumulado
    }

    // Métodos do Módulo de Aluguel
    public void cadastrarAluguel(String idCliente) {
        moduloAluguel.cadastrarAluguel(idCliente);  // Chama o método de cadastro de aluguel
    }

    public void adicionarItemAoAluguel(String idAluguel, String codProduto, int quantidade) {
        moduloAluguel.adicionarItemAoAluguel(idAluguel, codProduto, quantidade);  // Adiciona item ao aluguel
    }

    public double calcularTotalAlugueis() {
        return moduloAluguel.calcularTotalAlugueis();  // Retorna o total de aluguéis
    }

}
