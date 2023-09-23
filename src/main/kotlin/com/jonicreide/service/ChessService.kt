package com.jonicreide.service

import com.jonicreide.domain.FEN
import org.springframework.stereotype.Service

@Service
class ChessService(
    private val boardService: BoardService
) {
    var bitMaps = mutableMapOf<String, BooleanArray>()

    fun analyseBoard(fen: FEN) {

        validateFEN(fen.fen)
        boardService.fillBoard(fen.fen, bitMaps)



        println("Analyse board")
    }

    private fun validateFEN(fen: String) {
        val regexPattern =
            """\s*^(((?:[rnbqkpRNBQKP1-8]+\/){7})[rnbqkpRNBQKP1-8]+)\s([b|w])\s([K|Q|k|q]{1,4})\s(-|[a-h][1-8])\s(\d+\s\d+)${'$'}""".toRegex()
        if(!regexPattern.matches(fen)) throw Exception("Invalid FEN")
    }
}
