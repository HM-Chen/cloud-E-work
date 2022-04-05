package com.xxxx.server.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxxx.server.pojo.MailConstants;
import com.xxxx.server.pojo.TEmployee;
import com.xxxx.server.pojo.TMailLog;
import com.xxxx.server.service.ITEmployeeService;
import com.xxxx.server.service.ITMailLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MailTask {
    @Autowired
    private ITMailLogService itMailLogService;
    @Autowired
    private ITEmployeeService itEmployeeService;
    private RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask(){
        List<TMailLog> list = itMailLogService.list(new QueryWrapper<TMailLog>().eq("status",0).lt("tryTime",
                LocalDateTime.now()));
        list.forEach(tMailLog -> {
            if (3 <= tMailLog.getCount()) {
                itMailLogService.update(new UpdateWrapper<TMailLog>().set("status",2).eq("msgId",tMailLog.getMsg_id()));
            }
            itMailLogService.update(new UpdateWrapper<TMailLog>().set("cout",tMailLog.getCount()+1).set(
                    "updateTime",LocalDateTime.now()).set("tryTime",LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT)));
            TEmployee emp = itEmployeeService.getEmployee(tMailLog.getEid()).get(0);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME,MailConstants.MAIL_ROUTING_KEY_NAME,emp,new CorrelationData(tMailLog.getMsg_id()));
        });
    }
}
