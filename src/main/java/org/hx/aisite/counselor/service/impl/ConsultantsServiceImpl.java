/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: fanyihao
 * 创建日期: 2024-06-13
 * 文件说明: 见类描述
 */
package org.hx.aisite.counselor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hx.aisite.counselor.dao.ConsultantsDao;
import org.hx.aisite.counselor.model.Consultants;
import org.hx.aisite.counselor.model.ConsultantsQueryReq;
import org.hx.aisite.counselor.model.ConsultantsVo;
import org.hx.aisite.counselor.service.ConsultantsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

/**
 * 存储咨询师详细信息的表服务实现类
 *
 * @author fanyihao
 * @date 2024-06-13
 */
@Service
public class ConsultantsServiceImpl extends ServiceImpl<ConsultantsDao, Consultants> implements ConsultantsService {

    /**
     * 存储咨询师详细信息的表(Consultants) 数据访问
     */
    @Resource
    private ConsultantsDao consultantsDao;

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author fanyihao
     */
    @Override
    public Consultants selectById(String id) {
        return consultantsDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @author fyh
     * @param queryReq:
     * @return org.hx.aisite.counselor.model.Consultants
     * @date 2024/6/13 19:55
     **/
    @Override
    public PageInfo<ConsultantsVo> queryCounselorList(ConsultantsQueryReq queryReq) {
        Page<ConsultantsVo> page = PageHelper.startPage(queryReq.getPageNum(), queryReq.getPageSize());

        List<ConsultantsVo> list = consultantsDao.queryCounselorList(queryReq);

        return page.toPageInfo();
    }
}

