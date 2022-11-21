package testCases.utilitarios;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import testCases.utilitarios.factory.CriarSimulacaoFactory;
import testCases.utilitarios.model.SimulacaoModel;

public class BaseTest {

    public static String basePath;
    public static String endPoint;
    public static String cpf;
    public static ExtractableResponse extractableResponse;
    public static Response response;
    public static SimulacaoModel simulacaoModel = new SimulacaoModel();
    public CriarSimulacaoFactory criarSimulacaoFactory = new CriarSimulacaoFactory();
}
