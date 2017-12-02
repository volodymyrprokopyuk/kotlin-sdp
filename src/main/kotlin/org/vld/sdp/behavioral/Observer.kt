package org.vld.sdp.behavioral

/**
 * Observer interface
 */
interface BidObserver {
    /**
     * Notifies bid change from [oldBid] to [newBid]
     */
    fun updateBid(oldBid: Int, newBid: Int)
}

/**
 * Subject interface
 */
interface AuctioneerSubject {
    /**
     * Registers new [bidObservers] with the Subject
     */
    fun register(vararg bidObservers: BidObserver)

    /**
     * Notifies the [BidObserver] of the [newBid] state change
     */
    fun notifyNewBid(newBid: Int)
}

/**
 * Subject interface implementation
 */
class Auctioneer : AuctioneerSubject {
    // current bid
    private var bid: Int = 0
    // list of bidders to notify when the bid changes
    private val bidders: MutableList<BidObserver> = mutableListOf()

    override fun register(vararg bidObservers: BidObserver) {
        bidders.addAll(bidObservers)
    }

    /**
     * Notifies all [BidObserver]s with the new bid state change
     */
    override fun notifyNewBid(newBid: Int) {
        val oldBid = bid
        bid = newBid
        bidders.forEach { it.updateBid(oldBid, newBid) }
    }
}

/**
 * Observer implementation
 */
open class Bidder : BidObserver {
    override fun updateBid(oldBid: Int, newBid: Int) {}
}
