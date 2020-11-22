package com.example.kaoyan.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface FileMapper {

    @Insert("insert into file(file_name,content,date) values(#{VidoeName},#{content},#{date})")
    void insertFile(@Param("VidoeName") String VidoeName, @Param("content")  String content,@Param("date")String date);
}
