package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityCaruselSchedule;
import spring.interfaces.CaruselScheduleDao;
import spring.repositories.CaruselScheduleRepository;

import java.sql.CallableStatement;
import java.sql.Date;
import java.util.List;

@Service("jpaCaruselSchedule")
@Repository
@Transactional
public class CaruseleScheduleImpl implements CaruselScheduleDao {

    private final
    CaruselScheduleRepository repository;

    @Autowired
    public CaruseleScheduleImpl(CaruselScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public EntityCaruselSchedule save(EntityCaruselSchedule caruselSchedule) {
        return repository.save(caruselSchedule);
    }


    @Override
    public List<EntityCaruselSchedule> findBeforeDatef(Date datef, Date dates) {
        return repository.findByDateFAfterAndDateSBefore(datef, dates);
    }
}
