package model;

import java.util.Date;

public class Reserva {
    private int id;
    private int clienteId;
    private int pacoteId;
    private Date dataReserva;
    private int quantidadePessoas;
    private String status;
    private boolean pagamentoConfirmado;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public boolean isPagamentoConfirmado() {
    return pagamentoConfirmado;
}

    public void setPagamentoConfirmado(boolean pagamentoConfirmado) {
    this.pagamentoConfirmado = pagamentoConfirmado;
    if (pagamentoConfirmado) {
        this.status = "confirmado";
    } else {
        this.status = "aguardando pagamento";
    }
}

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getPacoteId() {
        return pacoteId;
    }

    public void setPacoteId(int pacoteId) {
        this.pacoteId = pacoteId;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
