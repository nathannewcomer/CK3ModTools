package CK3ModTools.parser;

import CK3ModTools.parser.FileScanner;
import CK3ModTools.titles.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileParser {

    FileScanner scanner;
    HashMap<String, Integer> variables;

    public FileParser(FileScanner scanner) {
        this.scanner = scanner;
    }

    public void parse() {

        switch (scanner.getCurrentToken()) {

        }

    }

    private Empire parseEmpire() {
        return null;
    }

    private Kingdom parseKingdom() {
        return null;
    }

    private Duchy parseDuchy() {
        return null;
    }

    private County parseCounty() {
        return null;
    }

    private Barony parseBarony() {
        return null;
    }

    private Color parseColor() {
        return null;
    }

    private HashMap<String, String> parseCulturalNames() {
        return null;
    }

    private ArrayList<String> parseMaleNames() {
        return null;
    }

}
