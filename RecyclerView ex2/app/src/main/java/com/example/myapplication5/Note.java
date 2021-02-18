package com.example.myapplication5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private Integer id;
    private String title;
    private String subTitle;
    private Integer min;
}
