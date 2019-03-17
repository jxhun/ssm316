package cn.jxhun.controller;

import cn.jxhun.pojo.Iren;
import cn.jxhun.service.IrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/15
 * Description:
 * Version: V1.0
 */
@Controller
public class IrenController {

    @Autowired
    private final IrenService insertUser;

    public IrenController(IrenService insertUser) {
        this.insertUser = insertUser;
        System.out.println("--------------------------IrenController构造函数");
    }


    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectUser() {
        System.out.println("UserAction -------------------------- selectUser");

        List<Iren> list = new ArrayList<>();
        Iren iren = new Iren();
        iren.setXingming("kkk0");
        iren.setsId(25);
        list.add(iren);

        iren = new Iren();
        iren.setXingming("kkk1");
        iren.setsId(23);
        list.add(iren);

        iren = new Iren();
        iren.setXingming("kkk2");
        iren.setsId(16);
        list.add(iren);

        try {
            insertUser.insertUser(list);
        } catch (Exception e) {
            System.out.println("---------------------------------------------------sql出错");
            e.printStackTrace();
        }
        List<Iren> list0 = insertUser.selectUser();
        Map<String, Object> map = new HashMap<>();
        for (Iren ir : list0) {

        }
        map.put("data", list0);
        return map;
    }

}
