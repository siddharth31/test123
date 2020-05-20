package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
public class ApplicationController {

    @RequestMapping("/countryIdAndName")
    public StringBuffer index1() throws IOException {
        URL url = new URL("https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        Response1[] response1 = null;

        ObjectMapper mapper = new ObjectMapper();
        try{
          response1 = mapper.readValue(content.toString(), Response1[].class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();

        sb.append(response1[0].getCountry_id() + " " + response1[0].getCountry_name() + " " + response1[0].getCountry_logo());
        return sb;

    }

    @RequestMapping("/leagueIdAndName")
    public StringBuffer index2() throws IOException {
        URL url = new URL("https://apiv2.apifootball.com/?action=get_leagues&country_id=41&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        Response1[] response1 = null;

        ObjectMapper mapper = new ObjectMapper();
        try{
            response1 = mapper.readValue(content.toString(), Response1[].class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();

        sb.append(response1[0].getLeague_id() + " " + response1[0].getLeague_name());
        return sb;
    }

    @RequestMapping("/teamIdAndName")
    public StringBuffer index3() throws IOException {
        URL url = new URL("https://apiv2.apifootball.com/?action=get_teams&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        return content;
    }

    @RequestMapping("/overallLeaguePosition")
    public StringBuffer index4() throws IOException {
        URL url = new URL("https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        return content;
    }

}