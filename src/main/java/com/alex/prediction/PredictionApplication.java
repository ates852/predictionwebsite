package com.alex.prediction;

import com.alex.prediction.core.Core;
import com.alex.prediction.domain.*;
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
                             UserService userService,
                             UserTeamService userTeamService,
                             UserScorerService userScorerService,
                             UserCleanSheetService userCleanSheetService,
                             UserAssistService userAssistService
    ) {
        return args -> {
//             read JSON and load json
//                      ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Team>> typeReference = new TypeReference<List<Team>>() {
//            };
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(url)
//                    .get()
//                    .addHeader("X-Auth-Token", token)
//                    .build();
//            try {
//                Response response = client.newCall(request).execute();
//                String jsonData = response.body().string();
//                JSONObject jObject = new JSONObject(jsonData);
//
//                JSONArray standings = jObject.getJSONArray("standings");
//                JSONArray table = standings.getJSONObject(0).getJSONArray("table");
//
//                List<Team> teams = mapper.readValue(table.toString(), typeReference);
//
//                teamService.save(teams);
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//
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

//
//            User alex = userService.findUserById(1);
//            User haglo = userService.findUserById(2);
//            User jakub = userService.findUserById(3);
//            User peto = userService.findUserById(4);

//            UserAssist daco = new UserAssist(1, "Kevin De Bruyne", "2019/2020", alex);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(2, "Christian Eriksen", "2019/2020", alex);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(3, "Raheem Sterling", "2019/2020", alex);
//            userAssistService.saveUserAssist(daco);
//
//            daco = new UserAssist(1, "Raheem Sterling", "2019/2020", jakub);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(2, "Kevin De Bruyne", "2019/2020", jakub);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(3, "Mohamed Salah", "2019/2020", jakub);
//            userAssistService.saveUserAssist(daco);
//
//            daco = new UserAssist(1, "Raheem Sterling", "2019/2020", peto);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(2, "Bernardo Silva", "2019/2020", peto);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(3, "Mohamed Salah", "2019/2020", peto);
//            userAssistService.saveUserAssist(daco);
//
//            daco = new UserAssist(1, "Kevin De Bruyne", "2019/2020", haglo);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(2, "Raheem Sterling", "2019/2020", haglo);
//            userAssistService.saveUserAssist(daco);
//            daco = new UserAssist(3, "Mohamed Salah", "2019/2020", haglo);
//            userAssistService.saveUserAssist(daco);
//
//
//            UserCleanSheet daco2 = new UserCleanSheet(1, "Ederson", "2019/2020", alex);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(2, "Alisson Becker", "2019/2020", alex);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(3, "Hugo Lloris", "2019/2020", alex);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//
//            daco2 = new UserCleanSheet(1, "Ederson", "2019/2020", jakub);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(2, "Alisson Becker", "2019/2020", jakub);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(3, "Hugo Lloris", "2019/2020", jakub);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//
//            daco2 = new UserCleanSheet(1, "Ederson", "2019/2020", peto);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(2, "Alisson Becker", "2019/2020", peto);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(3, "David de Gea", "2019/2020", peto);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//
//            daco2 = new UserCleanSheet(1, "Alisson Becker", "2019/2020", haglo);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(2, "Ederson", "2019/2020", haglo);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//            daco2 = new UserCleanSheet(3, "David de Gea", "2019/2020", haglo);
//            userCleanSheetService.saveUserCleanSheet(daco2);
//
//            Core core = new Core(userTeamService.getList(alex), teamService.getList(), scorerService.getList(), userScorerService.getList(alex),assistService.getList(),userAssistService.getList(alex),cleanSheetService.getList(),userCleanSheetService.getList(alex));;
//            System.out.println("Alex:" + core.getResult());
//            core = new Core(userTeamService.getList(haglo), teamService.getList(), scorerService.getList(), userScorerService.getList(haglo),assistService.getList(),userAssistService.getList(haglo),cleanSheetService.getList(),userCleanSheetService.getList(haglo));;
//            System.out.println("Haglo:" + core.getResult());
//            core = new Core(userTeamService.getList(jakub), teamService.getList(), scorerService.getList(), userScorerService.getList(jakub),assistService.getList(),userAssistService.getList(jakub),cleanSheetService.getList(),userCleanSheetService.getList(jakub));;
//            System.out.println("Jakub:" + core.getResult());
//            core = new Core(userTeamService.getList(peto), teamService.getList(), scorerService.getList(), userScorerService.getList(peto),assistService.getList(),userAssistService.getList(peto),cleanSheetService.getList(),userCleanSheetService.getList(peto));;
//            System.out.println("Peter:" + core.getResult());
        };
    }
}
