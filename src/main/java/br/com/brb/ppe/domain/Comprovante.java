package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Comprovante {

    private String guidPedido;

    private String identificadorPagamento;

    private String nomeArquivo;

    private String conteudo;

}
