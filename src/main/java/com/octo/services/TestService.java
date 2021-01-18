package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);
    @Autowired
    VideoService videoService;

    public void firstSenario() {
        List<VideoDTO> lstVideoDTOS = new ArrayList<>();
        try
        {
            lstVideoDTOS = videoService.retrieveVideosByTagAndLevel(null, null);
            if(lstVideoDTOS.size()==0)
                System.out.println("aucun Video");
             else
             {
               for (VideoDTO vidTo : lstVideoDTOS)
                   System.out.println("Id : " + vidTo.getId() + " Url Youtube :"+vidTo.getUrl());
             }
        } catch (Exception E)
        {
            LOGGER.error("Error", E);
        }
    }

    public void secondSenario() {
        List<String> lstStr = new ArrayList<>();
        List<VideoDTO> lstVideoDTOS = new ArrayList<>();
        try
        {
            lstStr.add("test");
            lstVideoDTOS = videoService.retrieveVideosByTagAndLevel(lstStr, null);
            if(lstVideoDTOS.size()==0)
                System.out.println("aucun Video");
            else
            {
                for (VideoDTO vidTo : lstVideoDTOS)
                    System.out.println("Id : " + vidTo.getId() + " Url Youtube :"+vidTo.getUrl());
            }
        } catch (Exception E)
        {
            LOGGER.error("Error", E);
        }
    }

    public void ThirdSenario() {
        List<VideoDTO> lstVideoDTOS = new ArrayList<>();
        try
        {

            lstVideoDTOS = videoService.retrieveVideosByTagAndLevel(null, Level.EASY);
            if(lstVideoDTOS.size()==0)
                System.out.println("aucune Video");
            else
            {
                for (VideoDTO vidTo : lstVideoDTOS)
                    System.out.println("Id : " + vidTo.getId() + " Url Youtube :"+vidTo.getUrl());
            }
        } catch (Exception E)
        {
            LOGGER.error("Error", E);
        }
    }
    public void FourthSenario() {
        List<String> lstStr = new ArrayList<>();
        List<VideoDTO> lstVideoDTOS = new ArrayList<>();
        try
        {
            lstStr.add("test");
            lstVideoDTOS = videoService.retrieveVideosByTagAndLevel(lstStr, Level.EASY);
            if(lstVideoDTOS.size()==0)
                System.out.println("aucun Video");
            else
            {
                for (VideoDTO vidTo : lstVideoDTOS)
                    System.out.println("Id : " + vidTo.getId() + " Url Youtube :"+vidTo.getUrl());
            }
        } catch (Exception E)
        {
            LOGGER.error("Error", E);
        }
    }
}
