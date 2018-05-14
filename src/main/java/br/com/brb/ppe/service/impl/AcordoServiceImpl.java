package br.com.brb.ppe.service.impl;

import br.com.brb.ppe.domain.Pagamento;
import br.com.brb.ppe.domain.dto.CadastrarResultadoPedidoDTO;
import br.com.brb.ppe.repository.AcordoRepository;
import br.com.brb.ppe.service.AcordoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AcordoServiceImpl implements AcordoService {
    
    @Override
    public void cadastrarResultadoAnalisePedido(CadastrarResultadoPedidoDTO analisePedido) {

    }

    @Override
    public void informarPagamento(Pagamento pagamento) {

    }

    @Override
    public void obterRespostaProposta(Date dataInicio, Date dataFim, String guidPedido) {

    }
}
