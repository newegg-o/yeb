package com.xxxx.server.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日期转换
 *
 * @author 呵呵厉害了
 * @date 2021/03/24 22:42
 **/
@Component
public class DateConvert implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String s) {

        try {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
