package io.swagger.api.factories;

import io.swagger.api.QueriesApiService;
import io.swagger.api.impl.QueriesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-28T19:32:47.862Z")
public class QueriesApiServiceFactory {
    private final static QueriesApiService service = new QueriesApiServiceImpl();

    public static QueriesApiService getQueriesApi() {
        return service;
    }
}
