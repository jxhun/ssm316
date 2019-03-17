package cn.jxhun.service;

import cn.jxhun.pojo.Iren;
import cn.jxhun.pojo.IrenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/15
 * Description:
 * Version: V1.0
 */
@Service
public class IrenService {

    @Autowired
    private final IrenMapper irenMapper;

    public IrenService(IrenMapper irenMapper) {
        this.irenMapper = irenMapper;
        System.out.println("--------------------------IrenService构造函数");
    }


    public IrenMapper getUserMapper() {
        return irenMapper;
    }

    public List<Iren> selectUser() {
        return irenMapper.selectIren();
    }

    public void updateUser(Iren iren) {
        irenMapper.updateUser(iren);
    }

    /*
     在@Transactional注解中如果不配置rollbackFor属性,那么事务只在RuntimeException的时候才会回滚,
     加上rollbackFor=Exception.class,可以让事务在遇到任意异常时都回滚
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(List<Iren> irenList) throws Exception {
        for (Iren iren : irenList) {
            irenMapper.insertUser(iren);
        }
    }

}
