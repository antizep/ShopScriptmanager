package spring.tst;

import org.springframework.context.support.GenericXmlApplicationContext;
import spring.entity.EntityAuntification;
import spring.interfaces.AuntificationService;

import javax.persistence.NoResultException;

public class TstJPA {
    public static void tst(String i, String m) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("Jpa_Config.xml");
        ctx.refresh();
        AuntificationService service = ctx.getBean("jpaAuntificationService", AuntificationService.class);
        //запускаем все сервисы

        EntityAuntification auntification = new EntityAuntification();
        auntification.setLogin("parazit");
        auntification.setPassword("3333");

        service.save(auntification);
        System.out.println(auntification.getUserId());

        try {
            EntityAuntification e = service.auntification(i + "", m + "");
            e.setPassword("22222");
            service.update(e);
            System.out.println("welcome " + e.getLogin() + " you id:" + e.getUserId());

        } catch (NoResultException e) {
            System.out.println("некорректные данные");
        }


    }

    //выдаем экземпляр сервиса
    //как получить поток?????
}
