package invoiceserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import invoiceserver.model.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {
	@Query(value = "select * from users where user_name = :userName and user_password = :password", nativeQuery = true)
	 List<Users> tryLogin(String userName , String password);
}
