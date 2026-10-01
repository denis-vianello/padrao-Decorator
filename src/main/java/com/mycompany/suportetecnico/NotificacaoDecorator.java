/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.suportetecnico;

/**
 *
 * @author PICHAU
 */
public class NotificacaoDecorator extends ChamadoDecorator {

    public NotificacaoDecorator(Chamado chamado) {
        super(chamado);
    }

    @Override
    public void alterarEstado(String novoEstado) {

        String estadoAnterior = chamado.getEstado();

        chamado.alterarEstado(novoEstado);

        System.out.println(
            "Notificacao: O chamado mudou de "
            + estadoAnterior + " para " + novoEstado
        );
    }

    @Override
    public String getInformacoes() {
        return chamado.getInformacoes()
                + "\nNotificacao: Ativada";
    }

    @Override
    public boolean possuiNotificacao() {
        return true;
    }

    @Override
    public boolean possuiAuditoria() {
        return chamado.possuiAuditoria();
    }
}
