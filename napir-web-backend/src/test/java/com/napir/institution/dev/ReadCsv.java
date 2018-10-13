package com.napir.institution.dev;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.DateUtil;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadCsv {

    public static void main(String[] args) throws ParseException {
        System.out.println("Nice to meet you");

        final String FILE_NAME = "/Users/zhangyixu/Documents/c_task_exec_a.csv";
        final String[] FILE_HEADER = {"task_msg_id","task_id","sqs_msg_id","task_flow_seq","trigger_task_msg_id","request_stats","execute_stats","revived_task_msg_id","rerun_flg","rerun_seq","queue_sent_ts","task_start_ts","task_finished_ts"};
        final String DATETIME_PATTERN = "yyyy/MM/dd HH:mm:ss";

        // 这里显式地配置一下CSV文件的Header，然后设置跳过Header（要不然读的时候会把头也当成一条记录）
        CSVFormat format = CSVFormat.DEFAULT.withHeader(FILE_HEADER).withSkipHeaderRecord();
        int index = 0;

        Date runTime = DateUtils.parseDateStrictly("2018/10/10 00:10:11", DATETIME_PATTERN);
        Date endTime = DateUtils.parseDateStrictly("2018/10/11 06:02:53", DATETIME_PATTERN);


        // 这是从上面写入的文件中读出数据的代码
        try(Reader in = new FileReader(FILE_NAME)) {

            Writer writer = new FileWriter(new File("/Users/zhangyixu/Documents/kaka.txt"));

            Iterable<CSVRecord> records = format.parse(in);
            List<CSVRecord> recordlist = new ArrayList<>();
            for (CSVRecord record : records) {
                recordlist.add(record);
            }

            while (runTime.compareTo(endTime) <= 0) {
                int execCnt = 0;

                for (CSVRecord record : recordlist) {
                    Date start_ts = DateUtils.parseDateStrictly(record.get("task_start_ts"), DATETIME_PATTERN);
                    Date finish_ts = DateUtils.parseDateStrictly(record.get("task_finished_ts"), DATETIME_PATTERN);
                    if (runTime.compareTo(start_ts) >= 0 && runTime.compareTo(finish_ts) <= 0) {
                        execCnt++;
                    }
                }

                writer.append(String.format("%s : %d", DateFormatUtils.format(runTime, DATETIME_PATTERN), execCnt));
                writer.append("\n");

                runTime = DateUtils.addSeconds(runTime, 1);
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }


}
