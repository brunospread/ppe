package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class DemonstrativoCalculo {

    private String guidPedido;

    private String identificadorDocumento;

    private String nomeArquivo;

    private String conteudo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemonstrativoCalculo that = (DemonstrativoCalculo) o;
        return Objects.equals(guidPedido, that.guidPedido);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guidPedido);
    }
}
