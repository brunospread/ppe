package br.com.brb.ppe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Conta {

    private Long id;

    private String nomeTitular;

    private String cpfCnpj;

    private String banco;

    private String nomeBanco;

    private String agencia;

    private String agenciaDV;

    private String numeroConta;

    private String numeroContaDV;

    private String tipoConta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", banco='" + banco + '\'' +
                ", nomeBanco='" + nomeBanco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", agenciaDV='" + agenciaDV + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                ", numeroContaDV='" + numeroContaDV + '\'' +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }
}
