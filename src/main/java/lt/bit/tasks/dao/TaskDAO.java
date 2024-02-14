
package lt.bit.tasks.dao;

import lt.bit.tasks.data.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskDAO extends JpaRepository<Task, Integer>{
    
}
