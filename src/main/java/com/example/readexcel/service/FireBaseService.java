package com.example.readexcel.service;

import com.example.readexcel.entity.FoodAndPlay;
import com.example.readexcel.entity.FoodAndPlayDetail;
import com.example.readexcel.entity.Restaurant;
import com.example.readexcel.util.ExcelRead;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FireBaseService {

    public static final String COLLECTION_NAME1 = "FoodAndPlay";
    public static final String COLLECTION_NAME2 = "FoodAndPlay_Detail";

    public void insertData() throws Exception {
        //1. 파이어 스토어 생성
        Firestore db = FirestoreClient.getFirestore();

        //2. 값 세팅
        ExcelRead excelRead = new ExcelRead();
        List<String> exceldata = excelRead.read();
        List<String> saveData = new ArrayList<>();
        Long j = 1L; //id

        log.info("### 데이터 시작 ###");
        log.info("### 데이터 갯수 : {} ###", exceldata.size());

        for(int i = 0; i < exceldata.size(); i++) {
            saveData.add(exceldata.get(i));
            log.info("saveData.size() : {}", saveData.size());

            //열개수만큼 데이터가 채워지면 데이터 저장
            if(saveData.size() == 9) {
                FoodAndPlay foodAndPlay = FoodAndPlay.builder()
                        .id(j)
                        .foodGroup(saveData.get(0))
                        .name(saveData.get(1))
                        .imgLink(saveData.get(2))
                        .recommend(false)
                        .operatingTime(saveData.get(3))
                        .closed(saveData.get(4))
                        .phone(saveData.get(5))
                        .characteristic(saveData.get(6))
                        .location(saveData.get(8))
                        .build();
                //3. Api통신을 이용한 DB insert
                ApiFuture<WriteResult> apiFuture = db.collection(COLLECTION_NAME1)
                        .document(String.valueOf(j)).set(foodAndPlay);

                log.info(apiFuture.get().getUpdateTime().toString());
                j++; //id값 증가
                saveData.clear(); //리스트 초기화
            }
        }
        log.info("### 데이터 저장 완료 ###");
    }
    public void insertDataDetail() throws Exception {
        //1. 파이어 스토어 생성
        Firestore db = FirestoreClient.getFirestore();

        //2. 값 세팅
        ExcelRead excelRead = new ExcelRead();
        List<String> exceldata = excelRead.read();
        List<String> saveData = new ArrayList<>();
        Long j = 1L; //id

        log.info("### 데이터 시작 ###");
        log.info("### 데이터 갯수 : {} ###", exceldata.size());

        for(int i = 0; i < exceldata.size(); i++) {
            saveData.add(exceldata.get(i));
            log.info("saveData.size() : {}", saveData.size());

            //열개수만큼 데이터가 채워지면 데이터 저장
            if(saveData.size() == 4) {
                FoodAndPlayDetail foodAndPlayDetail = FoodAndPlayDetail.builder()
                        .id(j)
                        .foodId(saveData.get(0))
                        .menuName(saveData.get(1))
                        .price(saveData.get(2))
                        .menuImgLink(saveData.get(3))
                        .build();

                //3. Api통신을 이용한 DB insert
                ApiFuture<WriteResult> apiFuture = db.collection(COLLECTION_NAME2)
                        .document(String.valueOf(j)).set(foodAndPlayDetail);

                log.info(apiFuture.get().getUpdateTime().toString());
                j++; //id값 증가
                saveData.clear(); //리스트 초기화
                break;
            }
        }
        log.info("### 데이터 저장 완료 ###");
    }

    public void selectData() throws Exception {
        //1. 파이어 스토어 생성
        Firestore db = FirestoreClient.getFirestore();

        //2. Api통신을 이용한 DB select
        ApiFuture<DocumentSnapshot> apiFuture = db.collection(COLLECTION_NAME1).document("2").get();
        DocumentSnapshot documentSnapshot = apiFuture.get();

        //3. 값세팅
        if(documentSnapshot.exists()) {
            FoodAndPlay foodAndPlay = documentSnapshot.toObject(FoodAndPlay.class);
            log.info("### 요청하신 데이터 : {} ###", foodAndPlay);
        }
    }
}
