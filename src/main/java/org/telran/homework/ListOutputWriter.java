package org.telran.homework;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class ListOutputWriter extends Writer {
    private List<String> stringList;

    public ListOutputWriter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public void write(char[] cbuf, int off, int len) {
        String data = new String(cbuf, off, len);
        stringList.add(data);
    }

    @Override
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override
    public void flush() throws IOException {
    }

    @Override
    public void close() throws IOException {
    }

    public List<String> getStringList() {
        return stringList;
    }
}
