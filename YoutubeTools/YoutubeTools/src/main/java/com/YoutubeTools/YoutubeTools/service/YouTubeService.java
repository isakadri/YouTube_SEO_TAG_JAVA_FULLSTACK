package com.YoutubeTools.YoutubeTools.service;

import com.YoutubeTools.YoutubeTools.model.SearchVideo;
import com.YoutubeTools.YoutubeTools.model.Video;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YouTubeService {


    private final WebClient.Builder webClientBuilder;

    @Value("${youtube.api.key}")
    private String apiKey;

    @Value("${youtube.api.base.url}")
    private String baseUrl;


    @Value("${youtube.apimax.related.videos}")
    private int maxRelatedVideos;

    public SearchVideo searchVideo(String videoTitle){

        List<String> videoIds=searchForVideoIds(videoTitle);
        if(videoIds.isEmpty()){
            return SearchVideo.builder()
                    .primaryVideo(null)
                    .relatedVideos(Collection.emptyList())
                    .build();
        }
        String primaryVideoId=videoIds.get(0);
        List<String> relatedVideoIds=videoIds.subList(1,Math.min(videoIds.size(),maxRelatedVideos)+1);

        Video primaryVide=getVideoById(primaryVideoId);

        List<Video>relatedVideos=new ArrayList<>();

        for(String id:relatedVideoIds){
            Video video=getVideoById(id);
            if(video != null ){
                relatedVideos.add(video);
            }

        }

        return searchVideo.builder();
        .primaryVideo(primaryVide)
                .relatedVideos(relatedVideos)
                .build();

    }
//   DTO = Data Transfer Object :-yeh Json se data ko utha lega
    // hum api ko call krenge fir dto ke help se json se data fetch karlenge kyuke jab youtube hamei data dega toh wo json form mein hoga
    private List<String> searchForVideoIds(String videoTitle){
        SearchApiResponse response=webClientBuilder.baseUrl(baseUrl).build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("part","snipeet")
                        .queryParam("q",videoTitle)
                        .queryParam("type","video")
                        .queryParam("maxResult",maxRelatedVideos)
                        .queryParam("key",apiKey)
                        .build()).retrieve()
                .bodyToMono(SearchApiResponse.class).block();

        if(response==null || response.items==null){
            return Collection.emptyList();

        }

        List<String> videoIds = new ArrayList<>();

        for(SearchItem item:response.items){
            videoIds.add(item.id.videoId);
        }
        return videoIds;


    }

    private Video getVideoById(String videoId){
        videoApiResponse response = webClientBuilder.baseUrl(baseUrl).build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/videos")
                        .queryParam("part","spnippet")
                        .queryParam("id",videoId)
                        .queryParam("key",apiKey)
                        .build()

                )
                .retrieve()
                .bodyToMono(VideoApiResponse.class)
                .block();
        if(response == null || response.items==null){
            return null;
        }

    }



}
