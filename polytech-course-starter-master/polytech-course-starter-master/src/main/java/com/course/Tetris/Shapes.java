package com.course.Tetris;

import java.util.Random;

public class Shapes {
    final static int Z[][][]={
            {
                    {1,1,0},
                    {0,1,1},
                    {0,0,0}
            },
            {
                    {0,0,1},
                    {0,1,1},
                    {0,1,0}
            },
            {
                    {0,0,0},
                    {1,1,0},
                    {0,1,1}
            },
            {
                    {0,1,0},
                    {1,1,0},
                    {1,0,0}
            }
    };

    final static int S[][][]={
            {
                    {0,1,1},
                    {1,1,0},
                    {0,0,0}
            },

            {
                    {1,0,0},
                    {1,1,0},
                    {0,1,0}
            },
            {
                    {0,0,0},
                    {0,1,1},
                    {1,1,0}
            },
            {
                    {1,0,0},
                    {1,1,0},
                    {0,1,0}
            }
    };

    final static int T[][][]={
            {
                    {1,1,1},
                    {0,1,0},
                    {0,0,0}
            },
            {
                    {0,1,0},
                    {1,1,0},
                    {0,1,0}
            },
            {
                    {0,1,0},
                    {1,1,1},
                    {0,0,0}
            },
            {
                    {0,1,0},
                    {0,1,1},
                    {0,1,0}
            }

    };

    final static int J[][][]={
            {
                    {0,1,0},
                    {0,1,0},
                    {1,1,0}
            },

            {
                    {0,0,0},
                    {1,0,0},
                    {1,1,1}
            },

            {
                    {0,1,1},
                    {0,1,0},
                    {0,1,0}
            },

            {
                    {0,0,0},
                    {1,1,1},
                    {0,0,1}
            }
    };

    final static int L[][][]={
            {
                    {0,1,0},
                    {0,1,0},
                    {0,1,1}
            },

            {
                    {0,0,0},
                    {0,0,1},
                    {1,1,1}
            },

            {
                    {1,1,0},
                    {0,1,0},
                    {0,1,0}
            },

            {
                    {0,0,0},
                    {1,1,1},
                    {1,0,0}
            }
    };

    final static int I[][][]={
            {
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0}
            },
            {
                    {0,0,0,0},
                    {1,1,1,1},
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };

    final static int O[][][]={
            {
                    {1,1},
                    {1,1}
            }
    };
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    static int[][][] getRandomShape() {
        int randomValue = getRandomNumberInRange(0, 6);
        switch (randomValue) {
            case 6:
                return Z;
            case 5:
                return S;
            case 4:
                return T;
            case 3:
                return J;
            case 2:
                return L;
            case 1:
                return I;
            default:
                return O;
        }
    }
}
