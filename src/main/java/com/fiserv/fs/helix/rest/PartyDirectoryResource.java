package com.fiserv.fs.helix.rest;

import com.fiserv.fs.helix.model.Party;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/PartyDirectory")
@ApplicationScoped
public class PartyDirectoryResource {

    @Inject
    PartyDirectoryService partyDirectoryService;

    @POST
    @Path("/uni")
    public Uni<Response> create(Party party) {
        return Panache.<Party>withTransaction(party::persist)
                .onItem().transform(inserted -> Response.created(URI.create("/PartyDirectory/uni" + inserted.id)).build());
    }

    @GET
    @Path("/uni")
    public Uni<List<Party>> getAll(){
        return partyDirectoryService.getAllAsUni();
    }

    @GET
    @Path("/uni/{id}")
    public Uni<Party> idMutiny(@PathParam("id") Long id) {
        return partyDirectoryService.getByIdAsUni(id);
    }

    @GET
    @Path("/rest/{id}")
    @Blocking
    @Produces(MediaType.APPLICATION_JSON)
    public Party id(@PathParam("id") Long id) {
        return partyDirectoryService.getById(id);
    }

    /* @GET
    @Path("/async/{id}")
    public CompletionStage<Party> idAsync(@PathParam("id") Long id) {
        return partyDirectoryService.getByIdAsync(id);
    } */
}