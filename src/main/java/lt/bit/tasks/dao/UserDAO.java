
package lt.bit.tasks.dao;


import lt.bit.tasks.data.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Integer>{
    
}
