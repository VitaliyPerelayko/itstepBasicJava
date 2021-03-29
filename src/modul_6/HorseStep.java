package modul_6;

import java.util.Optional;

public class HorseStep {

    private int boardSize;
    private Board board;

    public HorseStep(int boardSize, Board board) {
        this.boardSize = boardSize;
        this.board = board;
    }

    public void horseStepLoop() {
        // first step
        board.findCell(1,1).value = 1;
        Cell[] nextSteps = nextStep(1, 1);
        Cell[] temp;
        Cell[] bestSteps = nextSteps;
        int numOfStep = 2;
        while (nextSteps[0] != null) {
            Cell bestCell = nextSteps[0];
            int bestLength = 8;
            for (Cell cell : nextSteps) {
                if (cell!=null) {
                    temp = nextStep(cell.x, cell.y);
                    if (temp[7].x < bestLength) {
                        bestLength = temp[7].x;
                        bestCell = cell;
                        bestSteps = temp;
                    }
                } else {
                    break;
                }
            }
            bestCell.value = numOfStep++;
            nextSteps = bestSteps;
        }
    }


    /**
     * find all valid next steps for horse
     *
     * @param x horizontal coordinate
     * @param y vertical coordinate
     * @return all valid next steps like
     */
    private Cell[] nextStep(int x, int y) {
        Cell[] steps = new Cell[8];
        int count = 0;
        //1 up-left
        Optional<Cell> cell = step(x - 1, y + 2);
        if (cell.isPresent()) {
            steps[count] = cell.get();
            count++;
        }
        //2 up-right
        cell = step(x + 1, y + 2);
        if (cell.isPresent()) {
            steps[count] = cell.get();
            count++;
        }
        //3 left-up
        cell = step(x - 2, y + 1);
        if (cell.isPresent()) {
            steps[count] = cell.get();
            count++;
        }
        //4 left-down
        cell = step(x - 2, y - 1);
        if (cell.isPresent()) {
            steps[count] = cell.get();
            count++;
        }
        //5 right-up
        cell = step(x + 2, y + 1);
        if (cell.isPresent()) {
            steps[count] = cell.get();
            count++;
        }
        //6 right-down
        cell = step(x + 2, y - 1);
        if (cell.isPresent()) {
            steps[count] = cell.get();
            count++;
        }
        //7 down-left
        cell = step(x - 1, y - 2);
        if (cell.isPresent()) {
            steps[count] = cell.get();
            count++;
        }
        //8 down-right
        cell = step(x + 1, y - 2);
        if (cell.isPresent()) {
            steps[count] = cell.get();
        }
        steps[7] = new Cell(count,0);
        return steps;
    }

    private Optional<Cell> step(int x, int y) {
        if ((x >= 1) && (x <= boardSize) && (y >= 1) && (y <= boardSize)) {
            Cell cell = board.findCell(x, y);
            if (cell.value == 0) {
                return Optional.of(cell);
            }
        }
        return Optional.empty();
    }

    static class Board {
        private Cell[] board;
        private int boardSize;

        public Board(int boardSize) {
            this.boardSize = boardSize;
            board = new Cell[boardSize * boardSize];
            for (int i = 1; i <= boardSize; i++) {
                for (int j = 1; j <= boardSize; j++) {
                    board[(i - 1) * boardSize + j - 1] = new Cell(i, j);
                }
            }
        }

        public Cell findCell(int x, int y) {
            return board[(x - 1) * boardSize + y - 1];
        }

        public void printBoard() {
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    int value = board[i * boardSize + j].value;
                    System.out.printf("%4d",value);
                }
                System.out.println();
            }
        }
    }

    static class Cell {
        private int x;
        private int y;
        private int value;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            value = 0;
        }
    }

    public static void main(String[] args) {
        //   printMatrix(horseStepLoop(8));
        // printMatrix(horseStepLoop(8));
        HorseStep hs = new HorseStep(12,new Board(12));
        hs.horseStepLoop();
        hs.board.printBoard();
    }
}
