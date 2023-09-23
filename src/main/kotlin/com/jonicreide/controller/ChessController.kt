package com.jonicreide.controller

import com.jonicreide.domain.FEN
import com.jonicreide.service.ChessService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chess")
class ChessController(
    private val chessService: ChessService
) {

    @GetMapping("/analyse")
    fun getChessBoard(
        @RequestBody board: FEN
    ) {
        chessService.analyseBoard(board)
    }
}
