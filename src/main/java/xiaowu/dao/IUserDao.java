package xiaowu.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import xiaowu.domain.User;

import java.util.List;

public interface IUserDao {
    @Select(value = "select * from user")
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "id",property = "accounts",
            many =@Many(
                    select = "xiaowu.dao.IAccountDao.findByUid",
                    fetchType = FetchType.LAZY
            )
            )
    })
    List<User> findAll();
}
