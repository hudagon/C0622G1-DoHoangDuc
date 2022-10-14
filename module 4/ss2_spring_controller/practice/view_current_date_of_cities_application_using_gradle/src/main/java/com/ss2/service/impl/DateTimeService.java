package com.ss2.service.impl;

import com.ss2.service.IDateTimeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TimeZone;

@Service
public class DateTimeService implements IDateTimeService {

    @Override
    public String getDateTime(String city) {
        Date date = new Date();

        TimeZone local = TimeZone.getDefault();

        TimeZone locale = TimeZone.getTimeZone(city);

        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());

        date.setTime(locale_time);

        return date.toString();
    }
}
