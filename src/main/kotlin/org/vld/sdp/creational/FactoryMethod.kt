package org.vld.sdp.creational

/**
 * Article product interface
 */
interface Article {
    val name: String
}

/**
 * Article Creator factory method interface
 */
interface ArticleCreator {
    /**
     * Creates Article product (factory method)
     */
    fun createArticle(name: String): Article
}

/**
 * Modern Article concrete product
 */
data class ModernArticle(override val name: String) : Article

/**
 * Modern Article Creator concrete factory method singleton encapsulates knowledge about Modern Article product
 */
object ModernArticleCreator : ArticleCreator {
    // the only place where concrete Modern Article product is referenced (factory method)
    override fun createArticle(name: String): Article = ModernArticle(name)
}

/**
 * Fancy Article concrete product
 */
data class FancyArticle(override val name: String) : Article

/**
 * Fancy Article creator concrete factory method singleton encapsulates knowledge about Fancy Article product
 */
object FancyArticleCreator : ArticleCreator {
    // the only place where concrete Fancy Article product is referenced (factory method)
    override fun createArticle(name: String): Article = FancyArticle(name)
}
