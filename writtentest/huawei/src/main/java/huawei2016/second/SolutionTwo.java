package huawei2016.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YaboSun
 */
public class SolutionTwo {

    //copy
    public static ArrayList<Record> records=new ArrayList<Record>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        String info = null;
        while((info = bufferedreader.readLine())!=null){
            String newrecord = info.substring(info.lastIndexOf("\\") + 1);
            int index = find(records,newrecord);
            if(index == -1){
                Record newRecord = new Record();
                newRecord.record = newrecord;
                newRecord.count = 1;
                records.add(newRecord);
            }
        }
        Record[] recordArray = records.toArray(new Record[records.size()]);
        sortt(recordArray);
        printt(recordArray);
    }

    //通过记录的文件名称与记录list中进行比较，没有的话返回-1，有的话将记录数+1
    public static int find(List<Record> records, String newrecord){
        int index = -1;
        for(Record subRecord : records){
            if(subRecord.record.equals(newrecord)){
                subRecord.count++;
                index = 1;
            }
        }
        return index;
    }

    //通过Record数组中记录数的大小进行数组排序
    public static void sortt(Record[] recordArray){
        Record temp;
        int j;
        for(int i = 1; i < recordArray.length; i++){
            temp = recordArray[i];
            for (j = i; j > 0 && (temp.count > recordArray[j-1].count); j--) {
                recordArray[j] = recordArray[j-1];
            }
            recordArray[j] = temp;
        }
    }

    //将数组的前八位数据打印出来
    public static void printt(Record[] recordArray){
        int n;
        if(recordArray.length <= 8){
            n = recordArray.length;
        }else{
            n = 8;
        }
        for(int i=0; i<n; i++){
            String recordStr = recordArray[i].record;
            String fileName = recordStr.substring(0,recordStr.indexOf(" "));
            if(fileName.length() > 16){
                String hang = recordStr.substring(recordStr.indexOf(" "));
                fileName = fileName.substring(fileName.length()-16,fileName.length());
                String pStr = fileName + hang;
                System.out.println(pStr + " " + recordArray[i].count);

            }else{
                System.out.println(recordStr + " " + recordArray[i].count);
            }
        }
    }

    //创建记录的实体类
    static class Record{
        String record;
        int count;
    }
}
