public class Localizacao {

    private String cidade;
    private String estado;
    private String bairro;
    private String rua;
    private int numero;
    private int cep;

    // Construtor
    public Localizacao(String cidade, String estado, String bairro, String rua, int numero, int cep) {
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    // Getters e Setters
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    // Método toString para representar a localização de maneira legível
    @Override
    public String toString() {
        return "Localização [rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade 
               + ", estado=" + estado + ", cep=" + cep + "]";
    }
}
