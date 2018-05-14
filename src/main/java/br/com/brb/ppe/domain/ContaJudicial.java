package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ContaJudicial {

    private Integer banco;

    private String nomeBanco;

    private String identificadorDepositoJudicial;

    private Date dataValidade;

}
