package aquinones.technicaltest.techincaltest.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import aquinones.technicaltest.techincaltest.exception.BadRequestException;

public class Validator {
    
    public static boolean validateStr(String str) throws BadRequestException{
        if(str.isEmpty() || str == null) throw new BadRequestException("String can't not be null or empty", 400);
        return true;
    }

    public static boolean isValidDateFormat(String dateToValidate) throws BadRequestException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        try {
            LocalDateTime.parse(dateToValidate, formatter);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Invalid date format", 400);
        }
        return true;
    }
}
