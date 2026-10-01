/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.suportetecnico;

/**
 *
 * @author PICHAU
 */
public abstract class ChamadoDecorator implements Chamado {

    protected Chamado chamado;

    public ChamadoDecorator(Chamado chamado) {
        this.chamado = chamado;
    }

    @Override
    public String getDescricao() {
        return chamado.getDescricao();
    }

    @Override
    public String getEstado() {
        return chamado.getEstado();
    }

    @Override
    public void alterarEstado(String novoEstado) {
        chamado.alterarEstado(novoEstado);
    }

    @Override
    public String getInformacoes() {
        return chamado.getInformacoes();
    }

    @Override
    public boolean possuiNotificacao() {
        return chamado.possuiNotificacao();
    }

    @Override
    public boolean possuiAuditoria() {
        return chamado.possuiAuditoria();
    }
}
