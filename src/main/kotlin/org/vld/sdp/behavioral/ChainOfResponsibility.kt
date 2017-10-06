package org.vld.sdp.behavioral

/**
 * Cash request to be passed along the chain of responsibility
 *
 * Cash request has the [amount] to be represented in a number of different [notes]. The cash request allows
 * partial processing by a note handler where in each note handler the initial [amount] is reduced
 * by the amount of the number of notes that are registered in [notes]
 */
data class CashRequest(val amount: Int, val notes: List<Pair<Int, Int>> = listOf())

/**
 * Handler interface for the Cash Request Handler that is also used for the [cashRequestHandlerChain] whole chain
 *
 * The Cash Request Handler interface is a function that receives a [CashRequest] and returns a [CashRequest]
 */
typealias CashRequestHandler = (CashRequest) -> CashRequest

/**
 * Builds the [CashRequestHandler] for a given [note]
 */
fun buildCashRequestHandlerForNote(note: Int): CashRequestHandler = { cashRequest ->
    // a part of the amount can be represented with a given note
    if (cashRequest.amount > note) CashRequest(
            // forward the initial amount remainder
            cashRequest.amount % note,
            // register the number of a given notes
            cashRequest.notes + Pair(note, cashRequest.amount / note)
    )
    // the amount is less the a given note, forward the whole amount without registering the note
    else cashRequest
}

/**
 * Build the Cash Request Handler Chain for a given set of notes
 *
 * The Cash Request Handler Chain implements the [CashRequestHandler] interface the same Handler interface
 * that any individual Cash Request Handler implements.
 * The set of notes can be easily changed by just adding/removing the values for the list
 */
val cashRequestHandlerChain: CashRequestHandler = listOf(100, 50, 20, 10, 5)
        // build the Cash Request Handlers for a given list of notes
        .map(::buildCashRequestHandlerForNote)
        // compose the Cash Request Handlers into the Cash Request Handlers Chain
        .reduce { chain, handler -> { cashRequest -> handler(chain(cashRequest)) } }
