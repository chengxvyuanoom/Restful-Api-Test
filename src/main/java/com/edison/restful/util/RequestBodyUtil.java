package com.edison.restful.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @CLassName RequestBodyUtil
 * @Description TODO
 * @Author goodman
 * @Date 2019-07-02 15:08
 * @Version 1.0
 **/
public class RequestBodyUtil {

  private static final int BUFFER_SIZE = 1024 * 8;

  /**
   * read string.
   *
   * @param reader Reader instance.
   * @return String.
   */
  public static String read(Reader reader) throws IOException {
    StringWriter writer = new StringWriter();
    try {
      write(reader, writer);
      return writer.getBuffer().toString();
    } finally {
      writer.close();
    }
  }

  /**
   * write.
   *
   * @param reader Reader.
   * @param writer Writer.
   * @return count.
   */
  public static long write(Reader reader, Writer writer) throws IOException {
    return write(reader, writer, BUFFER_SIZE);
  }

  /**
   * write.
   *
   * @param reader Reader.
   * @param writer Writer.
   * @param bufferSize buffer size.
   * @return count.
   */
  public static long write(Reader reader, Writer writer, int bufferSize) throws IOException {
    int read;
    long total = 0;
    char[] buf = new char[BUFFER_SIZE];
    while ((read = reader.read(buf)) != -1) {
      writer.write(buf, 0, read);
      total += read;
    }
    return total;
  }

}
