package trabalho_api_rest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Atividades {
    @Test
    public void BuscarTodasAsAtividades(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void BuscarUmaAtividadeExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities/6")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void AdicionarUmaAtividadeExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 15,\n" +
                        "  \"title\": \"qa\",\n" +
                        "  \"dueDate\": \"2022-11-11T12:48:33.131Z\",\n" +
                        "  \"completed\": true\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Activities")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void AtualizarUmaAtividadeExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 15,\n" +
                        "  \"title\": \"qa\",\n" +
                        "  \"dueDate\": \"2022-11-11T12:48:33.131Z\",\n" +
                        "  \"completed\": true\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Activities/15")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void DeletarUmaAtividadeExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Activities/16")
        .then()
                .log().all()
                .statusCode(200);

    }
}
