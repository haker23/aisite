package org.hx.aisite.interviewrecords.control;

import com.github.pagehelper.PageInfo;
import org.hx.aisite.interviewrecords.model.InterviewRecords;
import org.hx.aisite.interviewrecords.model.InterviewRecordsQueryReq;
import org.hx.aisite.interviewrecords.model.InterviewRecordsVo;
import org.hx.aisite.interviewrecords.service.InterviewRecordsService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 存储咨询访谈详细记录的表Control层
 *
 * @author zhanggk
 * @date 2024-06-14
 */
@Controller
public class InterviewRecordsControl {

    /**
     * 存储咨询访谈详细记录的表 服务接口
     */
    @Resource
    private InterviewRecordsService interviewRecordsService;

    /**
     * 存储咨询访谈详细记录的表获取单条数据数据
     *
     * @param id 主键id
     * @return
     * @author zhanggk
     */
    @RequestMapping(value = "/interviewrecords/interviewrecords/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InterviewRecordsVo getInterviewRecordsById(@PathVariable("id") String id) {
        return (InterviewRecordsVo) interviewRecordsService.selectById(id);
    }

    /**
     * 存储咨询访谈详细记录的表分页查询
     *
     * @param queryReq 存储咨询访谈详细记录的表(InterviewRecords)信息
     * @return
     * @author zhanggk
     */
    @RequestMapping(value = "/interviewrecords/interviewrecords/query", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageInfo<InterviewRecordsVo> queryInterviewRecords(@RequestBody InterviewRecordsQueryReq queryReq) {
        return interviewRecordsService.selectPageList(queryReq);
    }

    @RequestMapping(value = "/interviewrecords/interviewrecords/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void save(@RequestBody InterviewRecordsVo interviewRecordsVo) {
        interviewRecordsService.save(interviewRecordsVo);
    }
}
