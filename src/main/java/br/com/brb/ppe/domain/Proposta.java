package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class Proposta {

    private String  identificadorPropostaBanco;

    private Double  valorTotalAcordo;

    private Double  valorPoupador;

    private Double  valorHonorariosAdvogado;

    private Double  valorHonorariosFebrapo;

    private Double  valorReembolsoCustas;

    private Integer quantidadeParcelas;

    private Double  valorParcela;

    private Date    dataPrimeiraParcela;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta = (Proposta) o;
        return Objects.equals(identificadorPropostaBanco, proposta.identificadorPropostaBanco);
    }

    @Override
    public int hashCode() {

        return Objects.hash(identificadorPropostaBanco);
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "identificadorPropostaBanco='" + identificadorPropostaBanco + '\'' +
                ", valorTotalAcordo=" + valorTotalAcordo +
                ", valorPoupador=" + valorPoupador +
                ", valorHonorariosAdvogado=" + valorHonorariosAdvogado +
                ", valorHonorariosFebrapo=" + valorHonorariosFebrapo +
                ", valorReembolsoCustas=" + valorReembolsoCustas +
                ", quantidadeParcelas=" + quantidadeParcelas +
                ", valorParcela=" + valorParcela +
                ", dataPrimeiraParcela=" + dataPrimeiraParcela +
                '}';
    }
}
