package testCases.utilitarios.factory;

import testCases.utilitarios.Uteis;
import testCases.utilitarios.model.SimulacaoModel;

public class CriarSimulacaoFactory {

    public SimulacaoModel builCriarSimulacaoModel() {

        return SimulacaoModel.builder()
                .nome(Uteis.geraNomes())
                .cpf(Uteis.geraCpf())
                .email(Uteis.geraEmail())
                .valor(Uteis.geraValor())
                .parcelas(Uteis.geraParcelas())
                .seguro(true)
                .build();
    }
}
