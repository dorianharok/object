package com.example.object._01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudienceTest {

    @Test
    @DisplayName("초대장이 있는 경우 0원을 지불하고 가방엔 티켓이 추가된다.")
    public void hasInvitation() {
        Bag bag = new Bag(new Invitation(), 1000L);
        Audience audience = new Audience(bag);
        Long fee = audience.buy(new Ticket());

        assertEquals(0L, fee);
        assertTrue(bag.hasTicket());
    }

    @Test
    @DisplayName("초대장이 없는 경우 티켓값을 지불하고 가방엔 티켓이 추가된다.")
    public void noInvitation() {
        Bag bag = new Bag(null, 1000L);
        Audience audience = new Audience(bag);
        Long fee = audience.buy(new Ticket(1000L));

        assertEquals(1000L, fee);
        assertTrue(bag.hasTicket());
    }
}