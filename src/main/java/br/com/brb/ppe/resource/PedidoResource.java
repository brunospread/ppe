package br.com.brb.ppe.resource;

import br.com.brb.ppe.service.PedidoService;
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
 * ENDPOINT DE PEDIDOS
 * -------------------
 *
 * @author coint
 */
@RestController
@RequestMapping("/api/v1/pedidos/")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    /**
     * ------------
     * OBTER PEDIDO
     * ------------
     */
    @RequestMapping(path = "/obterPedido", method = RequestMethod.GET)
    @ApiOperation(value = "Obter pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Consulta efetuada com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço."),
            @ApiResponse(code = 404, message = "Recurso não encontrado.")
    })
    public ModelAndView obterPedido(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPedido",             required = true) String guidPedido,
            @RequestParam(value = "identificadorDocumento", required = true) String identificadorDocumento) {

        return null;
    }

    /**
     * ----------------------------
     * CONFIRMAR RECEBIMENTO PEDIDO
     * ----------------------------
     */
    @RequestMapping(path = "/confirmarRecebimentoPedido", method = RequestMethod.GET)
    @ApiOperation(value = "Confirmar recebimento do pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Consulta efetuada com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço."),
            @ApiResponse(code = 404, message = "Recurso não encontrado.")
    })
    public ModelAndView confirmarRecebimentoPedido(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPedido",             required = true) String guidPedido,
            @RequestParam(value = "identificadorDocumento", required = true) String identificadorDocumento) {

        return null;
    }
}
