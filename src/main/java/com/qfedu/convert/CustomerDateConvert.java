package com.qfedu.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CustomerDateConvert implements Converter<String, Date> {
    private SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")
    };

    @Override
    public Date convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        for (SimpleDateFormat sdf : sdfs) {
            try {
                //将sdfs数组解析为date类型
                return sdf.parse(s);
            } catch (ParseException e) {
                //e.printStackTrace();

                continue;
            }
        }
        return null;
    }
}
