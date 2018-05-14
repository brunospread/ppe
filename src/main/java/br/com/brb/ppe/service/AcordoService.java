package br.com.brb.ppe.service;

import br.com.brb.ppe.domain.dto.CadastrarResultadoPedidoDTO;

public interface AcordoService {

    /**
     * TODO: implementar parâmetros
     */

    void cadastrarResultadoAnalisePedido(CadastrarResultadoPedidoDTO analisePedido);

    void informarPagamento();

    void obterRespostaProposta();
}
