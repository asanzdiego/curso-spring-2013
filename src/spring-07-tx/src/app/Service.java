package app;

import java.util.ArrayList;
import java.util.List;

import model.Persona;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.IPersonaDAO;

public class Service {

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void savePersonas(final ApplicationContext appCtx) {

    final IPersonaDAO dao = (IPersonaDAO) appCtx.getBean("miDao");

    final List<Persona> personas = new ArrayList<Persona>();

    final Persona p1 = new Persona();
    p1.setEdad(23);
    p1.setNombre("asd");
    personas.add(p1);

    final Persona p2 = new Persona();
    p2.setEdad(9);
    p2.setNombre("zxc"); // va a dar error al insertar y debería hacer rollback
    personas.add(p2);

    dao.savePersonas(personas);
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void save(final ApplicationContext appCtx) {

    final IPersonaDAO dao = (IPersonaDAO) appCtx.getBean("miDao");

    final Persona p1 = new Persona();
    p1.setEdad(11);
    p1.setNombre("qwe");

    dao.save(p1);
  }
}
