public class Avaliacao {
    private double nota;
    private String comentario;
    private Usuario usuario;

    public Avaliacao(double nota, String comentario, Usuario usuario) {
        this.nota = nota;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public void verAvaliacao() {
        System.out.println("Nota: " + nota + " | Comentário: " + comentario + " | Usuário: " + usuario.nomeUsuario);
    }
}
