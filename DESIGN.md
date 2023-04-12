made by songarden

######


1. 데이터베이스 설계 (MySQL 사용)

- 상품 도메인
 -Primary Key ) String productId (UUID logic -> insert without "-","")
 -String productName
 -Long productPrice (실제 상품가)
 -Long sale (세일하는 % -> 0 ~ 100 자유롭게 판매자가 설정 , ex) 0이면 실제 상품가가 판매가격)

   


- 주문 도메인
  -Primary Key ) String orderId (UUID logic)
  -Long orderPrice (주문 시 설정되있는 sale 값에 대한 price fix 하기 위한 필드값)
  -String address (배송 주소)
  -LocalDateTime orderTime (주문 시간)
  -Enum orderState (주문 상태)

