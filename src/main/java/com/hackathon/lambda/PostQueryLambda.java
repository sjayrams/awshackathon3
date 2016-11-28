package com.hackathon.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import swagger.model.Query;
import swagger.model.QueryRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by guptga1 on 11/28/16.
 */
public class PostQueryLambda implements RequestHandler<QueryRequest, List<Query>> {
	

    @Override
    public List<Query> handleRequest(QueryRequest s, Context context) {
        List<Query> queries = loadQueries();

        if( s != null )
            queries.stream().filter(x -> x.getName().equalsIgnoreCase(s.getName())).collect(Collectors.toList());

        return queries;
    }

    private List<Query> loadQueries() {
        List<Query> queries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queries.add(new Query().country(Query.CountryEnum.GHANA).district(UUID.randomUUID().toString())
                    .name(UUID.randomUUID().toString()).region(UUID.randomUUID().toString()).ward(UUID.randomUUID().toString()));
        }
        return queries;
    }
}
