package bif3.swen1.Classes;

import java.io.*;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import bif3.swen1.Enum.Elements;
import bif3.swen1.Enum.Rarities;
import bif3.swen1.repository.Repository;

public class Collection extends Repository {

    ArrayList<Card> allCards = new ArrayList<>();

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    public void loadCollection() throws IOException {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Collection (Category, Name, Rarity, Element, Damage, Type) VALUES (?, ?, ?, ?, ?, ?);"
                )
        ) {
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader("Collection.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                //System.out.println(Arrays.toString(data));
                createCard(data[0], data[1], Elements.valueOf(data[3]), Rarities.valueOf(data[2].toUpperCase(Locale.ROOT)), Integer.parseInt(data[4]), data[5]);
            }

            csvReader.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createCard(String cardType, String name, Elements element, Rarities rarity, int damage, String monsterType){
        if(cardType.equals("Monster")){
            allCards.add(new Monster(name, element, rarity, damage, monsterType));
        }else if(cardType.equals("Spell")){
            allCards.add(new Spell(name, element, rarity, damage));
        }else{
            System.out.println("Wrong cardtype detected");
        }
    }

    public void loadCsvIntoDB() throws IOException {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO collection (category, name, rarity, element, damage, type) VALUES (?, ?, ?, ?, ?, ?);"
                )
        ) {
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader("Collection.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                //System.out.println(Arrays.toString(data));
                createCard(data[0], data[1], Elements.valueOf(data[3]), Rarities.valueOf(data[2].toUpperCase(Locale.ROOT)), Integer.parseInt(data[4]), data[5]);
                statement.setString(1, data[0]);
                statement.setString(2, data[1]);
                statement.setString(3, Rarities.valueOf(data[2].toUpperCase(Locale.ROOT)).toString());
                statement.setString(4, Elements.valueOf(data[3]).toString());
                statement.setInt(5, Integer.parseInt(data[4]));
                statement.setString(6, data[5]);
                statement.execute();
            }

            csvReader.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
