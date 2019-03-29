import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class EmplyeeDAOimpl implements EmplyeeDAO{
    Statement stmt = null;
    ResultSet rs = null;
    Connection con =null;
    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useLegacyDatetimeCode=false&serverTimezone=UTC","root","monitor121");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Optional findOne(Integer id) {
            connect();
            Employee emp= new Employee();;
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM employee WHERE id = "+id);
                rs.next();
                emp = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("salary"));
                stmt.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return Optional.ofNullable(emp);
    }

    public List findAll() {

        ObservableList<Employee> f = FXCollections.observableArrayList();
        connect();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee");
            while(rs.next())
            { Employee x = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("salary"));
             f.add(x);
            };
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }

    public Optional findByName(String name) {
        connect();
        Employee d = new Employee();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee WHERE name = '"+name+"'");
            rs.next();
            d = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("salary"));
            stmt.close();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }
        return Optional.ofNullable(d);

    }

    public void delete(Employee employee) {
    connect();
        try {
            stmt.close();
            PreparedStatement rs1 = con.prepareStatement("DELETE FROM employee WHERE id = ? ");
            rs1.setInt(1, employee.getId());
            rs1.execute();
            System.out.println("Pracownik zostal usuniety");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Employee employee) {
        connect();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee WHERE id = "+employee.getId());
        if(rs.next())
        {
            stmt.close();
            PreparedStatement stmt1 = con.prepareStatement("UPDATE employee SET name = ?, email=?, salary =? WHERE id= ?");
            stmt1.setString(1,employee.getName());
            stmt1.setString(2,employee.getEmail());
            stmt1.setString(3,employee.getSalary());
            stmt1.setInt(4,employee.getId());
            stmt1.execute();
            System.out.println("Pracownik o id: "+employee.getId()+" zostal zaaktualizowany.");
        }
        else {
            stmt.close();
            PreparedStatement stmt1 = con.prepareStatement("INSERT INTO employee VALUES(?,?,?,?)");
            stmt1.setInt(1, employee.getId());
            stmt1.setString(2, employee.getName());
            stmt1.setString(3, employee.getEmail());
            stmt1.setString(4, employee.getSalary());
            stmt1.execute();
            System.out.println("Pracownik o id: "+employee.getId()+" zostal dodany.");
            stmt.close();
        }}
        catch (SQLException e)
        {
           e.printStackTrace();
        }


    }
}
