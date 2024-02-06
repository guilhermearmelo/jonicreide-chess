package com.jonicreide.service

import com.jonicreide.domain.Board
import org.springframework.stereotype.Service

@Service
class EvaluationService() {

    fun booleanToInt(b: Boolean) = if (b) 1 else 0
    fun simpleMaterialEvaluation(board: Board) : Int{
        var whiteMaterial = 0
        var blackMaterial = 0

        for(i in 0..63) {
            if(board.chessMaps.pieceMap[i]) {
                if(board.chessMaps.whiteMap[i]) {
                    whiteMaterial += booleanToInt(board.chessMaps.kingsMap[i]) * 100 +
                            booleanToInt(board.chessMaps.queensMap[i]) * 9 +
                            booleanToInt(board.chessMaps.rooksMap[i]) * 5 +
                            booleanToInt(board.chessMaps.bishopsMap[i]) * 3 +
                            booleanToInt(board.chessMaps.knightsMap[i]) * 3 +
                            booleanToInt(board.chessMaps.pawnsMap[i]) * 1
                } else {
                    blackMaterial += booleanToInt(board.chessMaps.kingsMap[i]) * 100 +
                            booleanToInt(board.chessMaps.queensMap[i]) * 9 +
                            booleanToInt(board.chessMaps.rooksMap[i]) * 5 +
                            booleanToInt(board.chessMaps.bishopsMap[i]) * 3 +
                            booleanToInt(board.chessMaps.knightsMap[i]) * 3 +
                            booleanToInt(board.chessMaps.pawnsMap[i]) * 1
                }
            }
        }

        return whiteMaterial - blackMaterial
    }
}
