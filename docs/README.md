## 기능 목록

### 도메인

### 야구 게임

- [ ] 숫자를 비교해 얻은 힌트를 리스트에 담아 반환한다.
- [ ] 3개의 숫자를 모두 맞히면 게임이 종료된다.
- [ ] 게임을 재시작할지 boolean 값을 반환한다.

### 숫자

- [x] 1부터 9까지 수가 아닌 경우 IllegalArgumentException 예외를 throw 한다.
- [ ] 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱 이란 힌트를 얻는다.

### 힌트

- [x] 파라미터로 넘긴 힌트가 몇 개 있는지 반환한다.
    - [x] 스트라이크 개수를 반환한다.
    - [x] 볼 개수를 반환한다.
- [ ] 스트라이크 또는 볼이 없는 경우 true를 반환한다.

### 게임 전략

- [ ] 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.

<hr>

### 입출력

### 입력

- [ ] 서로 다른 3자리의 수를 입력받는다.
    - [ ] 숫자가 아닐 경우 IllegalArgumentException 예외를 throw한다.
    - [ ] 3자리의 수가 아닐 경우 IllegalArgumentException 예외를 throw한다.
    - [ ] 서로 다른 수가 아닐 경우 IllegalArgumentException 예외를 throw 한다.

- [ ] 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력받는다.
    - [ ] 숫자가 아닐 경우 IllegalArgumentException 예외를 throw 한다.
    - [ ] 1과 2 중 하나의 수가 아닌 경우 IllegalArgumentException를 throw 한다.

### 출력

- [ ] 결과를 볼, 스트라이크 개수로 표시한다.
- [ ] 게임 시작 문구 출력