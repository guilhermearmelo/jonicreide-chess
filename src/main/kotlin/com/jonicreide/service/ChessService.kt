package com.jonicreide.service

import com.jonicreide.domain.FEN
import org.springframework.stereotype.Service
import mu.KotlinLogging

@Service
class ChessService(
    private val boardService: BoardService
) {
    private val logger = KotlinLogging.logger{}

    fun analyseBoard(fen: FEN) : Int{

        logger.info { "Validating FEN" }
        validateFEN(fen.fen)

        logger.info { "Evaluating Board" }
        boardService.evaluateBoard(fen.fen)

        return 0
    }

    private fun validateFEN(fen: String) {
        val regexPattern =
            """\s*^(((?:[rnbqkpRNBQKP1-8]+\/){7})[rnbqkpRNBQKP1-8]+)\s([b|w])\s([K|Q|k|q]{1,4})\s(-|[a-h][1-8])\s(\d+\s\d+)${'$'}""".toRegex()
        if(!regexPattern.matches(fen)) throw Exception("Invalid FEN")
    }
}
