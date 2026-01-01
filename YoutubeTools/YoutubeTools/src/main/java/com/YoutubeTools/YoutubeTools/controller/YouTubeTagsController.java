package com.YoutubeTools.YoutubeTools.controller;


import com.YoutubeTools.YoutubeTools.model.SearchVideo;
import com.YoutubeTools.YoutubeTools.service.YouTubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/youtube")
public class YouTubeTagsController {

        @Autowired
        private YouTubeService youTubeService;
        @Value("${youtube.api.key}")
        private String apiKey;

        private boolean isApiKeyConfiguried(){
            return apiKey!=null && !apiKey.isEmpty();
        }

        @PostMapping("/search")
        public String videoTags(@RequestParam ("videoTitle") String videoTitle , Model model) {
            if (!isApiKeyConfiguried()) {
                model.addAttribute("error", "api Key IS Not ConfiGured");
                return "home";
            }

            try {
                SearchVideo result = youTubeService.searchVideo("videoTitle");

                model.addAttribute("primaryVideo", result.getPrimaryVideo());
                model.addAttribute("relatedVideos", result.getRelatedVideos());
                return "home";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                return "home";

            }
        }
}
