package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoToVideoDTOMapper videoToVideoDTOMapper;

    //Pour avoir les informations,c'est juste pour le teste !!
    public List<Video> findallVideos() {
        List<Video> lstVideos = new ArrayList<>();
        try{
            lstVideos = videoRepository.findAll();
        }
        catch(Exception E){
            LOGGER.error("Error",E);
        }
            return lstVideos;
    }
    //-------------------------------------------------------------

    public List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level) {
        List<Video> lstVideos = null;
        List<VideoDTO>  lstvideoDTO = new ArrayList<>();
      try{
          // TODO code goes here
          // 1. search videos by tags AND/OR level
          if(tags != null && level != null)
          {
              lstVideos = videoRepository.findByTagsAndLevel(tags,level);
          }
          else if(tags == null && level != null)
          {
              lstVideos = videoRepository.findByLevel(level);
          }
          else if (tags != null && level == null)
          {
              lstVideos = videoRepository.findByTags(tags);
          }
          else
          {
              lstVideos = videoRepository.findAll();
          }
          // 2. use videoToVideoDTOMapper to map videos to videos DTO
          if(lstVideos != null)
          {
              for (Video vid : lstVideos)
                  lstvideoDTO.add(videoToVideoDTOMapper.convert(vid));
          }

      }
      catch(Exception E){
          LOGGER.error("Error",E);
      }
        // 3 return the list
        return lstvideoDTO;

    }


}
