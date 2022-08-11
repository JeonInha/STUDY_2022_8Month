package signUp;

import java.util.List;

public interface AccManagerDao {
	
	//// crud로 함 ..
	//c
	int createNewAccount(Account user);
	
	//r
	Account readAccountByCode(int name);
	Account readAccountByNickname(String name);
	Account readAccountById(String id);
	List<Account> readAllAccount();
	
	//u
	int updateFollowing(Account user);
	int updateFollower(Account user);
	int changeNickName(Account user);
	
	//d
	int deleteAccount(Account user);
	
}
