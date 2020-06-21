package base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbSession {

	private static Session dbSession = null;
	
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static Session sessionStart() throws DbException {
		try {
			dbSession = factory.openSession();
			dbSession.beginTransaction();
			return dbSession;
		} catch (Exception e) {
			throw new DbException(e + "Problem in Connection");
		}
	}

	public static void sessionEnd() {
		dbSession.getTransaction().commit();
		dbSession.close();
	}

}
