package org.template.framework.BackEnd.RestExecutor;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.template.framework.BackEnd.Logging.RestLogFilter;
import org.template.framework.BackEnd.RestRequest.RestReq;
import org.template.framework.Utility.Annotation.Author;

/*
For Rest Exe -> Using factory desing pattern, based on request method different api calls happen using switch case
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class RestExe {

    public static Response executeRestCall(RestReq request){

        if(request.isUseRelaxedHttpValidation()){
            RestAssured.useRelaxedHTTPSValidation();
        }

        RequestSpecification specification = RestAssured.given()
                .baseUri(request.getBaseUrl())
                .basePath(request.getBasePath())
                .headers(request.getHeaders())
                .queryParams(request.getQueryParams())
                .formParams(request.getFormParams())
                .filter(new RestLogFilter());

        if(request.getBody()!=null && !request.getBody().isBlank()){
            specification.body(request.getBody());
        }

        return switch (request.getMethod()){

            case GET -> specification.when().get().then().extract().response();
            case POST -> specification.when().post().then().extract().response();
            case PUT -> specification.when().put().then().extract().response();
            case PATCH -> specification.when().patch().then().extract().response();
            case DELETE -> specification.when().delete().then().extract().response();

        };
    }
}
