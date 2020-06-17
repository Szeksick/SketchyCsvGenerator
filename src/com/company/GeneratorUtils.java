package com.company;

import com.sun.javafx.collections.MappingChange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneratorUtils {

    public static String getRandomFutureDate() {
        Date startDate = new Date();
        RandomDate rd = new RandomDate(LocalDate.of(startDate.getYear()-1, startDate.getMonth(), startDate.getDay()), LocalDate.of(startDate.getYear()+1, startDate.getMonth(), startDate.getDay()));
        return rd.nextDate().toString();
    }

    public static String getRandomPastDate() {
        Date startDate = new Date();
        RandomDate rd = new RandomDate(LocalDate.of(startDate.getYear()-1, startDate.getMonth(), startDate.getDay()), LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDay()));
        return rd.nextDate().toString();
    }

    public static String getRandomNumberString(long leftLimit, long rightLimit) {
        Long l = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return l.toString();
    }

    private static long getRandomNumber(long leftLimit, long rightLimit) {
        Long l = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return l;
    }


    public static String getRandomContractType() {
        String[] types = {"uop", "uod", "uz"};
        int i = new Random().nextInt(3);
        return types[i];
    }

    public static String getRandomCompanyName() {
        String[] companys = {"POLSKI KONCERN NAFTOWY ORLEN S A", "JERONIMO MARTINS POLSKA S A", "PZU S A", "GRUPA LOTOS S A", "POLSKIE GÓRNICTWO NAFTOWE I GAZOWNICTWO S A", "KGHM POLSKA MIEDŹ S A", "FCA POLAND S A", "Cinkciarzpl sp z o o", "EUROCASH S A", "Lidl Sklepy Spoż sp z o o", "PKO BP S A", "VOLKSWAGEN POZNAŃ SP Z O O", "Orlen Paliwa sp z o o", "ArcelorMittal Poland S A", "Enea S A", "ORANGE POLSKA S A", "Tesco (Polska) sp z o o", "VOLKSWAGEN GROUP POLSKA SP Z O O", "PGE POLSKA GRUPA ENERGETYCZNA S A", "BP Europa SE", "General Motors Manufacturing Poland sp z o o", "Energa S A", "Kaufland Polska Markety sp z o o sk", "Auchan Polska sp z o o", "Pelion S A", "PGL Lasy Państwowe", "Bank Zachodni WBK S A", "JASTRZĘBSKA SPÓŁKA WĘGLOWA S A", "Polskie Sieci Elektroenergetyczne S A", "TAURON POLSKA ENERGIA S A", "Bank Pekao S A", "CARREFOUR POLSKA SP Z O O", "Rossmann SD Polska sp z o o", "MAKRO CASH AND CARRY POLSKA S A", "NEUCA S A", "POLKOMTEL SP Z O O", "T MOBILE POLSKA S A", "Grupa Muszkieterów", "VOLKSWAGEN MOTOR POLSKA SP Z O O", "SAMSUNG ELECTRONICS POLSKA SP Z O O", "TAURON DYSTRYBUCJA S A", "Castorama Polska sp z o o", "P4 sp z o o", "Farmacol S A", "LG ELECTRONICS MŁAWA SP Z O O", "Poczta Polska S A", "ŻABKA POLSKA S A", "BRITISH AMERICAN TOBACCO POLSKA TRADING SP Z O O", "PKP POLSKIE LINIE KOLEJOWE S A", "Warta", "mBank S A", "Ergo Hestia S A", "ING Bank Śląski S A", "BSH SPRZĘT GOSPODARSTWA DOMOWEGO SP Z O O", "Valeo w Polsce", "BUDIMEX S A", "Polska Grupa Zbrojeniowa S A", "MICHELIN POLSKA S A", "Animex Foods sp z o o", "INTER CARS S A", "LPP S A", "POLSKA GRUPA FARMACEUTYCZNA S A", "FARMACOL LOGISTYKA SP Z O O", "Totalizator Sportowy sp z o o", "CARGILL POLAND SP Z O O", "ELECTROLUX POLAND SP Z O O", "GLENCORE POLSKA SP Z O O", "IKEA INDUSTRY POLAND SP Z O O", "FRITZ GROUP S A", "CEDC International sp z o o", "Maspex", "CIRCLE K POLSKA SP Z O O", "LEROY MERLIN POLSKA SP Z O O", "AB S A", "ENERGA OPERATOR S A", "SHELL POLSKA SP Z O O", "ABC DATA S A", "Kompania Piwowarska S A", "FLEXTRONICS INTERNATIONAL POLAND SP Z O O", "POLSKA GRUPA GÓRNICZA SP Z O O", "EDF POLSKA S A", "SKANSKA S A", "MAN TRUCKS SP Z O O", "POLSKIE LINIE LOTNICZE LOT S A", "FCA Powertrain Poland sp z o o", "SPÓŁDZIELNIA MLECZARSKA MLEKOVITA", "TRW POLSKA SP Z O O", "Alior Bank S A", "LG ELECTRONICS WROCŁAW SP Z O O", "Renault Polska sp z o o", "Bank Millennium S A", "Strabag sp z o o", "Węglokoks S A", "DINO POLSKA S A", "Sokołów S A", "Magneti Marelli w Polsce", "PKP ENERGETYKA S A", "CAN PACK S A", "IKEA RETAIL SP Z O O", "SPÓŁDZIELNIA MLECZARSKA MLEKPOL W GRAJEWIE"};
        int i = new Random().nextInt(100);
        return companys[i];
    }

    public static Map<String, String> getCityProvinceMap() {
        Map<String, String> result = new HashMap<>();
        List<String> provinces =  new ArrayList<>(Arrays.asList("kujawsko-pomorskie","lubelskie","lubuskie","łódzkie","małopolskie","mazowieckie",
                "opolskie","podkarpackie","podlaskie","pomorskie","śląskie","świętokrzyskie","warmińsko-mazurskie","wielkopolskie","zachodniopomorskie"));
        List<String> cities = new ArrayList<>(Arrays.asList("Bydgoszcz","Lublin","Gorzów Wielkopolski","Łódź","Kraków","Warszawa","Opole",
                "Rzeszów","Białystok","Gdańsk","Katowice","Kielce","Olsztyn","Poznań","Szczecin"));
        for (int i = 0; i < provinces.size(); i++) {
            result.put(cities.get(i), provinces.get(i));
        }
        return result;
    }

    public static String getRandomCityName() {
        Map<String, String> cityProvinceMap = getCityProvinceMap();
        List<String> cities = new ArrayList<>(cityProvinceMap.keySet());
        int i = new Random().nextInt(cityProvinceMap.size());
        return cities.get(i);
    }

    public static String getRandomProvinceName() {
        Map<String, String> cityProvinceMap = getCityProvinceMap();
        List<String> provinces = new ArrayList<>(cityProvinceMap.values());
        int i = new Random().nextInt(cityProvinceMap.size());
        return provinces.get(i);
    }

    public static List<String> getCategories(){
       return new ArrayList<>(Arrays.asList("Administracja biurowa","Doradztwo / Konsulting","Badania i rozwój","Bankowość","BHP / Ochrona środowiska","Budownictwo","Call Center","Edukacja / Szkolenia","Finanse / Ekonomia","Franczyza / Własny biznes","Hotelarstwo / Gastronomia / Turystyka","Human Resources / Zasoby ludzkie","Internet / e-Commerce / Nowe media","Inżynieria","IT - Administracja","IT - Rozwój oprogramowania","Łańcuch dostaw","Marketing","Media / Sztuka / Rozrywka","Nieruchomości","Obsługa klienta","Praca fizyczna","Prawo","Produkcja","Public Relations","Reklama / Grafika / Kreacja / Fotografia","Sektor publiczny","Sprzedaż","Transport / Spedycja","Ubezpieczenia","Zakupy","Kontrola jakości","Zdrowie / Uroda / Rekreacja","Energetyka","Inne"));
    }



    public static String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
}
