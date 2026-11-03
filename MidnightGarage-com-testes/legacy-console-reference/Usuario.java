package MidnightGarage;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;

    public Usuario(int id, String nome, String email, String senha, String perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getPerfil() { return perfil; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public String paraArquivo() {
        return id + ";" + limpar(nome) + ";" + limpar(email) + ";" + limpar(senha) + ";" + limpar(perfil);
    }

    private String limpar(String valor) {
        return valor == null ? "" : valor.replace(";", ",").replace("\n", " ").replace("\r", " ");
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | E-mail: " + email + " | Perfil: " + perfil;
    }
}
