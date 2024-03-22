# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 기능 목록

** Controller, View 기재 외엔 Model 관련 테스트 대상
** 명확하게 MVC 구조를 따라가기엔 애매하다고 생각하여, 구조는 최대한 심플하게 작성 (단, 개념적으로 MVC로 간주)

0. Game 객체
    * public start() // Controller
    * public of()
1. 랜덤 숫자 RandomGenerator 객체
    * public generate()
2. 정답 Answer 객체
    * public of()
    * public grade()
    * public status()
    * private containsDigit()
    * private matchDigit()
3. 상태 Status 객체
    * public of()
    * public newInstance()
    * public increaseStrike()
    * public increaseBall()
    * public toString()
    * public isFinish()
4. 입출력 담당 IoTaker 객체 // View
    * public guess()
    * public isContinue()
    * public showStatus()
    * public showEndMessage()
