package Ex5;
public class GOLMatrix {
    private boolean[][] world;
    private int generations;

    public GOLMatrix(int n) {
        if (n < 3) n = 3;
        this.generations = 0;

        this.world = new boolean[n][n];
    }

    public void flipCell(int row, int col) {
        if (this.world.length <= row || this.world[0].length <= col || row < 0 || col < 0) return;

        if (this.world[row][col])
            this.world[row][col] = false;

        else if (this.world[row][col] == false)
            this.world[row][col] = true;
    }

    public boolean[][] getWorld() {
        return this.world;
    }

    public int getGenerations() {
        return this.generations;
    }

    public void clearWorld() {
        boolean[][] world1 = new boolean[this.world.length][this.world[0].length];
        this.world = world1;
        this.generations = 0;
    }

    public void nextGeneration() {
        boolean[][] nextWorld = new boolean[this.world.length][this.world[0].length];
        int count = 0;

        for (int i = 0; i <this.world.length; i++)
            for (int j = 0;j <this.world[0].length; j++) {
                if(i-1 >= 0){
                    if(j-1 >= 0)
                        if (this.world[i - 1][j - 1])
                            count++;
                    if(this.world[i-1][j])
                        count++;
                    if(j+1 <this.world[i-1].length)
                        if(world[i-1][j+1])
                            count++;
                }
                if(j-1 >=0)
                    if(this.world[i][j-1])
                        count++;
                if(j+1 <this.world[i].length)
                    if(this.world[i][j+1])
                        count++;

                if(i+1 <this.world.length) {
                    if (j - 1 >= 0)
                        if (this.world[i + 1][j - 1])
                            count++;

                    if(this.world[i+1][j])
                        count++;
                    if(j+1 <this.world[i+1].length)
                        if(this.world[i+1][j+1])
                            count++;
                }

                if((this.world[i][j])&&(count == 2||count == 3))
                    nextWorld[i][j] = true;
                if(this.world[i][j]==false && count == 3)
                    nextWorld[i][j] = true;

                count = 0;
            }
        this.world = nextWorld;
        generations++;
    }
}

