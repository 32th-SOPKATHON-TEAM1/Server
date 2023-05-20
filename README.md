# Git Convention

## Commit

> `분류` : `작업 내역` - `#이슈 번호`
> 

예시 메시지: [feat] Movie Entity 구현

```swift

chore: 일반적인 수정 사항#2
feat: 새로운 주요 기능 추가 #2
add: 파일 추가, etc... #2
fix: 버그 수정 #2
del: 코드 및 파일 삭제 #2
ref: 코드 리팩토링 -> 결과는 똑같음. 근데 코드가 달라짐 #2
rename: 파일, 클래스, 변수명 등 이름 변경 #2
docs: Wiki, README 및 문서 파일 수정 #2

```

# Code Convention

1. File Naming
- 파일 이름 및 클래스, 인터페이스 이름: **파스칼 케이스(Pascal Case)**

```java
public class ControllerExceptionAdvice {
```

1. Entity에서 사용되는 속성값들은 ? **카멜 케이스**(**camel Case)**

```java
private String email;
```

1. 내부에서 사용되는 함수 및 기타 사용: **카멜 케이스(camelCase)**

```java
public ApiResponse createEmail(@RequestBody @Valid final BoardRequestDto request) {
```

### **인터페이스 이름에 명사/형용사 사용 [interface-noun-adj]**

인터페이스(interface)의 이름은 명사/명사절로 혹은 형용사/형용사절로 짓는다.

```java
// Good Exemples
public interface RowMapper {
public interface AutoClosable {
```

### **클래스 이름에 명사 사용 [class-noun]**

클래스 이름은 명사나 명사절로 짓는다.

### **메서드 이름은 동사/전치사로 시작 [method-verb-preposition]**

메서드명은 기본적으로 동사로 시작한다.

✔️ 다른 타입으로 전환하는 메서드나 빌더 패턴을 구현한 클래스의 메서드에서는 전치사를 쓸 수 있다.

```java
- 동사사용 : renderHtml()
- 전환메서드의 전치사 : toString()
- Builder 패턴 적용한 클래스의 메서드의 전치사 : withUserId(String id)
```

### 🍑 **상수**

### **상수는 대문자와 언더스코어로 구성[constant_uppercase]**

"static final"로 선언되어 있는 필드일 때 상수로 간주한다.

상수 이름은 대문자로 작성하며, 복합어는 언더스코어'_'를 사용하여 단어를 구분한다.

```java
public final int UNLIMITED = -1;
public final String POSTAL_CODE_EXPRESSION = “POST”;
```

### **변수**

### **변수에 소문자 카멜표기법 적용 [var-lower-camelcase]**

상수가 아닌 클래스의 멤버변수/지역변수/메서드 파라미터에는 소문자 카멜표기법(Lower camel case)을 사용한다.

```java
private boolean authorized;
private int accessToken;
```

### **임시 변수 외에는 1 글자 이름 사용 금지 [avoid-1-char-var]**

메서드 블럭 범위 이상의 생명 주기를 가지는 변수에는 1글자로 된 이름을 쓰지 않는다.

**반복문의 인덱스나 람다 표현식의 파라미터 등 짧은 범위의 임시 변수**에는 관례적으로 1글자 변수명을 사용할 수 있다.

```java
HtmlParser parser = new HtmlParser();
```

## 📂 ERD

---
![image](https://github.com/32th-SOPKATHON-TEAM1/Server/assets/82709044/24c2a3ac-8417-4cfc-b47b-693e3842894e)

## 📂 프로젝트 구조

---

```
├── 📂.github

├── 📂 main
	├── 🗂️ resources
		├── 📕 application.yml

	├── 📂 controller(컨트롤러 파일)
		├── 🗂️ dto
			├──🗂️ request
			├──🗂️ response
			
	├── 📂 domain(엔티티 파일)

	├── 📂 repository(레포지토리 폴더)
	
	├── 📂 service(서비스 파일)
	
	├── 📂 config(bean )
	
	├── 📂 exception(Exception enum, Exception class 파일)
		├── 🗂️ model
	
	├── 📂 common(공용 클래스 관리)
```

### 03 팀원 역할 분배

**수현 & 원용**

- 프로젝트 초기 설정

**수현**

- [POST] `/post` API 구현

**원용**

- Dalle Open API 연결
- [GET] `/post/:postId` API 구현
![KakaoTalk_20230521_003304212](https://github.com/32th-SOPKATHON-TEAM1/Server/assets/82709044/1691b8c4-227b-4843-9f99-3deac93f266c)
