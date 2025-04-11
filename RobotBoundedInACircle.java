// In this problem, we identify that whenever after executing the set of instructions first time, if the robot is
// back to origin or robot is not at origin but it is also not facing north anymore, in that case our ans will be
// true i.e. there is a cycle. Else false.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public boolean isRobotBounded(String instructions) {
        // Base case
        if (instructions == null || instructions.length() == 0) {
            return true;
        }
        // Dirs indicating north direction cordinates at index 0, W at 1, S at 2 and E
        // at 3
        int[][] dirs = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        // x and y denotes the position of robot
        int x = 0;
        int y = 0;
        // i refers to index in dirs array where the robot is facing currently, so
        // initially facing north so i=0
        int i = 0;
        // Now loop till one set og instructions is completed
        for (int j = 0; j < instructions.length(); j++) {
            // Get the command
            char c = instructions.charAt(j);
            // It it is G, simply change the position of robot in the direction it is facing
            if (c == 'G') {
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
            // Else if left facing, then add 1 to i and do mod 4 to keep our index in range
            else if (c == 'L') {
                i = (i + 1) % 4;
            }
            // For facing right, add 3 to i
            else if (c == 'R') {
                i = (i + 3) % 4;
            }
        }
        // At last if the robot is back to origin i.e 0,0 or the direction it is facing
        // now is not north then return true else false
        return (x == 0 && y == 0) || i != 0;
    }
}