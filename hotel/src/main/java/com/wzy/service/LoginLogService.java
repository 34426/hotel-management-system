package com.wzy.service;

import com.wzy.page.Page;
import com.wzy.pojo.Loginlog;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: wzy
 * @Date: 2021/04/05/19:52
 * @Description:
 */
public interface LoginLogService {
    public int saveLoginLog(Loginlog loginlog);

    public List<Loginlog> selectAll();

    //分页加模糊查询
    public Page<Loginlog> pageFuzzyselect(String loginName, Page<Loginlog> vo);

    public void updateLoginLogById(Loginlog loginlog);

    public Loginlog selectOne(Integer id);

    void deleteByUserId(int parseInt);
}
