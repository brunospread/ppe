package br.com.brb.ppe.resource;

import br.com.brb.ppe.service.DocumentoService;
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
 * ----------------------
 * ENDPOINT DE DOCUMENTOS
 * ----------------------
 *
 * @author coint
 */
@RestController
@RequestMapping("/api/v1/documentos/")
public class DocumentoResource {

    @Autowired
    private DocumentoService documentoService;

    /**
     * -----------------------------
     * CONFIRMAR RECEBIMENTO ARQUIVO
     * -----------------------------
     */

    @RequestMapping(path = "/confirmarRecebimentoArquivo", method = RequestMethod.POST)
    @ApiOperation(value = "Confirmar recebimento de arquivo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Confirmação efetuado com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço."),
            @ApiResponse(code = 404, message = "Recurso não encontrado.")
    })
    public ModelAndView confirmarRebecimentoArquivo(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPedido",             required = false) String guidPedido,
            @RequestParam(value = "identificacaoDocumento", required = false) String identificacaoDocumento) {

        return null;
    }

    /**
     * -------------
     * OBTER ARQUIVO
     * -------------
     */
    @RequestMapping(path = "/obterArquivo", method = RequestMethod.GET)
    @ApiOperation(value = "Obter arquivo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Arquivo obtido com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço."),
            @ApiResponse(code = 404, message = "Recurso não encontrado.")
    })
    public ModelAndView obterArquivo(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPedido")             String guidPedido,
            @RequestParam(value = "identificacaoDocumento") String identificacaoDocumento) {

        return null;
    }

    /**
     * ---------------
     * OBTER DOCUMENTO
     * ---------------
     */
    @RequestMapping(path = "/obterDocumento", method = RequestMethod.GET)
    @ApiOperation(value = "Obter documento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Documento obtido com sucesso."),
            @ApiResponse(code = 400, message = "Erro na execução do serviço"),
            @ApiResponse(code = 404, message = "Recurso não encontrado")
    })
    public ModelAndView obterDocumento(
            ModelMap     modelMap,
            ModelAndView modelAndView,
            @RequestParam(value = "guidPedido") String guidPedido) {

        return null;
    }
}
