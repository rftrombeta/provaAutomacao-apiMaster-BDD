package testCases.utilitarios;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;

public class Requests {

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
}