package com.springboot.management.mapper.sqlProvider;

import com.springboot.management.common.utils.PageVO;
import org.springframework.util.StringUtils;

public class LogSqlProvider {

    public String findAllByPage(PageVO pageVO){
        StringBuffer str = new StringBuffer("SELECT * FROM syslog ");
        if (!StringUtils.isEmpty(pageVO.getKey())){
            str.append("WHERE username like  '%"+pageVO.getKey()+"%'  ");
        }
        if (!StringUtils.isEmpty(pageVO.getSortBy())){
            StringBuffer stringBuffer = new StringBuffer(pageVO.getDesc()?"ASC":"DESC");
            str.append("ORDER BY "+ pageVO.getSortBy() + " "+stringBuffer);
        }
        return str.toString();
    }
}
