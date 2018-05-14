package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Pedido {

    private String guidPedido;

    private String protocolo;

    private Integer identificadorLoteHabilitacao;

    private Date dataAbertura;

    private String statusPedido;

    private Double valorCustasProcessuais;

    private Date dataConfirmacaoLeituraBanco;

    private Double valorTotalSimulado;

    private String destinatarioPagamentoAcordo;

    private Poupador poupador;

    private Set<EnvolvidoEspolio> envolvidosEspolio;

    private Patrono patrono;

    private ContaPagamentoAcordo contaPagamentoAcordo;

    private ContaPagamentoHonorario contaPagamentoHonorario;

    private Processo processo;

    private Set<ContaContemplada> contasContempladas;

    private Set<Documento> documentos;

    private ResultadoBPO resultadoBPO;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(guidPedido, pedido.guidPedido);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guidPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "guidPedido='" + guidPedido + '\'' +
                ", protocolo='" + protocolo + '\'' +
                ", identificadorLoteHabilitacao=" + identificadorLoteHabilitacao +
                ", dataAbertura=" + dataAbertura +
                ", statusPedido='" + statusPedido + '\'' +
                ", valorCustasProcessuais=" + valorCustasProcessuais +
                ", dataConfirmacaoLeituraBanco=" + dataConfirmacaoLeituraBanco +
                ", valorTotalSimulado=" + valorTotalSimulado +
                ", destinatarioPagamentoAcordo='" + destinatarioPagamentoAcordo + '\'' +
                ", poupador=" + poupador +
                ", envolvidosEspolio=" + envolvidosEspolio +
                ", patrono=" + patrono +
                ", contaPagamentoAcordo=" + contaPagamentoAcordo +
                ", contaPagamentoHonorario=" + contaPagamentoHonorario +
                ", processo=" + processo +
                ", contasContempladas=" + contasContempladas +
                ", documentos=" + documentos +
                ", resultadoBPO=" + resultadoBPO +
                '}';
    }
}
