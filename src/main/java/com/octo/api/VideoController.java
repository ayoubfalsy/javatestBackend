package com.octo.api;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;

import com.octo.holders.ApiPaths;
import com.octo.holders.ParamDescription;
import com.octo.services.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Gestion de la videothèque")
@RequestMapping(value = ApiPaths.V1)
public class VideoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);
    @Autowired
    private VideoService videoService;

    @ApiOperation(value = " Liste des videos des cours par tags ou/et niveau")
    @GetMapping(value = ApiPaths.VIDEOS, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<VideoDTO> getVideos(@ApiParam(value = ParamDescription.LEVEL_PARAM) @RequestParam(required = false) Level level,
                                    @ApiParam(value = ParamDescription.TAGS_PARAM) @RequestParam(required = false) List<String> tags) {
        LOGGER.info("Récupération des videos des cours par tags ou/et niveau");
        return videoService.retrieveVideosByTagAndLevel(tags, level);
    }
}
