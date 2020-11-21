package com.ayan.spring.webapp.examplebeans;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakeDataSource {

    private String user;
    private String password;
    private String url;

}


