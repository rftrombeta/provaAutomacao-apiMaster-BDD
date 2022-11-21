package testCases.steps.Simulacoes;

import io.cucumber.java.pt.Quando;
import testCases.utilitarios.BaseTest;
import testCases.utilitarios.Requests;
import testCases.utilitarios.TiposDeServico;

public class AlterarSimualacoesStepDefinition extends BaseTest {

    @Quando("enviar a requisicao para alterar a simulacao")
    public void enviarARequisicaoParaAlterarASimulacao() {

        cpf = simulacaoModel.getCpf();
        simulacaoModel = criarSimulacaoFactory.builCriarSimulacaoModel();
        extractableResponse = Requests.methodAlterarSimulacoes(basePath, simulacaoModel,TiposDeServico.endPointCriarSimulacao + "/" + cpf);
    }
}
