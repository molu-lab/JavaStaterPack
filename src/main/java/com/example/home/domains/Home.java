package com.example.home.domains;

import lombok.Data;

import java.util.Date;

@Data
public class Home {
    int hid;
    String name;
    String origin;
    String home_url;
    String notice_url;
    String dliv_url;
    String mlsv_url;
    Date create_date;
}
