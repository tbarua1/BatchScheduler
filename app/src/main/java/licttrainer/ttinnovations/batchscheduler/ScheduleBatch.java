package licttrainer.ttinnovations.batchscheduler;
import java.util.Date;
public class ScheduleBatch
{
    private Long id;
    private Date date;
    // private Date time;
    private String university,trainer,batchcode;
    private String Status;
    private Date till;

    public Date getTill() {
        return till;
    }

    public void setTill(Date till) {
        this.till = till;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainer() {
        return trainer;
    }

    @Override
    public String toString() {
        return "ScheduleBatch{" +
                "id=" + id +
                ", date=" + date +
               // ", time=" + time +
                ", university='" + university + '\'' +
                ", trainer='" + trainer + '\'' +
                ", batchcode='" + batchcode + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
       // result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (trainer != null ? trainer.hashCode() : 0);
        result = 31 * result + (batchcode != null ? batchcode.hashCode() : 0);
        result = 31 * result + (Status != null ? Status.hashCode() : 0);
        return result;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getBatchcode() {
        return batchcode;
    }

    public void setBatchcode(String batchcode) {
        this.batchcode = batchcode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }*/

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleBatch that = (ScheduleBatch) o;

        if (university != that.university) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
       // if (time != null ? !time.equals(that.time) : that.time != null) return false;
        return Status != null ? Status.equals(that.Status) : that.Status == null;

    }


}
