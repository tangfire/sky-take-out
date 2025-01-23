package com.sky.service.impl;


import com.sky.dto.GoodsSalesDTO;
import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.mapper.UserMapper;
import com.sky.service.ReportService;
import com.sky.service.WorkspaceService;
import com.sky.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WorkspaceService workspaceService;


    /**
     * 统计指定时间区间内的营业额数据
     *
     * @param begin
     * @param end
     * @return
     */
    public TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end) {
        // 当前集合用于存放从begin到end范围内的每天的日期
        List<LocalDate> dateList = new ArrayList<>();

        dateList.add(begin);

        while (!begin.equals(end)) {
            // 日期计算,计算指定日期的后一天对应的日期
            begin = begin.plusDays(1);
            dateList.add(begin);
        }

        List<Double> turnoverList = new ArrayList<>();

        for (LocalDate date : dateList) {
            // 查询date 日期对应的营业额数据,营业额是指:状态为"已完成"的订单金额合计
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);

            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);

            // select sum(amount) from orders where order_time > ? and order_time < ? and status = 5
            Map map = new HashMap();
            map.put("begin", beginTime);
            map.put("end", endTime);
            map.put("status", Orders.COMPLETED);

            Double turnover = orderMapper.sumByMap(map);
            turnover = turnover == null ? 0.0 : turnover;
            turnoverList.add(turnover);
        }


        // 封装返回结果
        return TurnoverReportVO.builder().dateList(StringUtils.join(dateList, ","))
                .turnoverList(StringUtils.join(turnoverList, ","))
                .build();
    }


    /**
     * 统计指定时间区间内的用户数据
     *
     * @param begin
     * @param end
     * @return
     */
    @Override
    public UserReportVO getUserStatistics(LocalDate begin, LocalDate end) {

        List<LocalDate> dateList = new ArrayList<>();


        dateList.add(begin);
        while (!begin.equals(end)) {
            begin = begin.plusDays(1);
            dateList.add(begin);

        }
        // 存放每天新增用户数量
        List<Integer> newUserList = new ArrayList<>();
        // 存放每天的总用户数量
        List<Integer> totalUserList = new ArrayList<>();

        for (LocalDate date : dateList) {
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);

            Map map = new HashMap();
            map.put("end", endTime);

            // 总用户数量
            Integer totalUser = userMapper.countByMap(map);

            // 新增用户数量
            map.put("begin", beginTime);
            // 新增用户数量
            Integer newUser = userMapper.countByMap(map);

            totalUserList.add(totalUser);
            newUserList.add(newUser);

        }
        // 封装结果数据
        return UserReportVO.builder().dateList(StringUtils.join(dateList, ",")).totalUserList(StringUtils.join(totalUserList, ",")).newUserList(StringUtils.join(newUserList, ",")).build();
    }

    /**
     * 统计指定时间内的订单数据
     *
     * @param begin
     * @param end
     * @return
     */
    @Override
    public OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end) {
        List<LocalDate> dateList = new ArrayList<>();


        dateList.add(begin);
        while (!begin.equals(end)) {
            begin = begin.plusDays(1);
            dateList.add(begin);

        }

        // 存储每天的订单总数
        List<Integer> orderCountList = new ArrayList<>();
        // 存储每天的有效订单数
        List<Integer> vaildOrderCountList = new ArrayList<>();
        Integer totalOrderCount = 0;
        Integer totalVaildOrderCount = 0;

        // 遍历dateList集合,查询每天的有效订单数和订单总数
        for (LocalDate date : dateList) {
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);

            // 查询每天的订单总数 select count(id) from orders where order_time < ? and order_time < ?
            Integer orderCount = getOrderCount(beginTime,endTime,null);

            // 查询每天的有效订单数 select count(id) from orders where order_time < ? and order_time < ? and status = 5
            Integer vaildOrderCount = getOrderCount(beginTime, endTime, Orders.COMPLETED);
            totalOrderCount += orderCount;
            totalVaildOrderCount += vaildOrderCount;
            orderCountList.add(orderCount);
            vaildOrderCountList.add(vaildOrderCount);

        }

        // 计算订单完成率
        Double orderCompletionRate = 0.0;

        if (orderCompletionRate != 0) {
            // 计算订单完成率
            orderCompletionRate = totalVaildOrderCount.doubleValue() / totalOrderCount;

        }

        return OrderReportVO.builder()
                .dateList(StringUtils.join(dateList,","))
                .validOrderCountList(StringUtils.join(vaildOrderCountList,","))
                .orderCountList(StringUtils.join(orderCountList,","))
                .totalOrderCount(totalOrderCount)
                .validOrderCount(totalVaildOrderCount)
                .orderCompletionRate(orderCompletionRate)
                .build();
    }

    /**
     * 根据条件统计订单数量
     * @param begin
     * @param end
     * @return
     */
    private Integer getOrderCount(LocalDateTime begin,LocalDateTime end,Integer status){
        Map map = new HashMap();
        map.put("begin", begin);
        map.put("end", end);
        map.put("status", status);

        return orderMapper.countByMap(map);
    }


    @Override
    public SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end) {
        LocalDateTime beginTime = LocalDateTime.of(begin, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(begin, LocalTime.MAX);

        List<GoodsSalesDTO> salesTop10 = orderMapper.getSalesTop10(beginTime,endTime);

        List<String> names = salesTop10.stream().map(GoodsSalesDTO::getName).collect(Collectors.toList());

        String nameList = StringUtils.join(names, ",");

        List<Integer> numbers = salesTop10.stream().map(GoodsSalesDTO::getNumber).collect(Collectors.toList());

        String numberList = StringUtils.join(numbers, ",");

        return SalesTop10ReportVO.builder().nameList(nameList).numberList(numberList).build();

    }

    /**
     * 导出运营数据报表
     * @param response
     */
    @Override
    public void exportBusinessData(HttpServletResponse response) {
        // 1. 查询数据库,获取营业额---查询最近30天的运营数据
        LocalDate dateBegin = LocalDate.now().minusDays(30);

        LocalDate dateEnd = LocalDate.now().minusDays(1);

        LocalDateTime begin = LocalDateTime.of(dateBegin, LocalTime.MIN);

        LocalDateTime end = LocalDateTime.of(dateEnd, LocalTime.MAX);

        BusinessDataVO businessDataVO = workspaceService.getBusinessData(begin, end);

        // 2. 通过POI将数据写入到Excel文件中
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("template/info.xlsx");


        try {
            // 基于模版文件创建一个新的Excel文件
            XSSFWorkbook excel = new XSSFWorkbook(in);

            // 获取表格文件的sheet页
            XSSFSheet sheet = excel.getSheet("Sheet1");
            // 填充数据---时间
            sheet.getRow(1).getCell(1).setCellValue("时间:"+dateBegin + "至" + dateEnd);

            XSSFRow row = sheet.getRow(3);
            row.getCell(2).setCellValue(businessDataVO.getTurnover());
            row.getCell(4).setCellValue(businessDataVO.getOrderCompletionRate());
            row.getCell(6).setCellValue(businessDataVO.getNewUsers());

            row = sheet.getRow(4);
            row.getCell(2).setCellValue(businessDataVO.getValidOrderCount());
            row.getCell(4).setCellValue(businessDataVO.getUnitPrice());

            // 填充明细数据
            for (int i = 0;i < 30 ;i++){
                LocalDate date = dateBegin.plusDays(i);
                // 查询某一天的
                BusinessDataVO businessData = workspaceService.getBusinessData(LocalDateTime.of(date, LocalTime.MIN), LocalDateTime.of(date, LocalTime.MAX));

                // 获得某一行
                row = sheet.getRow(7 + i);
                row.getCell(1).setCellValue(date.toString());
                row.getCell(2).setCellValue(businessData.getTurnover());
                row.getCell(3).setCellValue(businessData.getValidOrderCount());
                row.getCell(4).setCellValue(businessData.getOrderCompletionRate());
                row.getCell(5).setCellValue(businessData.getUnitPrice());
                row.getCell(6).setCellValue(businessData.getNewUsers());

            }


            // 3. 通过输出流将Excel 文件下载到客户端浏览器
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

            // 关闭资源
            out.close();
            excel.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
