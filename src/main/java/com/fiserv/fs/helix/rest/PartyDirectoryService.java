package com.fiserv.fs.helix.rest;

import com.fiserv.fs.helix.model.Party;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletionStage;

public interface PartyDirectoryService {
    Party getById(Long id);

    //CompletionStage<Party> getByIdAsync(String id);

    Uni<List<Party>> getAllAsUni();
    Uni<Party> getByIdAsUni(Long id);
}
