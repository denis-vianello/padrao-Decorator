package test;

import com.mycompany.suportetecnico.AuditoriaDecorator;
import com.mycompany.suportetecnico.Chamado;
import com.mycompany.suportetecnico.ChamadoConcreto;
import com.mycompany.suportetecnico.NotificacaoDecorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChamadoTest {

    @Test
    void deveRetornarDescricaoChamado() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        assertEquals("Computador não liga", chamado.getDescricao());
    }

    @Test
    void deveIniciarChamadoNoEstadoAberto() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        assertEquals("ABERTO", chamado.getEstado());
    }

    @Test
    void deveAlterarEstadoDoChamado() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        chamado.alterarEstado("EM_ANALISE");

        assertEquals("EM_ANALISE", chamado.getEstado());
    }

    @Test
    void chamadoSemDecoratorsNaoPossuiNotificacao() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        assertFalse(chamado.possuiNotificacao());
    }

    @Test
    void chamadoSemDecoratorsNaoPossuiAuditoria() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        assertFalse(chamado.possuiAuditoria());
    }

    @Test
    void notificacaoDecoratorAdicionaNotificacao() {
        Chamado chamado = new NotificacaoDecorator(
            new ChamadoConcreto("Computador não liga")
        );

        assertTrue(chamado.possuiNotificacao());
        assertFalse(chamado.possuiAuditoria());
    }

    @Test
    void auditoriaDecoratorAdicionaAuditoria() {
        Chamado chamado = new AuditoriaDecorator(
            new ChamadoConcreto("Computador não liga")
        );

        assertFalse(chamado.possuiNotificacao());
        assertTrue(chamado.possuiAuditoria());
    }

    @Test
    void devePermitirCombinarDecorators() {
        Chamado chamado = new AuditoriaDecorator(
            new NotificacaoDecorator(
                new ChamadoConcreto("Computador não liga")
            )
        );

        assertTrue(chamado.possuiNotificacao());
        assertTrue(chamado.possuiAuditoria());
    }

    @Test
    void devePermitirTransicoesValidasDeEstado() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        chamado.alterarEstado("EM_ANALISE");
        assertEquals("EM_ANALISE", chamado.getEstado());

        chamado.alterarEstado("EM_ATENDIMENTO");
        assertEquals("EM_ATENDIMENTO", chamado.getEstado());

        chamado.alterarEstado("AGUARDANDO");
        assertEquals("AGUARDANDO", chamado.getEstado());

        chamado.alterarEstado("EM_ATENDIMENTO");
        assertEquals("EM_ATENDIMENTO", chamado.getEstado());

        chamado.alterarEstado("RESOLVIDO");
        assertEquals("RESOLVIDO", chamado.getEstado());

        chamado.alterarEstado("FECHADO");
        assertEquals("FECHADO", chamado.getEstado());
    }

    @Test
    void devePermitirReabrirChamadoResolvido() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        chamado.alterarEstado("EM_ANALISE");
        chamado.alterarEstado("EM_ATENDIMENTO");
        chamado.alterarEstado("RESOLVIDO");
        chamado.alterarEstado("EM_ATENDIMENTO");

        assertEquals("EM_ATENDIMENTO", chamado.getEstado());
    }

    @Test
    void deveLancarExcecaoParaTransicaoInvalida() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        assertThrows(
            IllegalStateException.class,
            () -> chamado.alterarEstado("FECHADO")
        );
    }

    @Test
    void deveManterEstadoQuandoTransicaoForInvalida() {
        Chamado chamado = new ChamadoConcreto("Computador não liga");

        assertThrows(
            IllegalStateException.class,
            () -> chamado.alterarEstado("FECHADO")
        );

        assertEquals("ABERTO", chamado.getEstado());
    }

    @Test
    void decoratorsDevemManterComportamentoDoChamado() {
        Chamado chamado = new AuditoriaDecorator(
            new NotificacaoDecorator(
                new ChamadoConcreto("Computador não liga")
            )
        );

        chamado.alterarEstado("EM_ANALISE");

        assertEquals("EM_ANALISE", chamado.getEstado());
        assertTrue(chamado.possuiNotificacao());
        assertTrue(chamado.possuiAuditoria());
    }
}