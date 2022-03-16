package com.baress.tbtestapp.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiUtils {

    fun create(
        block: (Moshi.Builder.() -> Unit)? = null
    ): Moshi {
        val builder = Moshi.Builder()

        if (block != null) {
            block(builder)
        }
        return builder.add(KotlinJsonAdapterFactory()).build()
    }

    class Factory(
        private val block: (Moshi.Builder.() -> Unit)? = null
    ) {

        fun newFactory(additionalBlock: (Moshi.Builder.() -> Unit)): Factory =
            Factory() {
                block?.invoke(this)
                additionalBlock(this)
            }

        fun create(): Moshi = create(block)
    }
}
