package com.fiserv.fs.helix.repository;

import com.fiserv.fs.helix.model.Party;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PartyDirectoryRepository implements PanacheRepository {
    public Uni<Party> findByName(String name){
        return find("name", name).firstResult();
    }
}
