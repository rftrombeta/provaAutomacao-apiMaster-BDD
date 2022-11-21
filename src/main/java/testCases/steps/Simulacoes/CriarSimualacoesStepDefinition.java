package testCases.steps.Simulacoes;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.Assert;
import testCases.utilitarios.BaseTest;
import testCases.utilitarios.Requests;
import testCases.utilitarios.TiposDeServico;
import testCases.utilitarios.Uteis;

public class CriarSimualacoesStepDefinition extends BaseTest {

    @Before
    public void setUp() {

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        RestAssured.requestSpecification = reqBuilder.build();
    }

    @Dado("que possuimos todas as informacoes necessarias para criar uma simulacao")
    public void que_possuimos_todas_as_informacoes_necessarias_para_criar_uma_simulacao() {

        simulacaoModel = criarSimulacaoFactory.builCriarSimulacaoModel();
        cpf = simulacaoModel.getCpf();
    }

    @Dado("que possuimos um body com um cpf já utilizado para criar uma simulacao")
    public void quePossuimosUmBodyComUmCpfJáUtilizadoParaCriarUmaSimulacao() {

        extractableResponse = Requests.methodGetConsultarSimulacoesCadastradas(basePath, TiposDeServico.endPointCriarSimulacao);
        simulacaoModel = criarSimulacaoFactory.builCriarSimulacaoModel();
        simulacaoModel.setCpf(extractableResponse.body().jsonPath().get("cpf"));
    }

    @Dado("que possuimos um body com informacoes invalidas para criar uma simulacao")
    public void quePossuimosUmBodyComInformacoesInvalidasParaCriarUmaSimulacao() {

        simulacaoModel = criarSimulacaoFactory.builCriarSimulacaoModel();
        simulacaoModel.setEmail("");
    }

    @Quando("enviar a requisicao para criacao")
    public void enviar_a_requisicao_para_criacao() {

        response = Requests.methodPostCriarSimulacao(simulacaoModel, basePath + TiposDeServico.endPointCriarSimulacao);
    }

    @Entao("o endpoint deve retornar o statusCode {int}")
    public void oEndpointDeveRetornarOStatusCode(Integer statusCode) {

        Assert.assertEquals((int) statusCode, response.statusCode());
    }

    @Entao("o endpoint deve retornar o statusCode {int} e a mensagem {string}")
    public void oEndpointDeveRetornarOStatusCodeEAMensagem(Integer statusCode, String mensagem) {

        Assert.assertEquals((int) statusCode, response.statusCode());
        Assert.assertTrue(response.then().extract().body().jsonPath().get().toString().contains(mensagem));
    }

    @Entao("o endpoint deve retornar o statusCode {int} e uma lista com os erros encontrados")
    public void oEndpointDeveRetornarOStatusCodeEUmaListaComOsErrosEncontrados(Integer statusCode) {

        Assert.assertEquals((int) statusCode, response.statusCode());
        response.then().extract().body().jsonPath().get().toString().contains("erros");
    }
}
