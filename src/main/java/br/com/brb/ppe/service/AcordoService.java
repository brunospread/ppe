package br.com.brb.ppe.service;

import br.com.brb.ppe.domain.Pagamento;
import br.com.brb.ppe.domain.dto.CadastrarResultadoPedidoDTO;

import java.util.Date;

public interface AcordoService {

    void cadastrarResultadoAnalisePedido(CadastrarResultadoPedidoDTO analisePedido);

    void informarPagamento(Pagamento pagamento);

    void obterRespostaProposta(Date dataInicio, Date dataFim, String guidPedido);

}
