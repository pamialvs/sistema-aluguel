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


// // // A classe Sistema vai ser para o controle geral do sistema

// // import java.util.List;
// // import java.util.ArrayList;

// // public class Sistema {
// //     private static Sistema instancia;
// //     private List<Cliente> clientes = new ArrayList<>();

// //     private Sistema() {
// //         // Inicializar a lista de clientes (exemplo)
// //         clientes.add(new Cliente("1", "João"));
// //         clientes.add(new Cliente("2", "Maria"));
// //     }

// //     public static Sistema getInst() {
// //         if (instancia == null) {
// //             instancia = new Sistema();
// //         }
// //         return instancia;
// //     }

// //     public Cliente localizarCliente(String idCliente) {
// //         for (Cliente cliente : clientes) {
// //             if (cliente.getId().equals(idCliente)) {
// //                 return cliente;
// //             }
// //         }
// //         return null; // Retorna null se o cliente não for encontrado
// //     }
// // }

// import java.util.HashMap;
// import java.util.Map;

// public class Sistema {

//     // Instância única (Singleton)
//     private static Sistema instancia;

//     // Mapas para armazenar clientes, pedidos, etc.
//     private Map<String, Cliente> clientes;
//     private Map<String, Pedido> pedidos;
    
//     // Instâncias de outros módulos
//     private ModuloAluguel moduloAluguel;
//     private Biblioteca biblioteca;

//     // Construtor privado para evitar instanciação externa
//     private Sistema() {
//         this.clientes = new HashMap<>();
//         this.pedidos = new HashMap<>();
//         this.moduloAluguel = ModuloAluguel.getInstancia(); // Singleton do Módulo de Aluguel
//         this.biblioteca = Biblioteca.getInstancia("Biblioteca Central"); // Singleton da Biblioteca
//     }

//     // Método para acessar a instância única do Sistema
//     public static Sistema getInstancia() {
//         if (instancia == null) {
//             instancia = new Sistema();
//         }
//         return instancia;
//     }

//     // ---------------------- Métodos para gerenciar Clientes ----------------------

//     public void cadastrarCliente(String id, String nome, String email) {
//         Cliente cliente = new Cliente(id, nome, email);
//         clientes.put(id, cliente); // Adiciona o cliente ao mapa
//     }

//     public Cliente localizarCliente(String id) {
//         return clientes.get(id); // Localiza e retorna o cliente pelo id
//     }

//     public void removerCliente(String id) {
//         clientes.remove(id); // Remove o cliente pelo id
//     }

//     // ---------------------- Métodos para gerenciar Pedidos ----------------------

//     public Pedido criarPedido(String idPedido, String idCliente) {
//         Cliente cliente = localizarCliente(idCliente); // Localiza o cliente
//         if (cliente != null) {
//             Pedido pedido = new Pedido(idPedido, idCliente); // Cria um novo pedido
//             pedidos.put(idPedido, pedido); // Adiciona o pedido ao mapa
//             return pedido;
//         } else {
//             return null; // Cliente não encontrado
//         }
//     }

//     public Pedido localizarPedido(String idPedido) {
//         return pedidos.get(idPedido); // Localiza e retorna o pedido pelo id
//     }

//     public void adicionarItemAoPedido(String idPedido, String idProduto, int quantidade, double precoUnitario) {
//         Pedido pedido = localizarPedido(idPedido); // Localiza o pedido
//         if (pedido != null) {
//             ItemAluguel item = new ItemAluguel(idProduto, quantidade, precoUnitario); // Cria o item do pedido
//             pedido.adicionarItem(item); // Adiciona o item ao pedido
//         }
//     }

//     public double calcularTotalPedido(String idPedido) {
//         Pedido pedido = localizarPedido(idPedido); // Localiza o pedido
//         if (pedido != null) {
//             return pedido.calcularTotalPedido(); // Retorna o total do pedido
//         }
//         return 0.0; // Retorna 0 se o pedido não for encontrado
//     }

//     public void exibirPedidos() {
//         for (Pedido pedido : pedidos.values()) {
//             System.out.println(pedido); // Exibe todos os pedidos cadastrados
//         }
//     }

//     // ---------------------- Métodos para Módulo de Aluguel ----------------------

//     public void cadastrarAluguel(String idCliente) {
//         moduloAluguel.cadastrarAluguel(idCliente); // Chama o método de cadastro de aluguel
//     }

//     public void adicionarItemAoAluguel(String idAluguel, String codProduto, int quantidade) {
//         moduloAluguel.adicionarItemAoAluguel(idAluguel, codProduto, quantidade); // Adiciona item ao aluguel
//     }

//     public double calcularTotalAlugueis() {
//         return moduloAluguel.calcularTotalAlugueis(); // Retorna o total de aluguéis
//     }

//     // ---------------------- Métodos para Biblioteca ----------------------

//     public void adicionarLivro(String codigo, String titulo, String autor) {
//         biblioteca.adicionarLivro(codigo, titulo, autor); // Adiciona um livro à biblioteca
//     }

//     public Livro localizarLivro(String codigo) {
//         return biblioteca.localizarLivro(codigo); // Localiza e retorna o livro pelo código
//     }

//     public void exibirLivros() {
//         biblioteca.getLivros(); // Exibe todos os livros da biblioteca
//     }
// }

