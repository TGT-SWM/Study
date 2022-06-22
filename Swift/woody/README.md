# Swift 초간단 튜토리얼

## 1. 표준 입출력

### 출력

```swift
print("Hello, World!") // Hello, World!
print(1, 2, 3) // 1 2 3
```

### 입력

```swift
var input = readLine() // Hello, World!
print(input) // Optional("Hello, World!")
```

`readLine()`은 입력 문자열을 Optional로 래핑해 반환하기 때문에,
그대로 출력하면 `Optinal("입력한 문자열")` 형태로 보인다.
찾아보면 Forced Unwrapping(사용 금지), Optional Binding, `??` 연산자 등의 언래핑 방법들이 있으니 참고.

## 2. 변수와 상수

```swift
let a = 1 // 상수, 값의 변경 불가
var b = 10.0 // 변수, 값의 변경 가능
var c: String = "Hello, World!" // Type Annotation
```

타입 추론 덕분에 대부분의 상황에서 Type Annotation은 필수가 아니다.
하지만 변수의 선언과 초기화를 분리하거나, 추론되는 타입이 아니라 다른 타입을 지정하고 싶은 경우에는
Type Annotation을 사용한다.

## 3. 자료형

### 기본 데이터 타입

- `Int`
  - `Int32`나 `Int64` 같은 타입도 정의되어 있는데, 만약 64-bit CPU인 경우 `Int`는 `Int64`이다.
- `UInt`
  - Unsinged Int
- `Float`
  - 32-bit 부동 소수점 실수
- `Double`
  - 64-bit 부동 소수점 실수
- `Bool`
  - true or false
- `String`
  - `"Hello, World!"`
- `Character`
  - `"A"`처럼 문자 하나를 저장한다. 문자열처럼 쌍따옴표를 사용하지만, 쌍따옴표 사이에 단 하나의 문자가 포함되어야 한다.
- Optional
  - `Int?`처럼 뒤에 물음표를 붙여 사용
  - `nil`을 값으로 가질 수 있다.
- Tuples
  - `(1, 2.0, "Three")` 같은 튜플

### 컬렉션 타입

#### Array

```swift
var someInts: [Int] = [1, 2, 3]
```

#### Set

```swift
var favoriteGenres: Set<String> = ["Rock", "Classical", "Hip hop"]
```

#### Dictionary

```swift
var airports: [String: String] = ["YYZ": "Toronto Pearson", "DUB": "Dublin"]
```

## 4. 연산자

다른 언어와 큰 차이는 없지만, 보고 넘어가면 좋을 것들은...

### Nil 병합 연산자

```swift
var name: String? = nil
print(name ?? "Unnamed") // Unnamed
```

### 범위 연산자

```swift
// Closed Range Operator
for idx in 1...3 { // 1 2 3
    print(idx)
}

// Half-Open Range Operator
for idx in 1..<3 { // 1 2
    print(idx)
}

// One-Side Ranges
var names = ["Anna", "Brian", "Jack", "Alex"]
print(names[1...]) // ["Brian", "Jack", "Alex"]
print(names[...1]) // ["Anna", "Brian"]
print(names[..<1]) // ["Anna"]
```

## 5. 제어문

### `for-in`

```swift
// Array
let names = ["Anna", "Alex", "Brian", "Jack"]
for name in names {
    print("Hello, \(name)!")
}

// Dictionary
let numberOfLegs = ["spider": 8, "ant": 6, "cat": 4]
for (animalName, legCount) in numberOfLegs {
    print("\(animalName)s have \(legCount) legs")
}
```

### `while`

```swfit
var i = 0
while i < 5 {
    print(i)
    i += 1
}
```

`repeat-while`도 있는데, 타 언어의 `do-while`과 똑같다.

### `if`

```swift
let score = 85, grade: Character
if score >= 90 {
    grade = "A"
} else if score >= 85 {
    grade = "B"
} else {
    grade = "C"
}

print(grade) // B
```

### `switch`

```swift
let someCharacter: Character = "z"
switch someCharacter {
case "a":
    print("The first letter of the alphabet")
case "z":
    print("The last letter of the alphabet")
default:
    print("Some other character")
}
```

위 코드에서 특이한 점은 각 `case`에서 `break`를 하지 않았다는 점인데,
Swift의 `switch`는 `break`를 필요로 하지 않는다. C언어는 `case`의 실행을 끝내고 `break`를 하지 않으면 다음 `case`로 넘어가도록 동작하는데, Swift는 처음 매칭된 `case` 실행이 끝나면 그대로 `switch`를 종료해버리기 때문이다.

이는 `switch`를 다음 코드처럼 사용할 수 없다는 의미이기도 하다.

> `break`를 사용할 수 없는 건 아니다. `case` 안에서 `break`를 사용할 경우 해당 `switch` 문이 종료된다.

> `fallthrough`를 통해 C언어처럼 다음 `case`로 넘어가도록 동작시킬 수 있다.

```swift
let someCharacter: Character = "z"
switch someCharacter {
case "a": // error
case "A":
    print("The first letter of the alphabet")
case "z": // error
case "Z":
    print("The last letter of the alphabet")
default:
    print("Some other character")
}
```

하나의 `case`는 반드시 하나의 Statement를 필요로 한다.

추가적으로, `case` 값으로 Range나 Tuple을 활용할 수 있으며, 각종 편리한 기능들이 몇가지 있는 것 같다. 자세한 내용은 공식 문서를 참고.

## 6. 함수

```swift
func greet(person: String) -> String {
    let greeting = "Hello, " + person + "!"
    return greeting
}
```

## 7. Value와 Reference

[[Swift] Value, Reference type에 관해 알아야 할 10가지](https://velog.io/@eddy_song/Swift-Value-Reference)
