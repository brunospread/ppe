package br.com.brb.ppe.service;

public interface PedidoService {

    /**
     * TODO: implementar par�metros
     */

    void obterPedido(String guidPedido, String identificadorDocumento);

    void confirmarRecebimentoPedido(String guidPedido, String identificadorDocumento);


}
