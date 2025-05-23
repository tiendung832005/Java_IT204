package com.data.session11.entity;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Movie {


    private Integer id;

    @NotBlank(message = "Tên phim không được để trống!")
    @Size(max = 100, message = "Tên phim không được vượt quá 100 ký tự!")
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống!")
    @Size(max = 50, message = "Đạo diễn không được vượt quá 50 ký tự!")
    private String director;

    private LocalDate releaseDate;

    @NotBlank(message = "Thể loại không được để trống!")
    @Size(max = 30, message = "Thể loại không được vượt quá 30 ký tự!")
    private String genre;

    private String poster;
}
