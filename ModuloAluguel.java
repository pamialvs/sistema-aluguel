// // import java.util.ArrayList;
// // import java.util.List;

// // public class ModuloAluguel {

// //     private List<Aluguel> alugueis = new ArrayList<>();

// //     private static ModuloAluguel inst;

// //     private ModuloAluguel() { }

// //     public static ModuloAluguel getInst() {
// //         if (inst == null) {
// //             inst = new ModuloAluguel();
// //         }
// //         return inst;
// //     }

// //     public String cadastrarAluguel(String idCliente) {
// //         Cliente c = Sistema.getInst().localizarCliente(idCliente);

// //         if (c == null) {
// //             System.out.println("Cliente não encontrado.");
// //             return null;
// //         }

// //         Aluguel aluguel = new Aluguel();
// //         aluguel.data = "01/12/2024"; // Substitua por data dinâmica
// //         aluguel.devolvido = false;
// //         aluguel.id = String.valueOf(this.alugueis.size());

// //         this.alugueis.add(aluguel);

// //         System.out.println("Aluguel cadastrado para o cliente: " + idCliente);
// //         return aluguel.id;
// //     }

// //     public Aluguel localizarAluguel(String idAluguel) {
// //         for (Aluguel a : this.alugueis) {
// //             if (a.id.equals(idAluguel)) {
// //                 return a;
// //             }
// //         }
// //         return null;
// //     }

// //     public void adicionarItemAluguel(String idAluguel, String codProduto, int quantidade) {
// //         Aluguel a = this.localizarAluguel(idAluguel);

// //         if (a == null) {
// //             System.out.println("Aluguel não encontrado.");
// //             return;
// //         }

// //         ItemAluguel itemAluguel = new ItemAluguel();
// //         itemAluguel.dataDevolucao = "05/12/2024"; // Substitua por lógica dinâmica
// //         itemAluguel.quantidade = quantidade;

// //         a.adicionarItemAluguel(itemAluguel); // Certifique-se de implementar esse método
// //         System.out.println("Item adicionado ao aluguel.");
// //     }

// //     public static void main(String[] args) {
// //         ModuloAluguel modulo = ModuloAluguel.getInst();
// //         modulo.cadastrarAluguel("cliente1");
// //         modulo.adicionarItemAluguel("0", "produto1", 2);
// //     }
// // }
// import java.util.ArrayList;
// import java.util.List;

// public class ModuloAluguel {

//     private List<Aluguel> alugueis;
//     private static ModuloAluguel instancia;

//     // Construtor privado para evitar instanciação externa
//     private ModuloAluguel() {
//         alugueis = new ArrayList<>();
//     }

//     // Método para acessar a instância única
//     public static ModuloAluguel getInstancia() {
//         if (instancia == null) {
//             instancia = new ModuloAluguel();
//         }
//         return instancia;
//     }

//     // Métodos para registrar e localizar alugueis
//     public void adicionarAluguel(Aluguel aluguel) {
//         alugueis.add(aluguel);
//     }

//     public Aluguel localizarAluguel(String id) {
//         for (Aluguel aluguel : alugueis) {
//             if (aluguel.getId().equals(id)) {
//                 return aluguel;
//             }
//         }
//         return null;
//     }

//     public void cadastrarAluguel(String idCliente) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'cadastrarAluguel'");
//     }

//     public void adicionarItemAluguel(String idAluguel, String codProduto, int quantidade) {
//         throw new UnsupportedOperationException("Unimplemented method 'adicionarItemAluguel'");
//     }

//     public double getTotalAlugueis() {
//         throw new UnsupportedOperationException("Unimplemented method 'getTotalAlugueis'");
//     }
// }

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



