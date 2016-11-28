package swagger.api;

import swagger.model.Query;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-28T19:32:47.862Z")
public abstract class QueriesApiService {
    public abstract Response queriesGet(String name,String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response queriesIdGet(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response queriesPost(Query query,SecurityContext securityContext) throws NotFoundException;
}
