package com.jonicreide.service

import com.jonicreide.domain.Board
import org.springframework.stereotype.Service

@Service
class BoardService {

    fun fillBoard(fen: String, bitmaps: MutableMap<String, BooleanArray>) : Board {
        var piece = BooleanArray(64)

        var white = BooleanArray(64)
        var black = BooleanArray(64)

        var pawns = BooleanArray(64)
        var knights = BooleanArray(64)
        var bishops = BooleanArray(64)
        var rooks = BooleanArray(64)
        var queens = BooleanArray(64)
        var kings = BooleanArray(64)

        val fenParts = fen.split(" ")

        val positions = fenParts[0].replace("/", "")

        var boardIndex = 0
        var positionsIndex = 0
        while(boardIndex < 64) {
            when(positions[positionsIndex]) {
                'p' -> {
                    pawns[boardIndex] = true
                    black[boardIndex] = true
                    piece[boardIndex] = true
                }
                'P' -> {
                    pawns[boardIndex] = true
                    white[boardIndex] = true
                    piece[boardIndex] = true
                }
                'n' -> {
                    knights[boardIndex] = true
                    black[boardIndex] = true
                    piece[boardIndex] = true
                }
                'N' -> {
                    knights[boardIndex] = true
                    white[boardIndex] = true
                    piece[boardIndex] = true
                }
                'b' -> {
                    bishops[boardIndex] = true
                    black[boardIndex] = true
                    piece[boardIndex] = true
                }
                'B' -> {
                    bishops[boardIndex] = true
                    white[boardIndex] = true
                    piece[boardIndex] = true
                }
                'r' -> {
                    rooks[boardIndex] = true
                    black[boardIndex] = true
                    piece[boardIndex] = true
                }
                'R' -> {
                    rooks[boardIndex] = true
                    white[boardIndex] = true
                    piece[boardIndex] = true
                }
                'q' -> {
                    queens[boardIndex] = true
                    black[boardIndex] = true
                    piece[boardIndex] = true
                }
                'Q' -> {
                    queens[boardIndex] = true
                    white[boardIndex] = true
                    piece[boardIndex] = true
                }
                'k' -> {
                    kings[boardIndex] = true
                    black[boardIndex] = true
                    piece[boardIndex] = true
                }
                'K' -> {
                    kings[boardIndex] = true
                    white[boardIndex] = true
                    piece[boardIndex] = true
                }
                else -> {
                    boardIndex+=positions[positionsIndex].toString().toInt()-1
                }
            }
            positionsIndex++
            boardIndex++
        }


        return Board(fen, fenParts, bitmaps)
    }
}
