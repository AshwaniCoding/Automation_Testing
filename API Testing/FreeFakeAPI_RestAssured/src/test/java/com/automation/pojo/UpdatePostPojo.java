package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UpdatePostPojo {

    int id;
    String title;
    String content;
    String slug;
    String picture;
    int user;
}
