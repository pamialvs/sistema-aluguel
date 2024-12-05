public class Usuario {
    private String login;
    private String senha;
    // private String email;
    // private String celular;
    public String nomeUsuario;

    public Usuario(String login, String senha, String email, String celular, String nomeUsuario) {
        this.login = login;
        this.senha = senha;
        // this.email = email;
        // this.celular = celular;
        this.nomeUsuario = nomeUsuario;
    }

    public boolean realizarLogin(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso.");
    }

}
