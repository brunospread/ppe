package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Pagamento {

    private String guidPedido;

    private String identificadorPropostaBanco;

    private String statusPagamento; // TODO: verificar tipo

    private Date dataPagamento;

    private Double valorPagamento;

    private Integer numeroParcela;

    private Comprovante comprovante;

    private String observacaoPagamento;

    private ContaPagamentoAcordo contaPagamentoAcordo;

}
