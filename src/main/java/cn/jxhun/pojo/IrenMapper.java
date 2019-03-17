package cn.jxhun.pojo;


import java.util.List;

public interface IrenMapper {
    List<Iren> selectIren();
    void updateUser(Iren iren);
    void insertUser(Iren iren);
}