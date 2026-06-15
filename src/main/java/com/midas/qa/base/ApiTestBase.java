package com.midas.qa.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class ApiTestBase {
    
    protected static RequestSpecification requestSpec;
    
    @BeforeSuite
    public void setupApiConfig() {
        // Base configuration for all API tests
        RestAssured.baseURI = "https://api.yourdomain.com";
        RestAssured.basePath = "/v1";
        
        // Common request specification
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer YOUR_ACCESS_TOKEN")
                .build();
    }
    
    // GET Request
    protected Response getRequest(String endpoint) {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .get(endpoint);
    }
    
    // GET Request with query parameters
    protected Response getRequestWithParams(String endpoint, String paramName, String paramValue) {
        return RestAssured.given()
                .spec(requestSpec)
                .queryParam(paramName, paramValue)
                .when()
                .get(endpoint);
    }
    
    // POST Request
    protected Response postRequest(String endpoint, Object body) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(endpoint);
    }
    
    // PUT Request
    protected Response putRequest(String endpoint, Object body) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .when()
                .put(endpoint);
    }
    
    // PATCH Request
    protected Response patchRequest(String endpoint, Object body) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .when()
                .patch(endpoint);
    }
    
    // DELETE Request
    protected Response deleteRequest(String endpoint) {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .delete(endpoint);
    }
    
    // DELETE Request with body
    protected Response deleteRequest(String endpoint, Object body) {
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .when()
                .delete(endpoint);
    }
    
    // HEAD Request
    protected Response headRequest(String endpoint) {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .head(endpoint);
    }
    
    // OPTIONS Request
    protected Response optionsRequest(String endpoint) {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .options(endpoint);
    }
    
    // Add common response validation methods
    protected void validateStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }
    
    protected void validateContentType(Response response, String contentType) {
        response.then().contentType(contentType);
    }
}