package com.data.session06.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categories {
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean status;
}
