package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO verificar entidade
@Getter
@Setter
@NoArgsConstructor
public class ContaPlano extends Conta {

    private Plano plano; // TODO: refatorar Plano para enum

    private Double saldoBase;

    private Double valorSimulado;

    private Integer diaAniversarioConta;

    private Habilitacao habilitacao; // TODO: refatorar (PedidoEmOutrasHabilitacoes) -> pode ser uma coleção


}
