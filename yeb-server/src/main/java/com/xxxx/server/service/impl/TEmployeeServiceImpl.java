package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.TEmployeeMapper;
import com.xxxx.server.mapper.TMailLogMapper;
import com.xxxx.server.pojo.*;
import com.xxxx.server.service.ITEmployeeService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TEmployeeServiceImpl extends ServiceImpl<TEmployeeMapper, TEmployee> implements ITEmployeeService {

    @Autowired
    private TEmployeeMapper tEmployeeMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private TMailLogMapper tMailLogMapper;

    @Override
    public RespPageBean getEmployeeByPage(Integer currentPage, Integer size, TEmployee tEmployee, LocalDate[] beginDateScope) {
        Page<TEmployee> page = new Page<>(currentPage,size);
        IPage<TEmployee> employeeByPage = tEmployeeMapper.getEmployeeByPage(page,tEmployee,beginDateScope);
        RespPageBean respPageBean = new RespPageBean(employeeByPage.getTotal(), employeeByPage.getRecords());
        return respPageBean;
    }

    @Override
    public RespBean maxWorkID() {
        List<Map<String, Object>> maps = tEmployeeMapper.selectMaps(new QueryWrapper<TEmployee>().select("max(workID)"));

        return RespBean.success(null,String.format("%08d",Integer.parseInt(maps.get(0).get("max(workID)").toString())+1));
    }

    @Override
    public RespBean addEmp(TEmployee tEmployee) {
        LocalDateTime beginContract = tEmployee.getBegin_contract();
        LocalDateTime endContract = tEmployee.getEnd_contract();
        long days = beginContract.until(endContract, ChronoUnit.DAYS);
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        tEmployee.setContract_term(Double.parseDouble(decimalFormat.format(days/365.00)));
        if(1 == tEmployeeMapper.insert(tEmployee)){
            TEmployee emp = tEmployeeMapper.getEmployee(tEmployee.getId()).get(0);
            //数据库记录发送的消息
            String msgId = UUID.randomUUID().toString();
            TMailLog tMailLog = new TMailLog();
            tMailLog.setMsg_id(msgId);
            tMailLog.setEid(tEmployee.getId());
            tMailLog.setStatus(0);
            tMailLog.setRoute_key(MailConstants.MAIL_ROUTING_KEY_NAME);
            tMailLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            tMailLog.setCount(0);
            tMailLog.setTry_time(LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT));
            tMailLog.setCreate_time(LocalDateTime.now());
            tMailLog.setUpdate_time(LocalDateTime.now());
            tMailLogMapper.insert(tMailLog);
            //发送消息
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(msgId));
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @Override
    public List<TEmployee> getEmployee(Integer id) {

        return tEmployeeMapper.getEmployee(id);
    }
}
