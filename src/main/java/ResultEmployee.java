import java.util.Comparator;

public class ResultEmployee implements Comparable<ResultEmployee> {
    private String name;
    private double score;

    public ResultEmployee(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(ResultEmployee o) {
        return Comparator.comparing(ResultEmployee::getScore)
                .thenComparing(ResultEmployee::getName).reversed()
                .compare(this, o);
    }

    public String toString() {
        return String.format("%s, %.2f%n", this.getName(), this.getScore());
    }
}
