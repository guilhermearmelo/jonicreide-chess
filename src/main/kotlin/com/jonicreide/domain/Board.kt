package com.jonicreide.domain

data class Board(
    var fen: String,
    var fenParts: List<String>,
    var bitmaps: MutableMap<String, BooleanArray>
)
