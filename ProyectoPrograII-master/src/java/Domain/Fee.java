package Domain;
/**
 * @author Samuel
 */
public class Fee{
    private long fee;
    private String carDescription;

    public Fee() {
    }

    public Fee(long fee, String description) {
        this.fee = fee;
        this.carDescription = description;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return carDescription;
    }

    public void setDescription(String description) {
        this.carDescription = description;
    }
}