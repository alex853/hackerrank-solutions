package lt.problem_957_prison_cells_after_n_days_medium;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(cellsToInt(cells), 0);

        int dayCounter = 0;
        while (dayCounter < N) {
            cells = nextDay(cells);
            dayCounter++;

//            n 10 dc 7 dwsc 0 ==> dc 7
//            n 20 dc 7 dwsc 0 ==> dc 14

            int cellsInt = cellsToInt(cells);
            if (memory.containsKey(cellsInt)) {
                int dayWithSameCells = memory.get(cellsInt);
                int remainedDays = N - dayCounter;
                int cycleLength = dayCounter - dayWithSameCells;
                dayCounter = dayCounter + (remainedDays / cycleLength) * cycleLength;
            } else {
                memory.put(cellsInt, dayCounter);
            }
        }

        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] result = new int[8];
        result[0] = 0;
        for (int i = 1; i <= 6; i++) {
            result[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        result[7] = 0;
        return result;
    }

    private int cellsToInt(int[] cells) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result |= cells[i] << i;
        }
        return result;
    }
}
