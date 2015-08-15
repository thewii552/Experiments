/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolve;

public class PegGame {

    public static Peg pegs[] = new Peg[15];

    public static void main(String[] args) {
        init(14);
        
    }

    static void init(int unPegged) {
        float rowx = 0, rowy = 0; //Starting x/y of the row
        int rownum = 0, rowcount = 0; //Number of rows so  far and number of pegs in row
        //Initialize the pegs
        for (int x = 0; x < 15; x++) {
            pegs[x] = new Peg(rowx + rowcount, rowy);
            rowcount++;

            //Check end of row
            if (rowcount == 5 - rownum) {
                rowcount = 0;
                rowy++;
                rownum++;
                rowx += 0.5f;
            }
        }
        pegs[unPegged].isPegged=false;
    }

    public static class Peg {

        float xpos, ypos;
        boolean isPegged = true;

        Peg(float x, float y) {
            xpos = x;
            ypos = y;
        }

        boolean isNeighbour(Peg p) {
            return ((p.xpos <= xpos + 1 && p.xpos >= xpos - 1) && (p.ypos <= ypos + 1 && p.ypos >= ypos - 1));
        }
    }

}
