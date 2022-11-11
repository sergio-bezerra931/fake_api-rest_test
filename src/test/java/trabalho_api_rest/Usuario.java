package trabalho_api_rest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Usuario {
    @Test
    public void BuscarTodosUsuarios(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Users")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void BuscarUmUsuarioExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Users/10")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void AdicionarUmUsuario(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 8,\n" +
                        "  \"userName\": \"sergio\",\n" +
                        "  \"password\": \"123456789\"\n" +
                        "}")
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Users")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void AtualizarUmUsuario(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 9,\n" +
                        "  \"userName\": \"izabel\",\n" +
                        "  \"password\": \"12345\"\n" +
                        "}")
                .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Users/9")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void DeletarUmUsuario(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Users/1")
                .then()
                .log().all()
                .statusCode(200);
    }
}
