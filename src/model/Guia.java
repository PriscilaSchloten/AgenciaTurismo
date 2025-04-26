package model;

public class Guia {

    private int id;
    private String nome;
    private String estado;
    private String email;
    private String telefone;

    // Construtor com todos os parâmetros
    
    public Guia(int id, String nome, String estado, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
    } 
    public Guia() {
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
