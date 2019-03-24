package com.qch.pm.web.plan;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
import com.qch.pm.domain.plan.Plan;
import com.qch.pm.domain.util.ResponseEntity;
import com.qch.pm.service.plan.PlanService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.qch.pm.domain.util.ResponseCode.SUCCESS;
import static com.qch.pm.domain.util.ResponseCode.WARN;

@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;


    @GetMapping("/edit")
    public String add() {
        return "plan/edit";
    }

    @GetMapping("/list")
    public String list() {
        return "plan/list";
    }

    @PostMapping("/query")
    @ResponseBody
    public ResponseEntity query() {
        List<Plan> planList = planService.findAll();
        return new ResponseEntity(SUCCESS, planList);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity delete(@RequestBody String id) {
        System.out.println(id);
        planService.deleteById(id);
        return new ResponseEntity(SUCCESS);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity save(@RequestBody Plan plan) {
        planService.savePlan(plan);
        return new ResponseEntity(SUCCESS);
    }

    @PostMapping("/queryById")
    @ResponseBody
    public ResponseEntity QueryById(@RequestBody String id) {
        Plan plan = planService.queryById(id);
        return new ResponseEntity(SUCCESS,plan);
    }

    @RequestMapping("/file")
    @ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        String name = request.getParameter("file");
        String name = "开发计划";
        String path = File.separator + "file"+ File.separator + "pm" + File.separator + "upload" + File.separator + name + ".xlsx";
//        if(1==1)return ;
        //下载的文件携带这个名称
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义格式
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8") + df.format(new Date()) + ".xlsx");
        //文件下载类型--二进制文件
        response.setContentType("application/octet-stream");
        InputStream is = null;
        ServletOutputStream sos = null;
        try {
            is = new FileInputStream(path);
            sos = response.getOutputStream();
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            // 字段列表
            String[] sheetLineInfo = {"commit_date", "commit_person", "confirm_person", "requirement_type",
                    "requirement_module", "requirement_description", "develop_person", "begin_date", "end_date", "state", "notes"};
            List<Map<String, Object>> resultList= planService.queryAlltoMap();
            for (int i = 0; i < resultList.size() ; i++) {
                Row row = sheet.getRow(i+1);
                if(row == null) {
                    row = sheet.createRow(i+1);
                }
                Map<String, Object> resultMap = resultList.get(i);
                for(int j = 0; j < sheetLineInfo.length; j++) {
                    Cell cell = row.createCell(j);
                    if(cell == null) {
                        cell = row.createCell(j);
                    }
                    CellStyle cellStyle = cell.getCellStyle();
                    //自动换行
                    cellStyle.setWrapText(true);
                    if(resultMap.get(sheetLineInfo[j]) == null) continue;
                    if(resultMap.get(sheetLineInfo[j]).getClass().getName().equals("java.sql.Timestamp")) {
                        cell.setCellValue(df.format(resultMap.get(sheetLineInfo[j])));
                    } else {
                        cell.setCellValue(resultMap.get(sheetLineInfo[j]).toString());
                    }
                }
            }
            workbook.write(sos);
            sos.flush();
//            return new ResponseEntity(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
//            return new ResponseEntity(WARN, e.getMessage());
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (sos != null) {
                    sos.close();
                }
            }  catch (IOException e) {
                e.printStackTrace();
//                return new ResponseEntity(WARN, e.getMessage());
            }
        }
    }
}
