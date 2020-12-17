# 숭실대학교 모바일프로그래밍 나반 7조 팀프로젝트
## 애플리케이션 기능 설명
* 판매 상품 검색
* 상품에 대한 상세정보 확인
* 기증하고자 하는 물품에 대한 정보 및 사진 업로드
* 기증 물품 및 판매 상품 데이터 관리
* 상품 픽업 예약
* 아름다운 가게 홈페이지 바로가기

## 결과 화면
| 메인 페이지 | 상세정보 페이지 | 상품 검색 |
|---|---|---|
|<img width="300" src="https://user-images.githubusercontent.com/55284181/102485744-5e438280-40ab-11eb-96a1-0ddad6e5e352.gif">|<img width="300" src="https://user-images.githubusercontent.com/55284181/102486104-e45fc900-40ab-11eb-9803-0f9252fced45.gif">|<img width="300" src="https://user-images.githubusercontent.com/55284181/102486796-f0985600-40ac-11eb-9cfb-aca9ceb96f74.gif">|
| **아름다운 가게 홈페이지 바로가기** | **기증 물품에 대한 정보 및 사진 업로드** |
|<img width="300" src="https://user-images.githubusercontent.com/55284181/102487034-466cfe00-40ad-11eb-9f71-c24a16f0b0ee.gif">|<img width="300" src="https://user-images.githubusercontent.com/55284181/102487755-694be200-40ae-11eb-82ac-bfeaddac0a44.gif">|


## mySQL Database (goodsDB)
### donate table description :
| Field       | Type         | Null | Key | Default | Extra          |
|-------------|--------------|------|-----|---------|----------------|
| id          | int          | NO   | PRI | NULL    | auto_increment |
| name        | varchar(255) | NO   |     | NULL    |                |
| category    | varchar(255) | NO   |     | NULL    |                |
| donor       | varchar(100) | NO   |     | NULL    |                |
| image1      | longblob     | YES  |     | NULL    |                |
| image2      | longblob     | YES  |     | NULL    |                |
| image3      | longblob     | YES  |     | NULL    |                |
| image4      | blob         | YES  |     | NULL    |                |
| image5      | blob         | YES  |     | NULL    |                |
| image6      | blob         | YES  |     | NULL    |                |
| check_state | int unsigned | NO   |     | 0       |                |

image4~image6은 버그 문제로 사용하지 않음

### donate table example :
| id | name                   | category              | donor     | check_state |
|----|------------------------|-----------------------|-----------|-------------|
|  1 | 고양이 티셔츠          | 의류                  | 김영희    |           1 |
|  2 | 강아지 티셔츠          | 의류                  | 김영희    |           2 |
|  3 | 빨간색 텀블러          | 주방, 생활 잡화       | 김영희    |           1 |
|  4 | 강아지 티셔츠          | 의류                  | 김영희    |           0 |
|  6 | 스타벅스 텀블러        | 주방, 생활 잡화       | 김영희    |           0 |
|  7 | wall-e 인형            | 영유아 잡화           | 김영희    |           0 |

check_state : 검수 상태를 의미. 0은 검수 대기 중, 1은 기증 가능, 2는 기증 불가능

### product table description :
| Field       | Type         | Null | Key | Default | Extra          |
|-------------|--------------|------|-----|---------|----------------|
| id          | int          | NO   | PRI | NULL    | auto_increment |
| price       | int          | NO   |     | NULL    |                |
| store_loc   | varchar(255) | NO   |     | NULL    |                |
| reservation | varchar(100) | YES  |     | NULL    |                |

### product table example :
| id | price  | store_loc          | reservation |
|----|--------|--------------------|-------------|
|  1 |   2000 | 관악자명점         | NULL        |
|  2 |   2000 | 관악자명점         | 2020/12/17  |
|  3 |   3000 | 신대방점           | NULL        |
|  4 |   2000 | 관악자명점         | NULL        |
|  6 |   4000 | 양재점             | NULL        |
|  7 |   1000 | 압구정점           | NULL        |

## Appendix - 참조 링크

* **아름다운 가게**
  * <http://www.beautifulstore.org/>
* **당근 마켓**
  * <https://www.daangn.com/>

### Main Page
* RecyclerView 구현
  * RecyclerView로 목록 만들기, <https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=ko>
* 검색을 위한 필터링 구현
  * 안드로이드 EditText 필터링 검색 구현, <https://blog.naver.com/sungjun818/220427267971>
  * 리사이클러뷰 필터 사용하기, <https://m.blog.naver.com/PostView.nhn?blogId=rkswlrbduf&logNo=221208233990&proxyReferer=https:%2F%2Fwww.google.com%2F>
  * 안드로이드 커스텀 리스트뷰에서 검색된 아이템 보여주기, <https://recipes4dev.tistory.com/96>
* 데이터베이스 관리
  * Android PHP MySQL 예제 - 데이터베이스에 데이터 입력하기, <https://webnautes.tistory.com/828>
  * Android PHP MySQL 예제 - 데이터베이스에서 데이터를 JSON 형식으로 가져오기, <https://webnautes.tistory.com/829>

### Donate Page
* 사진 업로드
  * 카메라와 갤러리에서 이미지 가져오기, <https://black-jin0427.tistory.com/120>
  * 갤러리에서 이미지 불러와 이미지뷰에 보여주기, <https://webnautes.tistory.com/1302>
  * Android에서 image BLOB MySQL에 저장하기, <https://answerofgod.tistory.com/entry/Android%EC%97%90%EC%84%9C-image-BLOB-MySQL%EC%97%90-%EC%A0%80%EC%9E%A5%ED%95%98%EA%B8%B0>
  * MySQL에 저장된 IMAGE BLOB Android에서 보기, <https://answerofgod.tistory.com/717>
  * Bitmap -> String 변환, String -> Bitmap 변환, <https://youngest-programming.tistory.com/95>

### Product Details Page
* 픽업 날짜 예약
  * Date Picker 띄우기, <https://androman.tistory.com/95>
* 구글 맵
  * 구글 맵 사용하기, <https://1d1cblog.tistory.com/115>
  * 구글 맵에 마커 넣기, <https://1d1cblog.tistory.com/118>
  * Google Maps Android API 사용 방법 및 예제, <https://webnautes.tistory.com/647>
* 기타
  * RRGGBB(색) 참고, <https://www.rapidtables.com/web/color/html-color-codes.html>
  * android ImageView에 테두리(border) 넣기, <https://wefu.tistory.com/56>
  * 우재남, 박길식, 『Android Studio를 활용한 안드로이드 프로그래밍 5판 (Java 사용)』, 한빛아카데미
  
