package br.com.brb.ppe.service;

import br.com.brb.ppe.domain.dto.IdentificadorArquivoDTO;

import java.util.Set;

public interface DocumentoService {

    /**
     * TODO: implementar parâmetros
     */

    void confirmarRecebimentoArquivo(Set<IdentificadorArquivoDTO> listaIdentificadorArquivos);

    void obterArquivo(IdentificadorArquivoDTO identificadorArquivoDTO);

    void obterDocumento(String guidPedido);

}
