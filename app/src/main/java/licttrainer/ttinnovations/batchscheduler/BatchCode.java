package licttrainer.ttinnovations.batchscheduler;
public class BatchCode
{
    private Long id;
    private String batchCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchCode batchCode1 = (BatchCode) o;

        if (id != null ? !id.equals(batchCode1.id) : batchCode1.id != null) return false;
        return batchCode != null ? batchCode.equals(batchCode1.batchCode) : batchCode1.batchCode == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (batchCode != null ? batchCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BatchCode{" +
                "id=" + id +
                ", batchCode='" + batchCode + '\'' +
                '}';
    }
}
