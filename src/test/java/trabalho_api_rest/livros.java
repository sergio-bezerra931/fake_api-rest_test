package trabalho_api_rest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class livros {
    @Test
    public void BuscarTodosOsLivros(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Books")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void BuscarUmLivroExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Books/20")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void AdicionarUmLivroExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 205,\n" +
                        "  \"title\": \"qaic\",\n" +
                        "  \"description\": \"analista de teste\",\n" +
                        "  \"pageCount\": 200,\n" +
                        "  \"excerpt\": \"tecnologia\",\n" +
                        "  \"publishDate\": \"2022-11-11T14:27:21.091Z\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Books")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void AtualizarUmLivroExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 205,\n" +
                        "  \"title\": \"qaic\",\n" +
                        "  \"description\": \"analista de teste\",\n" +
                        "  \"pageCount\": 200,\n" +
                        "  \"excerpt\": \"tecnologia\",\n" +
                        "  \"publishDate\": \"2022-11-11T14:27:21.091Z\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Books/205")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void DeletarLivroExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Books/205")
        .then()
                .log().all()
                .statusCode(200);

    }
}
