package com.ayan.spring.webapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {

    private Long id;
    private String description;
}
