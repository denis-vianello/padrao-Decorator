/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.suportetecnico;

/**
 *
 * @author PICHAU
 */
public class ChamadoConcreto implements Chamado {

    private String descricao;
    private String estado;

    public ChamadoConcreto(String descricao) {
        this.descricao = descricao;
        this.estado = "ABERTO";
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public void alterarEstado(String novoEstado) {

        if (estado.equals("ABERTO") && novoEstado.equals("EM_ANALISE")) {
            estado = novoEstado;
        } 
        else if (estado.equals("EM_ANALISE") && novoEstado.equals("EM_ATENDIMENTO")) {
            estado = novoEstado;
        } 
        else if (estado.equals("EM_ATENDIMENTO") && novoEstado.equals("AGUARDANDO")) {
            estado = novoEstado;
        } 
        else if (estado.equals("AGUARDANDO") && novoEstado.equals("EM_ATENDIMENTO")) {
            estado = novoEstado;
        } 
        else if (estado.equals("EM_ATENDIMENTO") && novoEstado.equals("RESOLVIDO")) {
            estado = novoEstado;
        } 
        else if (estado.equals("RESOLVIDO") && novoEstado.equals("FECHADO")) {
            estado = novoEstado;
        } 
        else if (estado.equals("RESOLVIDO") && novoEstado.equals("EM_ATENDIMENTO")) {
            estado = novoEstado;
        } 
        else {
            throw new IllegalStateException(
                "Transicao invalida: " + estado + " -> " + novoEstado
            );
        }
    }

    @Override
    public String getInformacoes() {
        return "Descricao: " + descricao + "\nEstado: " + estado;
    }

    @Override
    public boolean possuiNotificacao() {
        return false;
    }

    @Override
    public boolean possuiAuditoria() {
        return false;
    }
}