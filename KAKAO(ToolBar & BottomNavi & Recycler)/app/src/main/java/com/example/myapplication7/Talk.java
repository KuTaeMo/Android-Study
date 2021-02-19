package com.example.myapplication7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talk {
    private Integer id;
    private String content;
    private String username;
    private String min;
}
