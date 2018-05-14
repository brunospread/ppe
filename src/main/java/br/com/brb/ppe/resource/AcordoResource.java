package br.com.brb.ppe.resource;

import br.com.brb.ppe.domain.DemonstrativoCalculo;
import br.com.brb.ppe.domain.Proposta;
import br.com.brb.ppe.service.AcordoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * -------------------
 * ENDPOINT DE ACORDOS
 * -------------------
 *
 * @author coint
 */
@RestController
@RequestMapping("/api/v1/acordos/")
public class AcordoResource {

    @Autowired
    private AcordoService acordoService;

    /**
     * ----------------------------------
     * CADASTRAR RESULTADO ANÁLISE PEDIDO
     * ----------------------------------
     */
    @RequestMapping(value = "/cadastrarResultadoAnalisePedido", method = RequestMethod.POST)
    @ApiOperation(value = "Cadastrar resultado análise pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cadastro efetuado com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço."),
            @ApiResponse(code = 404, message = "Recurso não encontrado.")
    })
    public ModelAndView cadastrarResultadoAnalisePedido(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPedido",            required = false) String   guidPedido,
            @RequestParam(value = "resultado",             required = false) String   resultado,
            @RequestParam(value = "motivoRecusaPedido",    required = false) String   motivoRecusaPedido,
            @RequestParam(value = "subMotivoRecusaPedido", required = false) String   subMotivoRecusaPedido,
            @RequestParam(value = "proposta",              required = false) Proposta proposta,
            @RequestParam(value = "dataAnalise",           required = false) String   dataProposta,
            @RequestParam(value = "observacoes",           required = false) String   observacao,
            @RequestParam(value = "demonstrativoCalculo",  required = false) String   demonstrativoCalculo) {

        return null;
    }

    /**
     * ------------------
     * INFORMAR PAGAMENTO
     * ------------------
     */
    @RequestMapping(value = "/informarPagamento", method = RequestMethod.POST)
    @ApiOperation(value = "Informar pagamento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Pagamento informado com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço."),
            @ApiResponse(code = 404, message = "Recurso não encontrado.")
    })
    public ModelAndView informarPagamento(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPagamento",              required = false) String  guidPagamento,
            @RequestParam(value = "identificadorPropostaBanco", required = false) String  identificadorPropostaBanco,
            @RequestParam(value = "statusPagamento",            required = false) String  statusPagamento,
            @RequestParam(value = "dataPagamento",              required = false) String  dataPagamento,
            @RequestParam(value = "valorPagamento",             required = false) Double  valorPagamento,
            @RequestParam(value = "numeroParcela",              required = false) Integer numeroParcela,
            @RequestParam(value = "comprovante",                required = false) String  comprovante,
            @RequestParam(value = "observacoesPagamento",       required = false) String  observacoesPagamento,
            @RequestParam(value = "contaPagamentoAcordo",       required = false) String  nomePagamentoAcordo) {

        return null;
    }

    /**
     * -----------------------
     * OBTER RESPOSTA PROPOSTA
     * -----------------------
     */
    @RequestMapping(value = "/obterRespostaProposta", method = RequestMethod.GET)
    @ApiOperation(value = "Obter resposta proposta")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resposta da proposta obtida com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço."),
            @ApiResponse(code = 404, message = "Recurso não encontrado.")
    })
    public ModelAndView obterRespostaProposta(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPedido", required = false) String guidPedido,
            @RequestParam(value = "dataInicio", required = false) String dataInicio,
            @RequestParam(value = "dataFim",    required = false) String dataFim) {

        return null;
    }
}
