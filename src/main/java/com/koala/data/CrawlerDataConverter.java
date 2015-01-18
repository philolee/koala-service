package com.koala.data;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlerDataConverter {

  public CrawlerDataConverter() {

  }

  public void process() throws IOException {
    File dir = new File("./data");
    File[] files = dir.listFiles();
    List<String> data = new ArrayList<>();
    for (File file : files) {
      String content = FileUtils.readFileToString(file);
      JSONObject json = JSON.parseObject(content);
      JSONArray array = json.getJSONObject("data").getJSONArray("list");
      for (int i = 0; i < array.size(); ++i) {
        data.add(array.get(i).toString());
      }
    }
    FileUtils.writeLines(new File("./data/data.txt"), data);
  }

  public static void main(String[] args) throws IOException {
    new CrawlerDataConverter().process();

  }
}
