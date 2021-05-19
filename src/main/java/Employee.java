
public class Employee {
    private String name;
    private Long totalSales;
    private Long salesPeriod;
    private Double experienceMultiplier;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Long totalSales) {
        this.totalSales = totalSales;
    }

    public Long getSalesPeriod() { return salesPeriod; }

    public void setSalesPeriod(Long salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    public Double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public void setExperienceMultiplier(Double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }
}
