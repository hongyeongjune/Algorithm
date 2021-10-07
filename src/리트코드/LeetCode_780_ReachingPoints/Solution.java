package 리트코드.LeetCode_780_ReachingPoints;

public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;
        else if (sx > tx || sy > ty) return false;

        return (recursive(sx + sy, sy, tx, ty) || recursive(sx, sx + sy, tx, ty));
    }

    private boolean recursive(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx;
            } else tx %= ty;
        }

        if (sx == tx && sy <= ty && (ty - sy) % sx == 0)
            return true;
        return sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}
