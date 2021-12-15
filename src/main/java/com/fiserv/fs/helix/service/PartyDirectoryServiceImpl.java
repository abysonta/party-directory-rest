package com.fiserv.fs.helix.service;

import com.fiserv.fs.helix.model.Party;
import com.fiserv.fs.helix.rest.PartyDirectoryService;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class PartyDirectoryServiceImpl implements PartyDirectoryService {
    @Override
    public Party getById(Long id) {
        Uni<Party> uniParty = Party.findById(id);
        Party party = uniParty.await().atMost(Duration.ofSeconds(5));
        return party;
    }

    /*@Override
    public CompletionStage<Party> getByIdAsync(String id) {
        CompletionStage<Party> stage = new CompletableFuture<>();
        return stage;
    }*/

    @Override
    public Uni<List<Party>> getAllAsUni() {
        return Party.listAll(Sort.by("id"));
    }

    @Override
    public Uni<Party> getByIdAsUni(Long id) {
        return Party.findById(id);
    }
}
