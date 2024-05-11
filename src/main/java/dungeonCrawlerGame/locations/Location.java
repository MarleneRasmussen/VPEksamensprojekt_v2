package dungeonCrawlerGame.locations;

import static dungeonCrawlerGame.locations.Cells.*;

public class Location {

    public static Cells[][] returnLocation(int locationNum) {
        switch (locationNum) {
            case 1: {
                return location1;
            }
            case 2: {
                return location2;
            }
            case 3: {
                return location3;
            }
            case 4: {
                return location4;
            }
            case 5: {
                return location5;
            }
            case 6: {
                return location6;
            }
            case 7: {
                return location7;
            }
            case 8: {
                return location8;
            }
            case 9: {
                return location9;
            }
            case 10: {
                return location10;
            }
            case 11: {
                return location11;
            }
            case 12: {
                return location12;
            }
        }
        return null;
    }

    private static Cells[][] location1 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, TI, TI, TI, TI, TI, TI, TI, TI, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, TI, TI, TI, TI, TI, TI, TI, TI, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI},
            {WA, GR, GR, GR, GR, GR, GR, GR, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI},
            {WA, GR, GR, GR, GR, GR, GR, GR, TI, TI, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, TI, TI, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, TI, TI, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, TI, TI, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location2 = {
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA},
            {WA, SA, SA, SA, SA, SA, WA, LA, LA, LA, WA, SA, SA, SA, SA, SA, SA, WA},
            {WA, SA, SA, SA, SA, SA, WA, LA, LA, LA, WA, SA, SA, SA, SA, SA, SA, WA},
            {WA, ST, ST, ST, ST, ST, WA, WA, WA, WA, WA, SA, SA, SA, SA, SA, SA, WA},
            {TI, TI, TI, TI, TI, TI, TI, WA, WA, WA, ST, ST, ST, ST, ST, ST, ST, WA},
            {TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, WA},
            {WA, WA, WA, SB, SB, BL, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, TI, WA},
            {BS, BS, WA, SA, SA, SL, TI, TI, TI, BR, SB, WA, WA, WA, WA, WA, WA, WA},
            {BS, BS, WA, WA, SA, SL, TI, TI, TI, SR, SA, WA, BS, BS, BS, BS, BS, BS},
            {BS, BS, BS, WA, WA, WA, TI, TI, WA, WA, WA, WA, BS, BS, BS, BS, BS, BS}};

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
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, TI},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, TI},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, WA},
            {WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA}};

    private static Cells[][] location6 = {
            {WA, WA, WA, WA, WA, WA, TI, TI, WA, WA, WA, WA, WA, WA, WA, WA, WA, WA},
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


