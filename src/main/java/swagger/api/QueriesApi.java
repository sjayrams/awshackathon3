package swagger.api;

import swagger.api.factories.QueriesApiServiceFactory;

import io.swagger.annotations.ApiParam;

import swagger.model.Query;
import swagger.model.Data;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/queries")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the queries API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-28T19:32:47.862Z")
public class QueriesApi  {
   private final QueriesApiService delegate = QueriesApiServiceFactory.getQueriesApi();

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "return list or one query", notes = "this will return one or more queries", response = Query.class, responseContainer = "List", tags={ "Queries", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "An array of queries", response = Query.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = Query.class, responseContainer = "List") })
    public Response queriesGet(@ApiParam(value = "name of query.") @QueryParam("name") String name
,@ApiParam(value = "id of query.") @QueryParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.queriesGet(name,id,securityContext);
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns data for the query", response = Data.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The response containing all query information", response = Data.class) })
    public Response queriesIdGet(@ApiParam(value = "The queryid received from the POST operation.",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.queriesIdGet(id,securityContext);
    }
    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "post the query", response = Query.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The response containing all query information", response = Query.class) })
    public Response queriesPost(@ApiParam(value = "The queryid received from the POST operation." ,required=true) Query query
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.queriesPost(query,securityContext);
    }
}
