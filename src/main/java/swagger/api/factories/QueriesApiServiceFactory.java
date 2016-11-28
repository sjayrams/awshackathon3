package swagger.api.factories;

import swagger.api.QueriesApiService;
import swagger.api.impl.QueriesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-28T19:32:47.862Z")
public class QueriesApiServiceFactory {
    private final static QueriesApiService service = new QueriesApiServiceImpl();

    public static QueriesApiService getQueriesApi() {
        return service;
    }
}
