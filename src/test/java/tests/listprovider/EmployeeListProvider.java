package tests.listprovider;

import com.markbudai.openfleet.dao.repositories.EmployeeRepository;
import com.markbudai.openfleet.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 26..
 */
public class EmployeeListProvider implements EmployeeRepository {

    private List<Employee> storage;

    public EmployeeListProvider(){
        storage = new ArrayList<>();
    }

    public void preload(List<Employee> list){
        storage.clear();
        storage.addAll(list);
    }

    @Override
    public void add(Employee employee) {
        storage.add(employee);
    }

    @Override
    public void update(Employee employee) {
        storage.remove(getById(employee.getId()));
        storage.add(employee);
    }

    @Override
    public Employee getById(long id) {
        for(Employee e : storage){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return storage;
    }
}
