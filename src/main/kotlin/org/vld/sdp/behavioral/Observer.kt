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
     * Registers new [bidObservers] with the subject
     */
    fun register(vararg bidObservers: BidObserver)

    /**
     * Notifies bid state change
     */
    fun notifyNewBid(newBid: Int)
}

/**
 * Subject interface implementation
 */
class Auctioneer(
        // current bid
        private var bid: Int = 0,
        // list of bidders to notify when the bid changes
        private val bidders: MutableList<BidObserver> = mutableListOf()
) : AuctioneerSubject {

    override fun register(vararg bidObservers: BidObserver) {
        bidders.addAll(bidObservers)
    }

    override fun notifyNewBid(newBid: Int) {
        val oldBid = bid
        bid = newBid
        bidders.forEach { it.updateBid(oldBid, newBid) }
    }

}

/**
 * Observer implementation
 */
open class Bidder() : BidObserver {
    override fun updateBid(oldBid: Int, newBid: Int) {}
}
