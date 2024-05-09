package dungeonCrawlerGame.locations;

import dungeonCrawlerGame.ui.Cells;

import static dungeonCrawlerGame.ui.Cells.*;

public class Location {

    public static Cells[][] returnLocation(int locationNum) {
        switch (locationNum) {
            case 1: {
                return location1;
            }
            case 2: {
                return location2;
            }
        }
        return null;
    }

    private static Cells[][] location1 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, TI, TI, TI, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, TI, TI, TI, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, TI, TI, TI, GR, GR},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location2 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location3 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location4 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location5 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location6 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location7 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location8 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location9 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location10 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location11 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location12 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, GR, GR, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

}

