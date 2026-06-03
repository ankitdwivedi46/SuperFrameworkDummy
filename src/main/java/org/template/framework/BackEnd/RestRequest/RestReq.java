package org.template.framework.BackEnd.RestRequest;

import lombok.Data;
import org.template.framework.BackEnd.Enums.RestMethods;
import org.template.framework.Utility.Annotation.Author;
import java.util.*;

/*
For Rest Req -> Using Builder Design Pattern
when Using builder object can set all the Rest Req Params including body, header, basepath etc
and this builder object will be used to assign data to Rest Req variables
Using Lomobk(@Data) for ApiReq getter and setter
 */

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
@Data
public final class RestReq {

    private String baseUrl;
    private String basePath;
    private String body;
    private RestMethods method;
    private Map<String,String> headers;
    private Map<String,String> queryParams;
    private Map<String,String> formParams;
    private boolean useRelaxedHttpValidation;

    public RestReq(Builder builder){
        this.baseUrl = Objects.requireNonNull(builder.baseUrl,"Base Url is mandatory for Api Execution");
        this.basePath = Objects.requireNonNull(builder.basePath,"Base Path is mandatory for Api Execution");
        this.method = Objects.requireNonNull(builder.method,"Method is mandatory for Api Execution");
        this.headers = Collections.unmodifiableMap(new LinkedHashMap<>(builder.headers));
        this.queryParams = Collections.unmodifiableMap(new LinkedHashMap<>(builder.queryParams));
        this.formParams = Collections.unmodifiableMap(new LinkedHashMap<>(builder.formParams));
        this.body = builder.body;
        this.useRelaxedHttpValidation = builder.useRelaxedHttpValidation;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{

        private String baseUrl = "";
        private String basePath = "";
        private String body = "";
        private RestMethods method = RestMethods.GET;
        private Map<String,String> headers = new HashMap<>();
        private Map<String,String> queryParams = new HashMap<>();
        private Map<String,String> formParams = new HashMap<>();
        private boolean useRelaxedHttpValidation = false;

        public Builder setBaseUrl(String baseUrl){
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder setBasePath(String basePath){
            this.basePath = basePath;
            return this;
        }

        public Builder setBody(String body){
            this.body = body;
            return this;
        }

        public Builder setHeaders(Map<String,String> map){
            this.headers = map;
            return this;
        }

        public Builder setQueryParam(Map<String,String> map){
            this.queryParams = map;
            return this;
        }

        public Builder setFormParam(Map<String,String> map){
            this.formParams = map;
            return this;
        }

        public Builder setRestMethod(RestMethods method){
            this.method = method;
            return this;
        }

        public Builder setUseRelaxedHttpValidation(boolean flag){
            this.useRelaxedHttpValidation = flag;
            return this;
        }

        public RestReq build(){
            return new RestReq(this);
        }

    }

}
