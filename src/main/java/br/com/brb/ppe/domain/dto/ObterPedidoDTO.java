package br.com.brb.ppe.domain.dto;

import br.com.brb.ppe.domain.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * DTO para trafegar os dados de obtenção de pedido
 *
 * pedido > obterPedido
 */
@Getter
@Setter
@NoArgsConstructor
public class ObterPedidoDTO {

    public Set<Pedido> pedidos;

}
