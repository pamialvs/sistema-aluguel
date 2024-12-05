public class Cliente {
    private String idCliente;
    private String nome;
    private String email;
    public Cliente(String idCliente, String nome, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
