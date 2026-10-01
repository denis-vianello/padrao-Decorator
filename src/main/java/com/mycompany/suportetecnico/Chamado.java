/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.suportetecnico;

/**
 *
 * @author PICHAU
 */

public interface Chamado {

    String getDescricao();

    String getEstado();

    void alterarEstado(String novoEstado);

    String getInformacoes();

    boolean possuiNotificacao();

    boolean possuiAuditoria();
}