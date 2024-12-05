import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstancia();
        Biblioteca biblioteca = Biblioteca.getInstancia(); // Singleton da Biblioteca

        // Criando objetos Cliente
        Cliente cliente1 = new Cliente("C001", "João Silva", "joao.silva@gmail.com");
        Cliente cliente2 = new Cliente("C002", "Maria Oliveira", "maria.oliveira@gmail.com");

        // Cadastrando clientes
        sistema.cadastrarCliente(cliente1);
        sistema.cadastrarCliente(cliente2);

        // Criando livros
        Livro livro1 = new Livro("1", "O senhor dos anéis", "J.R.R. Tolkien");
        Livro livro2 = new Livro("2", "1984", "George Orwell");
        Livro livro3 = new Livro("3", "Dom Quixote", "Miguel de Cervantes");

        // Adicionando livros
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        // Listando livros
        System.out.println("\n--- Listando livros após adicionar ---");
        biblioteca.listarLivros();

        // Removendo um livro
        System.out.println("\n--- Removendo o livro '1984' ---");
        biblioteca.removerLivro("1984");

        // Listando livros após remoção
        System.out.println("\n--- Listando livros após remover ---");
        biblioteca.listarLivros();

        // Criando itens de pedido
        ItemPedido item1 = new ItemPedido("P001", 2, 50.0);
        ItemPedido item2 = new ItemPedido("P002", 1, 30.0);
        List<ItemPedido> itensPedido1 = new ArrayList<>();
        itensPedido1.add(item1);
        itensPedido1.add(item2);

        // Cadastrando um pedido usando o ID do cliente
        sistema.cadastrarPedido(cliente1.getId(), itensPedido1);

        // Criando mais itens de pedido
        ItemPedido item3 = new ItemPedido("P003", 3, 20.0);
        List<ItemPedido> itensPedido2 = new ArrayList<>();
        itensPedido2.add(item3);

        // Cadastrando outro pedido usando o ID do cliente
        sistema.cadastrarPedido(cliente2.getId(), itensPedido2);

        System.out.println("\n--- Listando todos os pedidos ---");
        sistema.listarPedidos();

        // Exemplo: Total de todos os pedidos
        System.out.println("Total de pedidos: R$ " + sistema.calcularTotalPedidos());

    }
}




// import java.util.ArrayList;
// import java.util.List;

// public class Main {

//     public static void main(String[] args) {
//         // 1. Criando o sistema usando o Singleton
//         Sistema sistema = Sistema.getInstancia();

//         // 2. Cadastrando um cliente
//         Cliente cliente1 = new Cliente("C001", "João Silva", "joasilva@gmail.com");
//         Cliente cliente2 = new Cliente("C002", "Maria Oliveira", "mariaoliv@gmail.com");
//         sistema.cadastrarCliente(cliente1);
//         sistema.cadastrarCliente(cliente2);

//         // 3. Criando itens de pedido
//         ItemPedido item1 = new ItemPedido("P001", 2, 50.0);  // 2 unidades de P001, preço 50.0 cada
//         ItemPedido item2 = new ItemPedido("P002", 1, 30.0);  // 1 unidade de P002, preço 30.0
//         List<ItemPedido> itensPedido1 = new ArrayList<>();
//         itensPedido1.add(item1);
//         itensPedido1.add(item2);

//         // 4. Cadastrando um pedido para o cliente1
//         sistema.cadastrarPedido(cliente1, itensPedido1);

//         // 5. Criando mais itens de pedido para o cliente2
//         ItemPedido item3 = new ItemPedido("P003", 3, 20.0);  // 3 unidades de P003, preço 20.0
//         List<ItemPedido> itensPedido2 = new ArrayList<>();
//         itensPedido2.add(item3);

//         // 6. Cadastrando um pedido para o cliente2
//         sistema.cadastrarPedido(cliente2, itensPedido2);

//         // 7. Adicionando mais itens a um pedido existente
//         ItemPedido item4 = new ItemPedido("P004", 5, 10.0);  // 5 unidades de P004, preço 10.0
//         sistema.adicionarItemAoPedido("P" + cliente1.getId(), item4);

//         // 8. Calculando o total de todos os pedidos registrados no sistema
//         double totalPedidos = sistema.calcularTotalPedidos();
//         System.out.println("Total de todos os pedidos registrados no sistema: R$ " + totalPedidos);

//         // 9. Verificando o total de um pedido específico (cliente1)
//         Pedido pedidoCliente1 = sistema.localizarPedido("P" + cliente1.getId());
//         if (pedidoCliente1 != null) {
//             System.out.println("Total do pedido de " + pedidoCliente1.getCliente().getNome() + ": R$ " + pedidoCliente1.calcularTotalPedido());
//         } else {
//             System.out.println("Pedido não encontrado!");
//         }
//     }
// }

