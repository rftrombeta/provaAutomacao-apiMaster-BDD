package testCases.steps.consultaRestricoes;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import testCases.utilitarios.BaseTest;
import testCases.utilitarios.Requests;
import testCases.utilitarios.TiposDeServico;
import testCases.utilitarios.Uteis;

public class consultaRestricoesStepDefinition extends BaseTest {

    @Dado("^que possuimos um cpf com restricao$")
    public void quePossuimosUmCpfComRestricao() {

        cpf = Uteis.selecionaCpfComRestricaoAleatorio();
        endPoint = TiposDeServico.endPointConsultaRestricao + cpf;
    }

    @Dado("que possuimos um cpf sem restricao")
    public void quePossuimosUmCpfSemRestricao() {

        cpf = Uteis.geraCpf();
        endPoint = TiposDeServico.endPointConsultaRestricao + cpf;
    }

    @Dado("que possuimos o cpf {string}")
    public void quePossuimosOCpf(String cpfParaConsulta) {

        cpf = cpfParaConsulta;
        endPoint = TiposDeServico.endPointConsultaRestricao + cpf;
    }

    @Quando("^enviar a requisicao para validacao$")
    public void enviarARequisicaoParaValidacao() {

        extractableResponse = Requests.methodGetConsultarRestricoes(basePath, endPoint);
    }

    @Entao("o endpoint deve retornar o status {int} e a mensagem {string}")
    public void oEndpointDeveRetornarOStatusEAMensagem(Integer statusCode, String mensagem) {

        Assert.assertEquals((int) statusCode, extractableResponse.statusCode());

        mensagem = mensagem.replace("numeroCpf", cpf);
        Assert.assertTrue(mensagem.contains(extractableResponse.path("mensagem")));

    }

    @Entao("o endpoint deve retornar o status {int}")
    public void oEndpointDeveRetornarOStatus(Integer statusCode) {

        Assert.assertEquals((int) statusCode, extractableResponse.statusCode());
    }

    @Entao("o endpoint deve retornar o status {int} e a mensagem de restricao caso haja {string}")
    public void oEndpointDeveRetornarOStatusEAMensagemDeRestricaoCasoHaja(Integer statusCode, String mensagem) {

        Assert.assertEquals((int) statusCode, extractableResponse.statusCode());

        if (statusCode == 200) {

            mensagem = mensagem.replace("numeroCpf", cpf);
            Assert.assertTrue(mensagem.contains(extractableResponse.path("mensagem")));
        }
    }
}
