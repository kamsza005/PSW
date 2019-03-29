import java.util.List;
import java.util.Optional;

public interface EmplyeeDAO {
    /** * Zwraca pracownika o podanym id */
    Optional findOne(Integer id);
    /** * Zwraca wszystkich pracowników */
    List findAll();
    /** * Zwraca pracownika o podanym nazwisku */
    Optional findByName(String name);
    /** * Usuwa pracownika */
    void delete(Employee employee);
    /** * Dodaje, jeśli brak, lub aktualizuje pracownika */
    void save(Employee employee);
    void connect();
}
