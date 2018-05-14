package br.com.brb.ppe.domain;

import java.util.Date;

public class Processo {

    private Long id;

    private String numeroProcessoCNJ;

    private String numeroProcessoAntigo;

    private Long identificadorProcessoSistemaLegado; // TODO: verificar tipo

    private String orgaoLegal; // TODO: refatorar para enum

    private String tipoAcao; // TODO: refatorar para enum;

    private String varaDeOrigem; // TODO: verificar tipo

    private String comarcaDeOrigem;

    private String uf; // TODO: refatorar para enum;

    private Date ajuizadoEm;

    private Date dataProcuracao;

    private String instituicaoNome;

}
