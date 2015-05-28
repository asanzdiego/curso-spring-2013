package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static SessionFactory sf;

  public static SessionFactory getSessionFactory() {

    if (sf == null)
      sf = new Configuration().configure("cfg/hibernate.cfg.xml")
          .buildSessionFactory();

    return sf;
  }

}
