package trabalho_api_rest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FotosDeCapa {
    @Test
    public void BuscarTodasAsFotos(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void BuscarUmaFoto(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/29")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void AdicionarUmaFoto(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 30,\n" +
                        "  \"idBook\": 200,\n" +
                        "  \"url\": \"string\"\n" +
                        "}")
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void AtualizarUmaFotoExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 30,\n" +
                        "  \"idBook\": 200,\n" +
                        "  \"url\": \"string\"\n" +
                        "}")
                .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/30")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void ExcluirUmaFotoExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/33")
                .then()
                .log().all()
                .statusCode(200);
    }
}
