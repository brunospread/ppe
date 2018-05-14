package br.com.brb.ppe.domain;

public class Documento {

    private Long id;

    private String nomeDocumento;

    private String tipoDocumento; // TODO: refatorar para enum

    private String contexto; // TODO: talvez refatorar para contexto

    private Long idChaveContexto;

}
