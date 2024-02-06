package com.jonicreide.service

import com.jonicreide.domain.Board
import com.jonicreide.domain.ChessMaps
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val evaluationService: EvaluationService
) {
    private val logger = KotlinLogging.logger{}
    fun evaluateBoard(fen: String) : Int{

        logger.info { "Preparing Board for Evaluation" }
        var board = prepareBoardForEvaluation(fen)
        logger.info { "Board Information Completed" }

        logger.info { "Simple Material Evaluation" }
        val eval = evaluationService.simpleMaterialEvaluation(board)

        return eval
    }

    private fun prepareBoardForEvaluation(fen: String) : Board {
        val board = Board()
        board.fen = fillBoardFEN(fen)
        board.fenParts = fillBoardFENParts(fen)
        board.chessMaps = fillBoardChessMaps(board.fenParts!![0])
        return board
    }

    private fun fillBoardFEN(fen: String) : String {
        logger.info { "Filling Board Information - FEN String: $fen" }
        return fen
    }

    private fun fillBoardFENParts(fen: String) : List<String> {
        logger.info { "Filling Board Information - FEN Parts: $fen" }
        return fen.split(" ")
    }

    private fun fillBoardChessMaps(fen: String) : ChessMaps {
        logger.info { "Filling Board Information - Chess Maps" }
        val chessMaps = ChessMaps()

        var boardIndex = 0
        var positionsIndex = 0
        while(boardIndex < 64) {
            when(fen[positionsIndex]) {
                'p' -> {
                    chessMaps.pawnsMap[boardIndex] = true
                    chessMaps.blackMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'P' -> {
                    chessMaps.pawnsMap[boardIndex] = true
                    chessMaps.whiteMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'n' -> {
                    chessMaps.knightsMap[boardIndex] = true
                    chessMaps.blackMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'N' -> {
                    chessMaps.knightsMap[boardIndex] = true
                    chessMaps.whiteMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'b' -> {
                    chessMaps.bishopsMap[boardIndex] = true
                    chessMaps.blackMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'B' -> {
                    chessMaps.bishopsMap[boardIndex] = true
                    chessMaps.whiteMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'r' -> {
                    chessMaps.rooksMap[boardIndex] = true
                    chessMaps.blackMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'R' -> {
                    chessMaps.rooksMap[boardIndex] = true
                    chessMaps.whiteMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'q' -> {
                    chessMaps.queensMap[boardIndex] = true
                    chessMaps.blackMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'Q' -> {
                    chessMaps.queensMap[boardIndex] = true
                    chessMaps.whiteMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'k' -> {
                    chessMaps.kingsMap[boardIndex] = true
                    chessMaps.blackMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                'K' -> {
                    chessMaps.kingsMap[boardIndex] = true
                    chessMaps.whiteMap[boardIndex] = true
                    chessMaps.pieceMap[boardIndex] = true
                }
                '/' -> {
                    boardIndex--
                }
                else -> {
                    boardIndex+=fen[positionsIndex].toString().toInt()-1
                }
            }
            positionsIndex++
            boardIndex++
        }
        return chessMaps
    }
}
