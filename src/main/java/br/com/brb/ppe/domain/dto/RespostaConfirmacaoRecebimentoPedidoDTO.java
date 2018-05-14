package br.com.brb.ppe.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para trafegar dados da confirmação do recebimento de pedido
 *
 * pedido > ConfirmarRecebimentoPedido
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class RespostaConfirmacaoRecebimentoPedidoDTO {

    private Long codigoRetorno;

    private String retorno; // TODO: refatorar para enum

    private String descricaoRetorno;

    private String guidPedido;
}
