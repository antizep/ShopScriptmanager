package spring.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Table(name = "carusel_schedule")
@Entity
public class EntityCaruselSchedule {
    private long id;
    private String remark;
    private Date dateS;
    private Date dateF;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Basic
    @Column(name = "dates")
    public Date getDateS() {
        return dateS;
    }
    public void setDateS(Date dateS) {
        this.dateS = dateS;
    }

    @Basic
    @Column(name = "datef")
    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }

    public Date getDateF() {
        return dateF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityCaruselSchedule that = (EntityCaruselSchedule) o;
        return id == that.id &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(dateS, that.dateS) &&
                Objects.equals(dateF, that.dateF);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, remark, dateS, dateF);
    }
}
