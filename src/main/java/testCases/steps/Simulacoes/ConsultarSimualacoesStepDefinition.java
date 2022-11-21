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

public class ConsultarSimualacoesStepDefinition extends BaseTest {

    @Before
    public void setUp() {

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        RestAssured.requestSpecification = reqBuilder.build();
    }

    @Dado("que possua um CPF com simulacao realizada")
    public void quePossuaUmCPFComSimulacaoRealizada() {

        cpf = "75868840054";
    }

    @Dado("que possua um CPF sem simulacao realizada")
    public void quePossuaUmCPFSemSimulacaoRealizada() {

        cpf = "05097373901";
    }

    @Quando("enviar a requisicao para consultar o CPF")
    public void enviarARequisicaoParaConsultarOCPF() {

        extractableResponse = Requests.methodGetConsultarSimulacoesCadastradas(basePath, TiposDeServico.endPointCriarSimulacao + "/" + cpf);
    }

    @Quando("enviar a requisicao para consultar")
    public void enviarARequisicaoParaConsultar() {

        extractableResponse = Requests.methodGetConsultarSimulacoesCadastradas(basePath, TiposDeServico.endPointCriarSimulacao);
    }

    @Entao("o endpoint deve retornar o statusCode {int} e uma lista com as simulacoes cadastradas")
    public void oEndpointDeveRetornarOStatusCodeEUmaListaComAsSimulacoesCadastradas(Integer statusCode) {

        Assert.assertEquals((int) statusCode, extractableResponse.statusCode());
        Assert.assertNotNull(extractableResponse.body().jsonPath().get());
    }

    @Entao("o endpoint deve retornar o statusCode {int} e as informacoes da simulacao")
    public void oEndpointDeveRetornarOStatusCodeEAsInformacoesDaSimulacao(Integer statusCode) {

        Assert.assertEquals((int) statusCode, extractableResponse.statusCode());
        Assert.assertNotNull(extractableResponse.body().jsonPath().get());
    }
}
