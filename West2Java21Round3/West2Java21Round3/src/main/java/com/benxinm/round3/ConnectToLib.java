package com.benxinm.round3;


import com.alibaba.fastjson.JSON;
import com.benxinm.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ConnectToLib {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Connection connection = Utils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet=null;
        ArrayList<Record> listOfRecord = new ArrayList<>();
        System.out.println("请输入sql语句(有两个数据表:goods,orders)");
        while(in.hasNextLine()){
            String sql=in.nextLine();
            if (sql.equals("exit")||sql.equals("")){
                System.out.println("退出");
                break;
            }
            try {
                if (sql.contains("insert")||sql.contains("delete")||sql.contains("update")){
                    int rows=statement.executeUpdate(sql);
                    System.out.println(rows>0? "操作成功":"操作失败");
                }else if (sql.contains("select")){
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()){
                        if (sql.contains("orders")){
                            int orderId =resultSet.getInt(1);
                            int goodId = resultSet.getInt(2);
                            Date time =resultSet.getTime(3);
                            System.out.println(new Order(orderId,goodId,time));
                            listOfRecord.add(new Order(orderId,goodId,time));
                        }else if (sql.contains("goods")){
                            int id =resultSet.getInt(1);
                            String name=resultSet.getString(2);
                            double price=resultSet.getDouble(3);
                            listOfRecord.add(new Good(id,name,price));
                        }
                    }
                    String jsonOutput=JSON.toJSONString(listOfRecord);
                    String[] split = jsonOutput.split(",");
                    for (String tmp :split) {
                        System.out.println(tmp);
                    }
                    listOfRecord.clear();
                }
            }catch (Exception e){
                System.out.println("sql语句出错");
            }
        }
        Utils.close(resultSet,statement,connection);
    }
}
