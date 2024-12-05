import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {

    // Instância única (Singleton)
    private static Sistema instancia;

    // Mapas para gerenciar entidades do sistema
    private Map<String, Cliente> clientes;

    // Instâncias de outros módulos
    private ModuloAluguel moduloAluguel;

    // Construtor privado para evitar instâncias externas
    private Sistema() {
        clientes = new HashMap<>();
        moduloAluguel = ModuloAluguel.getInstancia(); // Singleton do módulo de aluguel
    }

    // Método para obter a instância única do Sistema
    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    // ---------------------- Métodos para Gerenciar Clientes ----------------------

    public void cadastrarCliente(String id, String nome, String email) {
        if (clientes.containsKey(id)) {
            System.out.println("Cliente já cadastrado com o ID: " + id);
            return;
        }
        Cliente cliente = new Cliente(id, nome, email);
        clientes.put(id, cliente);
        System.out.println("Cliente cadastrado: " + nome);
    }

    public Cliente localizarCliente(String id) {
        return clientes.get(id);
    }

    public void removerCliente(String id) {
        if (clientes.remove(id) != null) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // ---------------------- Métodos para Módulo de Aluguel ----------------------

    public void cadastrarAluguel(String idCliente) {
        moduloAluguel.cadastrarAluguel(idCliente);
    }

    public void adicionarItemAoAluguel(String idAluguel, String idProduto, int quantidade) {
        moduloAluguel.adicionarItemAoAluguel(idAluguel, idProduto, quantidade);
    }

    public double calcularTotalAlugueis() {
        return moduloAluguel.calcularTotalAlugueis();
    }

        public void adicionarLivroNaBiblioteca(String titulo, String autor, String codigo) {
            Livro novoLivro = new Livro(codigo, titulo, autor);
            Biblioteca.getInstancia().adicionarLivro(novoLivro); // Acesso direto ao Singleton
        }
    
        public void listarLivrosDaBiblioteca() {
            Biblioteca.getInstancia().listarLivros(); // Acesso direto ao Singleton
        }
    
        public void buscarLivroNaBiblioteca(String titulo) {
            List<Livro> resultados = Biblioteca.getInstancia().buscarLivros(titulo); // Busca
            if (resultados.isEmpty()) {
                System.out.println("Nenhum livro encontrado com o título: " + titulo);
            } else {
                System.out.println("--- Resultados da Busca ---");
                for (Livro livro : resultados) {
                    System.out.println(livro);
                }
            }
        }
    
        public void removerLivroDaBiblioteca(String titulo) {
            Biblioteca.getInstancia().removerLivro(titulo); // Acesso direto ao Singleton
        }
    }
    
