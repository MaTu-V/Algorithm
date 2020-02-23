package kruskal;

public class EData implements Comparable<EData>{
    private char start;
    private char end;
    private int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<" +
                 start +
                ", " + end +
                "> = " + weight;
    }

    @Override
    public int compareTo(EData o) {
        return this.weight - o.weight;
    }
}
