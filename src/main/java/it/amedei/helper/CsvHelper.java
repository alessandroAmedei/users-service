package it.amedei.helper;/*
@author Alessandro Amedei
2022    
*/


import it.amedei.exception.RestErrorEnum;
import it.amedei.exception.RestException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {

    public static List<List<String>> fileToCsvMap(File file, int rowSize, String splitter) throws IOException, RestException {
        List<List<String>> csvMap = new ArrayList<>();

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            List<String> row = List.of(line.split(splitter));
            if (row.size() != rowSize)
                throw new RestException(RestErrorEnum.INVALID_CSV_FORMAT);
            csvMap.add(row);
        }

        return csvMap;
    }

}
