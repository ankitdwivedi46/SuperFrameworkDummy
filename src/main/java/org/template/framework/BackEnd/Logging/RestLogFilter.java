package org.template.framework.BackEnd.Logging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class RestLogFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestLogFilter.class);
    private FilterableRequestSpecification requestSpec;
    private FilterableResponseSpecification responseSpec;
    private StringBuilder api;
    private StringBuilder req;
    private StringBuilder resp;
    private FilterContext ctx;

    private Response printStep(String path) {
        this.api = new StringBuilder();
        this.req = new StringBuilder();
        this.resp = new StringBuilder();
        this.logBuilder(this.api, "API : " + this.requestSpec.getBaseUri() + path);
        this.logRequest();
        Response response = this.ctx.next(this.requestSpec, this.responseSpec);
        this.logResponse(response);
        String fullLog = this.api.toString() + this.req + this.resp;
        LOGGER.info("{}", fullLog);
        return response;
    }

    private void logBuilder(StringBuilder obj, String input){
        obj.append(input);
        obj.append(System.lineSeparator());
    }

    private void logRequest(){
        this.requestSpec.getHeaders().asList().forEach(header -> this.logBuilder(this.req,"[REQUEST HEADER] Header Name : "+ header.getName() +" ------> Header Value : " + header.getValue()));
        this.requestSpec.getQueryParams().forEach((k,v) -> this.logBuilder(this.req,"[REQUEST QUERY PARAM] Query Param Name : "+ k +" ------> Query Param Value : " + v));
        this.requestSpec.getFormParams().forEach((k,v) -> this.logBuilder(this.req,"[REQUEST FORM PARAM] Form Param Name : "+ k +" ------> Form Param Value : " + v));
        if(this.requestSpec.getBody()!=null){
            try{
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String prettyString = gson.toJson(JsonParser.parseString((String)this.requestSpec.getBody()));
                this.logBuilder(this.req, "[REQUEST BODY] Request Body JSON : "+prettyString);
            } catch (Exception e) {
                this.logBuilder(this.req, "Error occurred while logging request");
                LOGGER.error("Error occurred while logging request", (Throwable)e);
            }
        }
    }

    private void logResponse(Response response) {
        this.logBuilder(this.resp, "[RESPONSE BODY] Statuc Code : " + response.statusCode());
        this.logBuilder(this.resp, "[RESPONSE BODY] Response Time : " + response.time() +" millseconds");
        String responseString = "";
        try {
            if(response.contentType().contains("text/html")){
                this.logBuilder(this.resp, "[RESPONSE BODY] : " + "");
            }else{
                responseString = response.jsonPath().prettify();
                this.logBuilder(this.resp, "[RESPONSE BODY] : " + responseString);
            }
        }
        catch (Exception var5) {
            LOGGER.error("ERROR in generating prettyJson", (Object)var5.getMessage());
            this.logBuilder(this.resp, "[RESPONSE]: " + response.body().asString());
        }
        response.headers().asList().forEach(header -> this.logBuilder(this.resp, "[RESPONSE BODY] Header Name : " + header.getName() + " ------> Header Value : " + header.getValue()));
    }

    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        this.requestSpec = filterableRequestSpecification;
        this.responseSpec = filterableResponseSpecification;
        this.ctx = filterContext;
        String endpoint = this.requestSpec.getBasePath();
        Response response = this.printStep(endpoint);
        return response;
    }
}
