import java.util.ArrayList;
import java.util.List;

public class ModuloAluguel {

    private List<Aluguel> alugueis;  // Lista para armazenar os aluguéis
    private static ModuloAluguel instancia;  // Instância única do Singleton

    // Construtor privado para evitar criação de instâncias externas
    private ModuloAluguel() {
        alugueis = new ArrayList<>();
    }

    // Método para acessar a instância única do Singleton
    public static ModuloAluguel getInstancia() {
        if (instancia == null) {
            instancia = new ModuloAluguel();  // Cria a instância se ainda não existir
        }
        return instancia;
    }

    // Método para cadastrar um aluguel
    public void cadastrarAluguel(String idCliente) {
        Aluguel novoAluguel = new Aluguel(idCliente);  // Cria um novo aluguel com o ID do cliente
        alugueis.add(novoAluguel);  // Adiciona o novo aluguel à lista de aluguéis
        System.out.println("Aluguel cadastrado com sucesso para o cliente: " + idCliente);
    }

    // Método para adicionar um item ao aluguel
    public void adicionarItemAoAluguel(String idAluguel, String idProduto, int quantidade) {
        Aluguel aluguel = localizarAluguel(idAluguel);  // Localiza o aluguel com o ID fornecido
        if (aluguel != null) {
            ItemAluguel novoItem = new ItemAluguel(idProduto, quantidade);  // Cria um novo item de aluguel
            aluguel.adicionarItemAluguel(novoItem);  // Adiciona o item ao aluguel
            System.out.println("Item adicionado ao aluguel com ID: " + idAluguel);
        } else {
            System.out.println("Aluguel com ID " + idAluguel + " não encontrado!");
        }
    }

    // Método para localizar um aluguel pelo ID
    private Aluguel localizarAluguel(String idAluguel) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getId().equals(idAluguel)) {
                return aluguel;  // Retorna o aluguel encontrado
            }
        }
        return null;  // Retorna null se não encontrar o aluguel
    }

    // Método para calcular o total dos aluguéis
    public double calcularTotalAlugueis() {
        double total = 0.0;
        for (Aluguel aluguel : alugueis) {
            total += aluguel.calcularTotalAluguel();  // Soma o total de cada aluguel
        }
        return total;  // Retorna o total acumulado
    }
}



