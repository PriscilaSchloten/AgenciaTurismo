package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pacote {

    private int id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int destinoId;
    private int guiaId;
    private int clienteId;
    private String nomeDestino;
    private String nomeGuia;
    private String nomeCliente;

    public Pacote() {
    }

    public Pacote(int id, String nome, String descricao, BigDecimal preco, LocalDate dataInicio, LocalDate dataFim, int destinoId, int guiaId, int clienteId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.destinoId = destinoId;
        this.guiaId = guiaId;
        this.clienteId = clienteId;
    }

    // Getters e Setters
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public int getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(int destinoId) {
        this.destinoId = destinoId;
    }

    public int getGuiaId() {
        return guiaId;
    }

    public void setGuiaId(int guiaId) {
        this.guiaId = guiaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public String getNomeGuia() {
        return nomeGuia;
    }

    public void setNomeGuia(String nomeGuia) {
        this.nomeGuia = nomeGuia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void exibirDetalhes() {
        System.out.println("ID do Pacote: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Data de Fim: " + dataFim);
        System.out.println("ID do Destino: " + destinoId);
        System.out.println("ID do Guia: " + guiaId);
        System.out.println("ID do Cliente: " + clienteId);
    }
}
