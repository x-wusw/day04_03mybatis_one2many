package xiaowu.dao;

import org.apache.ibatis.annotations.Select;
import xiaowu.domain.Account;

import java.util.List;

public interface IAccountDao {
    @Select(value = "select * from account where uid=#{uid}")
    List<Account> findByUid(Integer userId);
}
