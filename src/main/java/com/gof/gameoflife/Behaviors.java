package com.gof.gameoflife;

import static com.gof.gameoflife.Main.*;

public class Behaviors extends Thread{
    public int aliveNeighbours;

    public Behaviors(){

    }

    public synchronized void run() {

        while (swtch) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.toString());
                swtch = true;
                return;
            }

            System.out.println("InProcess");
            int aliveNeighbours = 0;

            basedTable = new int[80][80];
            for (int i = 0; i < 80; i++) {
                for (int j = 0; j < 80; j++) {
                    aliveNeighbours = 0;

                    /*int verifPlusI = i==79 ? 0:i;
                    int verifMinusI = i==0 ? 79:i;
                    int verifPlusJ = j==79 ? 0:j;
                    int verifMinusJ = j==0 ? 79:j;*/

                    System.out.println(cellTable[i][(j+79-1)%79].isAlive());
                    if (cellTable[i][(j+79-1)%79].isAlive()) {
                        aliveNeighbours+=1;
                    }
                    if (cellTable[i][(j+79+1)%79].isAlive()) {
                        aliveNeighbours+=1;
                    }
                    if (cellTable[(i+79-1)%79][(j+79-1)%79].isAlive()) {
                        aliveNeighbours+=1;
                    }
                    if (cellTable[(i+79+1)%79][(j+79+1)%79].isAlive()) {
                        aliveNeighbours+=1;
                    }
                    if (cellTable[(i+79-1)%79][(j+79+1)%79].isAlive()) {
                        aliveNeighbours+=1;
                    }
                    if (cellTable[(i+79+1)%79][(j+79-1)%79].isAlive()) {
                        aliveNeighbours+=1;
                    }
                    if (cellTable[(i+79-1)%79][j].isAlive()) {
                        aliveNeighbours+=1;
                    }
                    if (cellTable[(i+79+1)%79][j].isAlive()) {
                        aliveNeighbours+=1;
                    }

                    System.out.println(aliveNeighbours);
                    //final cond
                    if (cellTable[i][j].isAlive()) {
                        if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                            basedTable[i][j] = 1;
                            System.out.println("INALIVECOND");
                        } else {
                            basedTable[i][j] = 0;
                        }
                    }

                    if (!cellTable[i][j].isAlive()) {
                        if (aliveNeighbours == 3) {
                            basedTable[i][j] = 1;
                            System.out.println("INDEADCOND");
                        } else {
                            basedTable[i][j] = 0;
                        }
                    }
                }




            }

        }


    }
}
