package org.vld.sdp.behavioral

/**
 * Cash request to be passed along the chain
 *
 * Cash request has the [amount] to be represented in a number of different [notes]. The cash request allows
 * partial processing by a note handler where in each note handler the initial [amount] is reduced
 * by the amount of the number of notes that are registered in [notes]
 */
data class CashRequest(val amount: Int, val notes: List<Pair<Int, Int>> = listOf())

/**
 * Handler interface for cash request handler that is also used for the [CashRequestHandlerChain] whole chain
 *
 * Cash request handler interface is a function that receives a [CashRequest] and returns a [CashRequest]
 */
typealias CashRequestHandler = (CashRequest) -> CashRequest

/**
 * Builds the [CashRequestHandler] for a given [note]
 */
fun buildCashRequestHandlerForNote(note: Int): CashRequestHandler = { cashRequest ->
    // a part of the amount can be represented with a given note
    if (cashRequest.amount > note) CashRequest(
            // forward the initial amount remainder
            cashRequest.amount.rem(note),
            // register the number of a given notes
            cashRequest.notes + Pair(note, cashRequest.amount.div(note))
    )
    // the amount is less the a given note, forward the whole amount without registering the note
    else cashRequest
}

/**
 * Build the cash request handler chain for a given set of notes. The cash request handler chain has
 * [CashRequestHandler] interface the same handler interface that any individual cash request handler has.
 * The set of notes can be easily changed by just adding/removing the values for the list
 */
val CashRequestHandlerChain: CashRequestHandler = listOf(100, 50, 20, 10, 5)
        // build the cash request handlers for a given notes
        .map(::buildCashRequestHandlerForNote)
        // compose the cash request handlers into the chain
        .reduce { chain, handler -> { cashRequest -> handler(chain(cashRequest)) } }
