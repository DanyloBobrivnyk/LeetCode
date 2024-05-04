import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Set<Character> rows;
    Set<Character> cols;
    Map<String, Set<Character>> boxes;

    public boolean isValidSudoku(char[][] board) {
        boxes = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            rows = new HashSet<>();
            cols = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char rowElem = board[r][c];
                char columnElem = board[c][r];

                if (rowElem != '.') {
                    if (rows.contains(rowElem)) {
                        return false;
                    }
                    else {
                        rows.add(rowElem);
                    }

                    String key = String.format("%s,%s", r / 3, c / 3);
                    var res = validateBoxes(key, board[r][c]);
                    if (!res) {
                        return false;
                    }
                }

                if (columnElem != '.') {
                    if (cols.contains(columnElem)) {
                        return false;
                    }
                    else {
                        cols.add(columnElem);
                    }
                }
            }
        }
        return true;
    }

    private boolean validateBoxes(String key, Character character) {
        if (!boxes.containsKey(key)) {
            Set<Character> val = new HashSet<>();
            val.add(character);
            boxes.put(key, val);
        } else {
            var set = boxes.get(key);
            if (!set.add(character)){
                return false;
            }
        }
        return true;
    }
}