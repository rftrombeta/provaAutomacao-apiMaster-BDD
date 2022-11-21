package testCases.utilitarios;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import testCases.utilitarios.model.SimulacaoModel;

public class Requests {

    private static Gson gson = new Gson();

    /**
     * Método responsável por realizar a consulta de restrição de CPF.
     * @param baseUri Base da Url utilizada
     * @param endpoint EndPoint a ser enviado na requisição
     * @return retorna o corpo da resposta da solicitação
     */
    public static ExtractableResponse methodGetConsultarRestricoes(String baseUri, String endpoint) {

        return RestAssured
                .given()
                    .baseUri(baseUri)
                    .log().all()
                .when()
                    .get(endpoint)
                .then()
                    .log().all()
                    .extract();
    }

    /**
     * Método responsável por realizar o envio de uma requisição POST.
     * @param simulacaoModel Model do Json a ser enviado
     * @param baseUri URL base a ser enviada a requisição
     * @return Retorna o corpo da resposta da solicitação
     */
    public static Response methodPostCriarSimulacao(SimulacaoModel simulacaoModel, String baseUri) {

        return RestAssured
            .given()
                .baseUri(baseUri)
                .log().all()
            .when()
                .body(gson.toJson(simulacaoModel))
                .post()
            .then()
                .log().all()
                .extract().response();
    }

    /**
     * Método responsável por realizar a consulta das simulacoes cadastradas.
     * @param baseUri Base da Url utilizada
     * @param endpoint EndPoint a ser enviado na requisição
     * @return retorna o corpo da resposta da solicitação
     */
    public static ExtractableResponse methodGetConsultarSimulacoesCadastradas(String baseUri, String endpoint) {

        return RestAssured
            .given()
                .baseUri(baseUri)
                .log().all()
            .when()
                .get(endpoint)
            .then()
                .log().all()
                .extract();
    }

    /**
     * Método responsável por realizar a exclusão de simulações.
     * @param baseUri Base da Url utilizada
     * @param endpoint EndPoint a ser enviado na requisição
     * @return retorna o corpo da resposta da solicitação
     */
    public static ExtractableResponse methodDeleteSimulacoes(String baseUri, String endpoint) {

        return RestAssured
            .given()
                .baseUri(baseUri)
                .log().all()
            .when()
                .delete(endpoint)
            .then()
                .log().all()
                .extract();
    }

    /**
     * Método responsável por realizar a alteração de simulações.
     * @param baseUri Base da Url utilizada
     * @param simulacaoModel Model do Json a ser enviado
     * @param endpoint EndPoint a ser enviado na requisição
     * @return retorna o corpo da resposta da solicitação
     */
    public static ExtractableResponse<?> methodAlterarSimulacoes(String baseUri, SimulacaoModel simulacaoModel, String endpoint) {

        return RestAssured
            .given()
                .baseUri(baseUri)
                .log().all()
            .when()
                .body(gson.toJson(simulacaoModel))
                .put(endpoint)
            .then()
                .log().all()
                .extract();
    }
}