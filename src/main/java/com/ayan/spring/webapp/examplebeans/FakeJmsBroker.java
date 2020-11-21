package com.ayan.spring.webapp.examplebeans;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakeJmsBroker {

    String user;
    String password;
    String url;

}
