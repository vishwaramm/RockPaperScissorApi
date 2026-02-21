package com.vishwaram.rockpaperscissorapi.controller;

import com.vishwaram.rockpaperscissorapi.model.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {

    private static Score score = new Score(30, 20, 10);

    @GetMapping("/health-check")
    public ResponseEntity<String> getHealthCheck() {
        return ResponseEntity.ok("Situation Normal All Fired Up!");
    }

    @GetMapping("/score")
    public ResponseEntity<Score> getScore() {
        return ResponseEntity.ok(score);
    }

    @GetMapping("/score/{winsLossesOrTies}")
    public int getWinsLossesOrTies(@PathVariable String winsLossesOrTies) {
        switch (winsLossesOrTies.toLowerCase()) {
            case "wins":
                return score.getWins();
            case "ties":
                return score.getTies();
            case "losses":
                return score.getLosses();
            default:
                throw new IllegalArgumentException("Unsupported path");
        }
    }

    @PostMapping("/score/{winsLossesOrTies}")
    public Score increaseWinsLossesOrTies(@PathVariable String winsLossesOrTies) {
        switch (winsLossesOrTies.toLowerCase()) {
            case "wins":
                score.setWins(score.getWins()+1);
                break;
            case "ties":
                score.setTies(score.getTies()+1);
                break;
            case "losses":
                score.setLosses(score.getLosses()+1);
                break;
            default:
                throw new IllegalArgumentException("Unsupported path");
        }

        return score;
    }

    @PatchMapping("/score/{winsLossesOrTies}")
    public Score setWinsLossesOrTies(@PathVariable String winsLossesOrTies, @RequestParam(name = "new-value") int newValue) {
        switch (winsLossesOrTies.toLowerCase()) {
            case "wins":
                score.setWins(newValue);
                break;
            case "ties":
                score.setTies(newValue);
                break;
            case "losses":
                score.setLosses(newValue);
                break;
            default:
                throw new IllegalArgumentException("Unsupported path");
        }
        return score;
    }

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore) {
        score = newScore;
        return newScore;
    }

    @DeleteMapping("/score")
    public void deleteScore() {
        score = null;
    }
}
