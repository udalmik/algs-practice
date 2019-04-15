package com.udalmik.algs.interviewbit.backtracking;

import java.util.*;
import java.util.stream.Collectors;

class Pos {
    int i;
    int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int n) {

        Set<ArrayList<String>> result = new HashSet<>();

        findPositions(new boolean[n][n], n, result, new ArrayList<>());

        return new ArrayList<>(result);

    }

    private void findPositions(boolean[][] board, int n, Set<ArrayList<String>> result, List<Pos> positions) {
        int positionsSize = positions.size();
        boolean[] row = board[positionsSize];
        for (int j = 0; j < row.length; j++) {
            if (freeSpot(board, positionsSize, j)) {
                Pos position = new Pos(positionsSize, j);
                positions.add(position);
                if (positions.size() == n) {
                    result.add(toResultFormat(positions, n));
                } else {
                    boolean[][] withBusySpot = fillSpot(board, positionsSize, j, n);
                    findPositions(withBusySpot, n, result, positions);
                }
                positions.remove(position);
            }
        }
    }

    private ArrayList<String> toResultFormat(List<Pos> positions, int n) {
        boolean[][] board = new boolean[n][n];
        positions.forEach(pos -> board[pos.i][pos.j] = true);
        return Arrays.stream(board).map(booleans -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < booleans.length; i++) {
                builder.append(booleans[i] ? "Q" : ".");
            }
            return builder.toString();
        })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean[][] fillSpot(boolean[][] board, int i, int j, int n) {
        boolean[][] boardCopy = Arrays.stream(board).map(boolean[]::clone).toArray(boolean[][]::new);
        boolean[] selectedRow = boardCopy[i];
        for (int k = 0; k < selectedRow.length; k++) {
            selectedRow[k] = true;
        }
        for (int k = 0; k < boardCopy.length; k++) {
            boolean[] row = boardCopy[k];
            row[j] = true;
        }
        {
            int iCopy = i;
            int jCopy = j;
            while (++iCopy < n && ++jCopy < n) {
                boardCopy[iCopy][jCopy] = true;
            }
        }
        {
            int iCopy = i;
            int jCopy = j;
            while (--iCopy >= 0 && --jCopy >= 0) {
                boardCopy[iCopy][jCopy] = true;
            }
        }
        {
            int iCopy = i;
            int jCopy = j;
            while (--iCopy >= 0 && ++jCopy < n) {
                boardCopy[iCopy][jCopy] = true;
            }
        }
        {
            int iCopy = i;
            int jCopy = j;
            while (++iCopy < n && --jCopy >= 0) {
                boardCopy[iCopy][jCopy] = true;
            }
        }
        return boardCopy;
    }

    private boolean freeSpot(boolean[][] boardCopy, int i, int j) {
        return !boardCopy[i][j];
    }

}
