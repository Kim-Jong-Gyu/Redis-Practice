로그인 없는 장바구니 기능을 만들어보자.

1. 데이터 타입은 Hash를 사용한다.
2. 특정 사용자의 장바구니가 사용된지 3시간이 지나면 삭제되도록 조정한다.
3. 장바구니에 물품 조정, 장바구니 조회 기능이 존재한다.
    1. 특별한 Entity의 추가 구현 없이, 대상 물품과 수량은 클라이언트가 정해서 전달한다고 가정하자.
    2. 만약 수량을 줄이고 싶다면 음수가 전달되며,
    3. 수량이 0 이하가 되면 장바구니에서 제거된다.
4. 여러 애플리케이션 인스턴스에 걸쳐 부하가 분산됨을 가정하자.
