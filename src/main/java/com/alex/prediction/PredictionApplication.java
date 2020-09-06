package com.alex.prediction;

import com.alex.prediction.models.*;
import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.services.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@SpringBootApplication
@Configuration
public class PredictionApplication {
    static String url = "http://api.football-data.org/v2/competitions/2021/standings";
    static String token = "016ad2c9279c46d98330e52da7acf441";
    static String url3 = "https://api.footystats.org/league-season?key=test85g57&season_id=2012";


    public static void main(String[] args) {
        SpringApplication.run(PredictionApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CleanSheetService cleanSheetService,
                             AssistService assistService,
                             ScorerService scorerService,
                             TeamService teamService,
                             UserTeamService userTeamService,
                             UserRepository userRepository,
                             UserScorerService userScorerService,
                             UserCleanSheetService userCleanSheetService,
                             UserAssistService userAssistService
    ) {
        return args -> {
//             read JSON and load json
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Team>> typeReference = new TypeReference<List<Team>>() {
            };
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("X-Auth-Token", token)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String jsonData = response.body().string();
                JSONObject jObject = new JSONObject(jsonData);

                JSONArray standings = jObject.getJSONArray("standings");
                JSONArray table = standings.getJSONObject(0).getJSONArray("table");

                List<Team> teams = mapper.readValue(table.toString(), typeReference);

                System.out.println(standings);
                teamService.save(teams);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

//            mapper = new ObjectMapper();
//            TypeReference<List<Assist>> typeReferenceAssist = new TypeReference<List<Assist>>() {
//            };
//            TypeReference<List<Scorer>> typeReferenceScorers = new TypeReference<List<Scorer>>() {
//            };
//            TypeReference<List<CleanSheet>> typeReferenceCleanSheet = new TypeReference<List<CleanSheet>>() {
//            };
//            client = new OkHttpClient();
//            request = new Request.Builder()
//                    .url(url3)
//                    .get()
//                    .build();
//            try {
//                Response response = client.newCall(request).execute();
//                String jsonData = response.body().string();
//                JSONObject jObject = new JSONObject(jsonData);
//
//                JSONObject data = jObject.getJSONObject("data");
//                JSONArray topAssists = data.getJSONArray("top_assists");
//                JSONArray topScorers = data.getJSONArray("top_scorers");
//                JSONArray topCleanSheet = data.getJSONArray("top_clean_sheets");
//
//                List<Assist> assists = mapper.readValue(topAssists.toString(), typeReferenceAssist);
//                assistService.save(assists);
//
//                List<Scorer> scorers = mapper.readValue(topScorers.toString(), typeReferenceScorers);
//                scorerService.save(scorers);
//
//                List<CleanSheet> cleanSheets = mapper.readValue(topCleanSheet.toString(), typeReferenceCleanSheet);
//                cleanSheetService.save(cleanSheets);
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
        };
    }
}
