package com.fiserv.fs.helix.rest;

import com.fiserv.fs.helix.model.Party;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.time.Duration;

@QuarkusTest
class PartyDirectoryServiceTest {

    @Inject
    PartyDirectoryService partyDirectoryService;

    @Test
    void getByIdAsUni() {
        final Uni<Party> uniParty = partyDirectoryService.getByIdAsUni(1L);
        Party party = uniParty.await().atMost(Duration.ofSeconds(5));

        Assertions.assertEquals(1L, party.id);
        Assertions.assertEquals("Aby", party.name);
        Assertions.assertEquals(40, party.age);
        Assertions.assertEquals(null, party.address);
    }
}