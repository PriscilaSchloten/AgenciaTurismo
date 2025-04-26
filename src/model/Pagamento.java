package model;

import java.util.Date;

/**
 * @author pris
 */
public class Pagamento {
  private int pkPagamento;
  private String titulo;
  private String descricao;
  private String destino;
  private double valor;
  private String telefone;
  private Date dataInicio;
  private Date dataFim;
  private int guia_id;
  private int cliente_id;

  public Pagamento(){};
  
  public Pagamento(int pkPagamento, String titulo, String descricao, String destino, double valor, String telefone, Date dataInicio, Date dataFim, int guia_id, int cliente_id) {
    this.pkPagamento = pkPagamento;
    this.titulo = titulo;
    this.descricao = descricao;
    this.destino = destino;
    this.valor = valor;
    this.telefone = telefone;
    this.dataInicio = dataInicio;
    this.guia_id = guia_id;
    this.cliente_id = cliente_id;
  }
  
      public int getCliente_id() {
    return cliente_id;
  }

  public void setCliente_id(int cliente_id) {
    this.cliente_id = cliente_id;
  }
  
    public int getGuia_id() {
    return guia_id;
  }

  public void setGuia_id(int guia_id) {
    this.guia_id = guia_id;
  }

  public int getpkPagamento() {
    return pkPagamento;
  }

  public void setpkPagamento(int pkPagamento) {
    this.pkPagamento = pkPagamento;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }
  
  public double getValor() {
    return valor;
  }

  public void setValor (double valor) {
    this.valor = valor;
  }
  
  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }
  
  public Date getDataFim() {
    return dataFim;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }
}
