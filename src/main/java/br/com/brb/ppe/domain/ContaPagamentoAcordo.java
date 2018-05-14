package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContaPagamentoAcordo {

    private ContaBancaria contaBancaria;

    private ContaJudicial contaJudicial;

}
