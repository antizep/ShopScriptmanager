package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityCaruselSchedule;

import java.sql.Date;
import java.util.List;

public interface CaruselScheduleRepository extends CrudRepository<EntityCaruselSchedule, Long> {

    List<EntityCaruselSchedule> findByDateFBeforeAndDateSAfter(Date dateF, Date dateS);

}
