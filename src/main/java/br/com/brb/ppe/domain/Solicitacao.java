package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Solicitacao {

    private String guidPedido;

    private Date dataInicial;

    private Date dataFinal;

    private Boolean status;

}
