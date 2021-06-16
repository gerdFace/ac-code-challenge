package com.example.accodechallenge.api

sealed class SortBy(val asString: String) {
    class ASC(asString: String = "ASC") : SortBy(asString)
    class DESC(asString: String = "DESC") : SortBy(asString)
}
