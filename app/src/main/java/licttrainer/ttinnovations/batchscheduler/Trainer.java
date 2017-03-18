package licttrainer.ttinnovations.batchscheduler;
import java.util.Date;
public class Trainer
{
    private Long id;
    private String name, qualification, skillset, experience, natianality, mobile,
            skype, username, password, emailid, usertype,date,whatsapp;

    private Date registeredDate;

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSkillset() {
        return skillset;
    }

    public void setSkillset(String skillset) {
        this.skillset = skillset;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNatianality() {
        return natianality;
    }

    public void setNatianality(String natianality) {
        this.natianality = natianality;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", skillset='" + skillset + '\'' +
                ", experience='" + experience + '\'' +
                ", natianality='" + natianality + '\'' +
                ", mobile='" + mobile + '\'' +
                ", skype='" + skype + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailid='" + emailid + '\'' +
                ", usertype='" + usertype + '\'' +
                ", registeredDate=" + registeredDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainer trainer = (Trainer) o;

        if (id != null ? !id.equals(trainer.id) : trainer.id != null) return false;
        if (name != null ? !name.equals(trainer.name) : trainer.name != null) return false;
        if (qualification != null ? !qualification.equals(trainer.qualification) : trainer.qualification != null)
            return false;
        if (skillset != null ? !skillset.equals(trainer.skillset) : trainer.skillset != null)
            return false;
        if (experience != null ? !experience.equals(trainer.experience) : trainer.experience != null)
            return false;
        if (natianality != null ? !natianality.equals(trainer.natianality) : trainer.natianality != null)
            return false;
        if (mobile != null ? !mobile.equals(trainer.mobile) : trainer.mobile != null) return false;
        if (skype != null ? !skype.equals(trainer.skype) : trainer.skype != null) return false;
        if (username != null ? !username.equals(trainer.username) : trainer.username != null)
            return false;
        if (password != null ? !password.equals(trainer.password) : trainer.password != null)
            return false;
        if (emailid != null ? !emailid.equals(trainer.emailid) : trainer.emailid != null)
            return false;
        if (usertype != null ? !usertype.equals(trainer.usertype) : trainer.usertype != null)
            return false;
        return registeredDate != null ? registeredDate.equals(trainer.registeredDate) : trainer.registeredDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        result = 31 * result + (skillset != null ? skillset.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (natianality != null ? natianality.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (emailid != null ? emailid.hashCode() : 0);
        result = 31 * result + (usertype != null ? usertype.hashCode() : 0);
        result = 31 * result + (registeredDate != null ? registeredDate.hashCode() : 0);
        return result;
    }
}
