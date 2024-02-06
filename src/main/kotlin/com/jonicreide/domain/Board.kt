package com.jonicreide.domain

data class Board(
    var fen: String? = null,
    var fenParts: List<String> ? = null,
    var chessMaps: ChessMaps = ChessMaps()
)



data class ChessMaps(
    var pieceMap : BooleanArray = BooleanArray(64),

    var whiteMap : BooleanArray = BooleanArray(64),
    var blackMap : BooleanArray = BooleanArray(64),

    var pawnsMap : BooleanArray = BooleanArray(64),
    var knightsMap : BooleanArray = BooleanArray(64),
    var bishopsMap : BooleanArray = BooleanArray(64),
    var rooksMap : BooleanArray = BooleanArray(64),
    var queensMap : BooleanArray = BooleanArray(64),
    var kingsMap : BooleanArray = BooleanArray(64),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChessMaps

        if (!pieceMap.contentEquals(other.pieceMap)) return false
        if (!whiteMap.contentEquals(other.whiteMap)) return false
        if (!blackMap.contentEquals(other.blackMap)) return false
        if (!pawnsMap.contentEquals(other.pawnsMap)) return false
        if (!knightsMap.contentEquals(other.knightsMap)) return false
        if (!bishopsMap.contentEquals(other.bishopsMap)) return false
        if (!rooksMap.contentEquals(other.rooksMap)) return false
        if (!queensMap.contentEquals(other.queensMap)) return false
        if (!kingsMap.contentEquals(other.kingsMap)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pieceMap.contentHashCode()
        result = 31 * result + whiteMap.contentHashCode()
        result = 31 * result + blackMap.contentHashCode()
        result = 31 * result + pawnsMap.contentHashCode()
        result = 31 * result + knightsMap.contentHashCode()
        result = 31 * result + bishopsMap.contentHashCode()
        result = 31 * result + rooksMap.contentHashCode()
        result = 31 * result + queensMap.contentHashCode()
        result = 31 * result + kingsMap.contentHashCode()
        return result
    }
}
