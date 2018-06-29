package spring.interfaces;

import spring.entity.EntityCaruselSchedule;

import java.sql.Date;
import java.util.List;

public interface CaruselScheduleDao {

    EntityCaruselSchedule save(EntityCaruselSchedule caruselSchedule);
    List<EntityCaruselSchedule> findBeforeDatef(Date datef, Date dates);

}
