package trabalho_api_rest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Autores {
    @Test
    public void BuscarTodosOsAutores(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void BuscarUmAutorExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/22")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void BuscarAutoresExistentes(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/200")
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void AdicionarUmAutor(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 15,\n" +
                        "  \"idBook\": 200,\n" +
                        "  \"firstName\": \"sergio\",\n" +
                        "  \"lastName\": \"bezerra\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Authors")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void AtualizarUmAutorExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 15,\n" +
                        "  \"idBook\": 200,\n" +
                        "  \"firstName\": \"sérgio\",\n" +
                        "  \"lastName\": \"bezerra\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Authors/15")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void DeletarUmAutorExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Authors/22")
        .then()
                .log().all()
                .statusCode(200);
    }
}
