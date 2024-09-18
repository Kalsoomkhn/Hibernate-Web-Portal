package first21;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_ID;
    private String departmentName;

    public department() {
    }

    public department(int departmentId, String departmentName) {
        this.department_ID = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return department_ID;
    }

    public void setDepartmentId(int departmentId) {
        this.department_ID = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "department [departmentId=" + department_ID + ", departmentName=" + departmentName + "]";
    }

    public static void saveDepartment(int departmentId, String departmentName) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Replace with your config file path
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            department dept = new department(departmentId, departmentName);
            session.save(dept);
            tx.commit();
        } catch (Exception e) { 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}