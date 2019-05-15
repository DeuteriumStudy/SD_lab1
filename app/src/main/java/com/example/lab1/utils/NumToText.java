package com.example.lab1.utils;

public class NumToText {
    private String getMillion(int n) {
        return (n > 0 ? " один миллион" : "");
    }

    private String getHundredsOfThousands(int n) {
        String hundred = getHundreds(n, true);
        switch (n % 10) {
            case 1: return hundred + " тысяча";
            case 2:
            case 3:
            case 4: return hundred + " тысячи";
            default: return (n == 0 ? "" : hundred + " тысяч");
        }
    }

    private String getHundreds(int n, boolean thousand) {
        String decade = getTens(n % 100, thousand);
        String hundred;
        switch (n / 100) {
            case 1: hundred = " сто"; break;
            case 2: hundred = " двести"; break;
            case 3: hundred = " триста"; break;
            case 4: hundred = " четыреста"; break;
            case 5: hundred = " пятьсот"; break;
            case 6: hundred = " шестьсот"; break;
            case 7: hundred = " семьсот"; break;
            case 8: hundred = " восемьсот"; break;
            case 9: hundred = " девятьсот"; break;
            default: hundred = "";
        }

        return hundred + decade;
    }

    private String getUnit(int n, boolean thousand) {
        switch (n) {
            case 1: return (thousand ? " одна" : " один");
            case 2: return (thousand ? " две" : " два");
            case 3: return " три";
            case 4: return " четыре";
            case 5: return " пять";
            case 6: return " шесть";
            case 7: return " семь";
            case 8: return " восемь";
            case 9: return " девять";
        }
        return "";
    }

    private  String getTens(int n, boolean thousand) {
        String unit = getUnit(n % 10, thousand);
        switch (n / 10) {
            case 1: {
                switch (n % 10) {
                    case 0: return " десять";
                    case 1: return " одиннадцать";
                    case 2: return " двенадцать";
                    case 3: return " тринадцать";
                    case 4: return " четырнадцать";
                    case 5: return " пятнадцать";
                    case 6: return " шестнадцать";
                    case 7: return " семнадцать";
                    case 8: return " восемнадцать";
                    case 9: return " девятнадцать";
                }
            }
            case 2: return " двадцать" + unit;
            case 3: return " тридцать" + unit;
            case 4: return " сорок" + unit;
            case 5: return " пятьдесят" + unit;
            case 6: return " шестьдесят" + unit;
            case 7: return " семьдесят" + unit;
            case 8: return " восемьдесят" + unit;
            case 9: return " девяносто" + unit;
            default: return getUnit(n % 10, thousand);
        }
    }

    public String convertNumber(int n) {
        String result = getMillion(n / 1000000) + getHundredsOfThousands(n / 1000 % 1000) +
                getHundreds(n % 1000, false);

        return result.trim().substring(0, 1).toUpperCase() + result.substring(2);
    }

}
