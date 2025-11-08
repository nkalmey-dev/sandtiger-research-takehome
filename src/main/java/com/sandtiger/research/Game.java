package com.sandtiger.research;

public class Game{

    enum FrameType{
        STRIKE,
        SPARE,
        DEFAULT
    }

    private final int[] rolls = new int[21];
    private int rollCount = 0;

    public void roll(int pins){
        rolls[rollCount++] = pins;
    }

    private FrameType frameType(int idx){
        if (rolls[idx] == 10) return FrameType.STRIKE;
        if (rolls[idx] + rolls[idx + 1] == 10) return FrameType.SPARE;
        return FrameType.DEFAULT;
    }

    public int score(){
        int score = 0;
        int i = 0;

        for(int frame = 0; frame < 10; frame++){
            FrameType type = frameType(i);

            switch(type){
                case STRIKE:
                    score += 10 + rolls[i + 1] + rolls[i + 2];
                    i += 1;
                    break;

                case SPARE:
                    score += 10 + rolls[i + 2];
                    i += 2;
                    break;

                case DEFAULT:
                    score += rolls[i] + rolls[i + 1];
                    i += 2;
                    break;
            }
        }

        return score;
    }

    public static void main(String[] args){
        System.out.println("Hi there SandTiger!");
    }


}
