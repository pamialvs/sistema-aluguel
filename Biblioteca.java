// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static Biblioteca instancia; // Singleton
    private List<Livro> livros;         // Lista de livros na biblioteca

    // Construtor privado para implementar o Singleton
    private Biblioteca() {
        livros = new ArrayList<>();
    }

    // Método para obter a instância única do Singleton
    public static Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    // Método para adicionar um livro
    public void adicionarLivro(Livro livro) {
        if (livro != null) {
            livros.add(livro);
            System.out.println("Livro adicionado: " + livro);
        } else {
            System.out.println("O livro fornecido é inválido.");
        }
    }

    // Método para remover um livro pelo título
    public void removerLivro(String titulo) {
        Livro livroParaRemover = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroParaRemover = livro;
                break;
            }
        }

        if (livroParaRemover != null) {
            livros.remove(livroParaRemover);
            System.out.println("Livro removido: " + livroParaRemover);
        } else {
            System.out.println("Livro com o título '" + titulo + "' não encontrado.");
        }
    }

    // Método para buscar livros pelo título (parcial ou completo)
    public List<Livro> buscarLivros(String titulo) {
        List<Livro> resultados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(livro);
            }
        }
        return resultados;
    }

    // Método para listar todos os livros
    public void listarLivros() {
        System.out.println("--- Lista de Livros na Biblioteca ---");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    
}
