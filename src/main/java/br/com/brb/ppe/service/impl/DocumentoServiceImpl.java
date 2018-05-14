package br.com.brb.ppe.service.impl;

import br.com.brb.ppe.domain.dto.IdentificadorArquivoDTO;
import br.com.brb.ppe.service.DocumentoService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Override
    public void confirmarRecebimentoArquivo(Set<IdentificadorArquivoDTO> listaIdentificadorArquivos) {

    }

    @Override
    public void obterArquivo(IdentificadorArquivoDTO identificadorArquivoDTO) {

    }

    @Override
    public void obterDocumento(String guidPedido) {

    }
}
