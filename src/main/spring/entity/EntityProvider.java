package spring.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "provider", schema = "public", catalog = "postgres")
public class EntityProvider implements Serializable {
    private long id;
    private String name;
    private String url;
    private String remark;
    private Long minPay;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityProvider that = (EntityProvider) o;

        return id == that.id
                && (name != null ? name.equals(that.name) : that.name == null)
                && (url != null ? url.equals(that.url) : that.url == null)
                && (remark != null ? remark.equals(that.remark) : that.remark == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "min_pay")
    public Long getMinPay() {
        return minPay;
    }

    public void setMinPay(Long minPay) {
        this.minPay = minPay;
    }
}
