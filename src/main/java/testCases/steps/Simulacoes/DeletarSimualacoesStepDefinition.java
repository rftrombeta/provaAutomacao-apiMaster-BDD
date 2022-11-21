package testCases.steps.Simulacoes;

import io.cucumber.java.pt.Quando;
import testCases.utilitarios.BaseTest;
import testCases.utilitarios.Requests;
import testCases.utilitarios.TiposDeServico;

public class DeletarSimualacoesStepDefinition extends BaseTest {

    @Quando("enviar a requisicao para deletar a simulacao")
    public void enviarARequisicaoParaDeletarASimulacao() {

        String id = "/12";
        extractableResponse = Requests.methodDeleteSimulacoes(basePath, TiposDeServico.endPointCriarSimulacao + id);
    }
}
