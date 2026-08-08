package LojadeCarros;

public class Comprador {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String metodoPagamento;

    public Comprador(String nome,
                     String cpf,
                     String dataNascimento,
                     String metodoPagamento) {

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.metodoPagamento = metodoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void exibirDescricao() {

        System.out.println();
        System.out.println("======= COMPRADOR =======");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Método de Pagamento: " + metodoPagamento);
        System.out.println("=========================");
    }
}