package br.com.brb.ppe.domain.dto;

import br.com.brb.ppe.domain.Pagamento;
import br.com.brb.ppe.domain.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InformarPagamentoDTO {

    private Pagamento pagamento;

}
