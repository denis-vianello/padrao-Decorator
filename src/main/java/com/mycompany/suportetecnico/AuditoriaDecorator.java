/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.suportetecnico;

/**
 *
 * @author PICHAU
 */
public class AuditoriaDecorator extends ChamadoDecorator {

    public AuditoriaDecorator(Chamado chamado) {
        super(chamado);
    }

    @Override
    public void alterarEstado(String novoEstado) {

        String estadoAnterior = chamado.getEstado();

        chamado.alterarEstado(novoEstado);

        System.out.println(
            "Auditoria: Estado alterado de "
            + estadoAnterior + " para " + novoEstado
        );
    }

    @Override
    public String getInformacoes() {
        return chamado.getInformacoes()
                + "\nAuditoria: Ativada";
    }

    @Override
    public boolean possuiNotificacao() {
        return chamado.possuiNotificacao();
    }

    @Override
    public boolean possuiAuditoria() {
        return true;
    }
}