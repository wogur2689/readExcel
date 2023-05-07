package com.example.readexcel.service;

import com.example.readexcel.entity.FoodAndPlay;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FireBaseService {

    public static final String COLLECTION_NAME1 = "FoodAndPlay";

    public void insertData() throws Exception {
        //1. 파이어 스토어 생성
        Firestore db = FirestoreClient.getFirestore();

        //2. 값 세팅
        FoodAndPlay foodAndPlay = FoodAndPlay.builder()
                .name("테스트")
                .operatingTime("테스트")
                .closed("테스트")
                .phone("테스트")
                .characteristic("테스트")
                .location("테스트")
                .build();

        //3. Api통신을 이용한 DB insert
        ApiFuture<WriteResult> apiFuture = db.collection(COLLECTION_NAME1).document("2").set(foodAndPlay);

        log.info(apiFuture.get().getUpdateTime().toString());
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
