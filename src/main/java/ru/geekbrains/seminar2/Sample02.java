package ru.geekbrains.seminar2;

public class Sample02 {

    public static void main(String[] args) {

        /*LogReader logReader1 = new OperationSystemLogEventReader();
        logReader1.setCurrentPosition(10);
        logReader1.readLogEntry();
        LogReader logReader2 = new TextFileReader();
        logReader2.setCurrentPosition(10);
        logReader2.readLogEntry();
        LogReader logReader3 = new DatabaseReader();
        logReader3.setCurrentPosition(10);
        logReader3.readLogEntry();*/

        ConcreteReaderCreator concreteReaderCreator = new ConcreteReaderCreator();
        LogReader logreader = concreteReaderCreator.createLogReader(LogType.Poem);
        logreader.setDatasource(Sample01.data);
        logreader.readLogEntry();


        for (LogEntry log: logreader.readLogEntry()) {
            System.out.println(log.getText());
        }
    }

}

enum LogType{
    Text,
    Poem,
    Database,
    System
}

abstract class BaseLogReaderCreator{ // класс базового ридера

    public LogReader createLogReader(LogType logType){ // с помощью фабричного класса создает объекты. реализация базового класса

        LogReader logReader = createLogReaderInstance(logType);// при вызове createLogReader нам возвращается LogReader
        logReader.setCurrentPosition(20); // базовые конструкции, которые можем вызвать в рамках каждого Logreader, например переходим на нужную позицию
        return logReader; // вернем LogReader после вызова и нужных обработок
    }
    protected abstract LogReader createLogReaderInstance(LogType logType); // Фабричный метод, создающий экземпляры Logreader.
}

class ConcreteReaderCreator extends BaseLogReaderCreator{ // Класс конкретного ридера, унаследованного от базового ( выше)
    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        return switch (logType){
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database ->  new DatabaseReader();
            case System ->  new OperationSystemLogEventReader();
        };
    }
}




class TextFileReader extends LogReader {
    @Override
    public void setDatasource(Object data) {
    }
    @Override
    public Object getDatasource() {
        return null;
    }
    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }
    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}


class DatabaseReader extends LogReader{
    @Override
    public void setDatasource(Object data) {
    }
    @Override
    public Object getDatasource() {
        return null;
    }
    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }
    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}

class OperationSystemLogEventReader extends LogReader{
    @Override
    public void setDatasource(Object data) {
    }
    @Override
    public Object getDatasource() {
        return null;
    }
    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }
    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}











