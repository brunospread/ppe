package br.com.brb.ppe.domain;

// TODO verificar entidade
public class ContaPlano extends Conta {

    private Long id;

    private Plano plano; // TODO: refatorar Plano para enum

    private Double saldoBase;

    private Double valorSimulado;

    private Integer diaAniversarioConta;

    private Habilitacao habilitacao; // TODO: refatorar (PedidoEmOutrasHabilitacoes) -> pode ser uma coleção


}
