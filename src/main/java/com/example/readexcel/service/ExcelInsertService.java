package com.example.readexcel.service;

import com.example.readexcel.entity.Menu;
import com.example.readexcel.repository.MenuRepository;
import io.opencensus.metrics.export.TimeSeries;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExcelInsertService {
    private final MenuRepository menuRepository;
    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    //저장할 repository
    @Transactional
    public void processExcelJinanData() throws Exception {
        List<Menu> menus = new ArrayList<>(); //메뉴

        FileInputStream fileInputStream = new FileInputStream(new File("C:/excel/test.xlsx"));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int batchSize = 10000; //1만건 처리

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; //헤더 스킵

            String name = getCellValue(row.getCell(0));
            String menuCreateBy = getCellValue(row.getCell(1));

            Menu menu = Menu.builder()
                    .name(name)
                    .menuCreateBy(menuCreateBy)
                    .build();
            menus.add(menu);
        }
        menuRepository.saveAll(menus);
        entityManager.flush();
        entityManager.clear();

        workbook.close();
        fileInputStream.close();
    }

    @Transactional
    public void processExcelJinanDataJdbc() throws Exception {
        List<Object[]> batchArgs = new ArrayList<>(); //메뉴
        FileInputStream fileInputStream = new FileInputStream(new File("C:/excel/test.xlsx"));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int batchSize = 20000; //1만건 처리
        String sql = "INSERT INTO menu (name, menu_create_by, created_at) VALUES (?, ?, ?)";
        Timestamp now = new Timestamp(System.currentTimeMillis()); //타임스탬프


        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; //헤더 스킵

            String name = getCellValue(row.getCell(0));
            String menuCreateBy = getCellValue(row.getCell(1));
            batchArgs.add(new Object[]{name, menuCreateBy, now});

            // batchSize마다 Insert 실행
            if (batchArgs.size() == batchSize) {
                jdbcTemplate.batchUpdate(sql, batchArgs);
                batchArgs.clear();
            }
        }

        // 남은 데이터 처리
        if (!batchArgs.isEmpty()) {
            jdbcTemplate.batchUpdate(sql, batchArgs);
        }

        workbook.close();
        fileInputStream.close();
    }


    //회원 및 카드 부터 insert
    // 📌 빈 셀을 예외 처리하는 메서드 추가
    public String getCellValue(Cell cell) {
        if (cell == null) return "";  // 빈 셀 처리
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue()); // 정수 변환
            default:
                return "";  // 기타 유형 (BLANK 등)은 빈 문자열 반환
        }
    }
}

