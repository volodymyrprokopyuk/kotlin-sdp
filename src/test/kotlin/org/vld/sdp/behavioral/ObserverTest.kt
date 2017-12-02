package org.vld.sdp.behavioral

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito.* // ktlint-disable no-wildcard-imports

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObserverTest {

    @Test
    @DisplayName("Given an auctioneer and a set of bidders. When change bid. Then notify all bidders with the new bid")
    fun givenAuctioneerAndSetOfBidders_whenChangeBid_thenNotifyAllBiddersWithTheNewBid() {
        // Given
        val actioneer: AuctioneerSubject = Auctioneer()
        val mockedBidder1: BidObserver = mock(Bidder::class.java)
        val mockedBidder2: BidObserver = mock(Bidder::class.java)
        actioneer.register(mockedBidder1, mockedBidder2)
        // When
        actioneer.notifyNewBid(1)
        // Then
        verify(mockedBidder1).updateBid(0, 1)
        verify(mockedBidder2).updateBid(0, 1)
    }
}
