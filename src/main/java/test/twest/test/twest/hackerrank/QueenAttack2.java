package test.twest.test.twest.hackerrank;


import java.util.*;

public class QueenAttack2 {
    public enum STEPS {UP, LEFT, RIGHT, DOWN, LEFT_UP, RIGHT_UP, LEFT_DOWN, RIGHT_DOWN}

    public static List<Tuple> getPossibleSteps(int boardSize, Tuple currentPosition, STEPS direction) {
        List<Tuple> result = new ArrayList<>();

        switch (direction) {
            case UP:
                for(int i = currentPosition.yCoord + 1; i <= boardSize; i++) {
                    Tuple local = new Tuple(currentPosition.xCoord, i);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

            case DOWN:
                for(int i = currentPosition.yCoord - 1; i >= 0; i--) {
                    Tuple local = new Tuple(currentPosition.xCoord, i);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

            case LEFT:
                for(int i = currentPosition.xCoord - 1; i >= 0; i--) {
                    Tuple local = new Tuple(i, currentPosition.yCoord);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

            case RIGHT:
                for(int i = currentPosition.xCoord + 1; i <= boardSize; i++) {
                    Tuple local = new Tuple(i, currentPosition.yCoord);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

            case LEFT_UP:
                for(int i = currentPosition.yCoord + 1, j = currentPosition.xCoord - 1; i <= boardSize && j >= 0; i++, j--) {
                    Tuple local = new Tuple(i, j);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

            case RIGHT_UP:
                for(int i = currentPosition.yCoord + 1, j = currentPosition.xCoord + 1; i <= boardSize && j < boardSize; i++, j++) {
                    Tuple local = new Tuple(i, j);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

            case LEFT_DOWN:
                for(int i = currentPosition.yCoord -1, j = currentPosition.xCoord - 1; i >= 0 && j >= 0; i--, j--) {
                    Tuple local = new Tuple(i, j);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

            case RIGHT_DOWN:
                for(int i = currentPosition.yCoord -1, j = currentPosition.xCoord + 1; i >= 0 && j <= boardSize; i--, j++) {
                    Tuple local = new Tuple(i, j);
                    if(canMove(local, boardSize)) {
                        result.add(local);
                    }
                }
                return result;

                default:
                    return new ArrayList<>(0);
        }
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Map<String, Integer> obstacleMap = new HashMap<String, Integer>();
        for (int[] o : obstacles) {
            String key = Integer.toString(o[0]) + "-" + Integer.toString(o[1]);
            obstacleMap.put(key, 1);
        }

        int[][] queenDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        int attackedSquares = 0;

        for (int[] direction : queenDirections) {
            int rQueen = r_q;
            int cQueen = c_q;

            while (true) {
                rQueen -= direction[0];
                cQueen -= direction[1];

                String newSquare = Integer.toString(rQueen) + "-" + Integer.toString(cQueen);

                if (rQueen < 1 || rQueen > n || cQueen < 1 || cQueen > n || obstacleMap.containsKey(newSquare)) {
                    break;
                }

                attackedSquares++;
            }
        }

        return attackedSquares;
    }


    public static boolean canMove(Tuple nextStep, int boardSize) {
        if((nextStep.xCoord >= 0 && nextStep.xCoord <= boardSize) && (nextStep.yCoord >= 0 && nextStep.yCoord <= boardSize)) {
            return true;
        }
        return false;
    }


    public static class Tuple {
        int xCoord;
        int yCoord;

        public Tuple(int xCoord, int yCoord) {
            this.xCoord = xCoord;
            this.yCoord = yCoord;
        }

        public int getxCoord() {
            return xCoord;
        }

        public void setxCoord(int xCoord) {
            this.xCoord = xCoord;
        }

        public int getyCoord() {
            return yCoord;
        }

        public void setyCoord(int yCoord) {
            this.yCoord = yCoord;
        }
    }


    public void test() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int topicsMax = -1;
        int teams = 0;
        int noTopics = 0;
        int count = 0;

        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        for(int j = 0; j < n; j++) {
            for(int k = j + 1; k < n; k++) {
                count = 0;
                for(int i = 0; i < m; i++) {
                    if((topic[k].charAt(i) != topic[j].charAt(i)) || (topic[k].charAt(i) == '1' && topic[j].charAt(i) == '1')) {
                        count++;
                    }
                }
                if(count > topicsMax) {
                    topicsMax = count;
                    teams = 1;
                }
                else if(count == topicsMax) {
                    teams++;

                }
            }
        }
        System.out.println(topicsMax);
        System.out.println(teams);
    }
}
