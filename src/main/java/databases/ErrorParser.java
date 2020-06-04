package databases;

public class ErrorParser {

    public String parse(String errorLog) {
        String result;
        if(errorLog.contains("Подробности"))
            result = errorLog.split("\n")[1].replace("Подробности: Ключ \"", "");
        else
            result = errorLog.split("\n")[0].replace("ОШИБКА: ", "");
        return result;
    }
}
