import com.sav.background.biz.SysUserBiz;
import com.sav.background.entity.SysUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by kaikai on 2018/1/23.
 */
public class MapperTest extends BaseUnitTest{


    @Autowired
    private SysUserBiz sysUserBiz;

    @Test
    public void TestMapper(){
        SysUser sysUser = sysUserBiz.selectByName();
        System.out.println(sysUser.getUsername());
    }

}
