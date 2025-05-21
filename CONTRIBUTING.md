# 기여 가이드라인 (Contributing Guidelines)

이 프로젝트에 관심을 가져주셔서 감사합니다!

본 문서는 프로젝트에 기여할 때 따라야 할 절차와 규칙을 안내합니다.  
코드 품질 유지와 효율적인 협업을 위해 반드시 참고해 주세요.

---

## 시작하기 (Getting Started)

1. 저장소를 포크(Fork)합니다.
2. 자신의 GitHub 계정으로 포크한 저장소를 클론(Clone)합니다.
3. `main` 브랜치에서 새로운 기능(feature) 브랜치를 생성합니다.
4. 필요한 변경사항을 작업하고, 테스트를 수행합니다.
5. Pull Request(PR)를 생성하여 변경사항을 제출합니다.

---

## 프로젝트 구조 (Project Structure)

프로젝트/
├── app/ # FastAPI 백엔드 소스코드 <br/>
│ ├── main.py <br/>
│ ├── api/ <br/>
│ ├── services/ <br/>
│ ├── tasks/ <br/>
│ ├── db/ <br/>
│ └── config.py <br/>
├── streamlit_dashboard/ # Streamlit 대시보드 코드 <br/>
│ ├── app.py <br/>
│ └── pages/ <br/>
├── helm/ # Kubernetes 배포를 위한 Helm 차트 <br/>
│ ├── Chart.yaml <br/>
│ ├── values.yaml <br/>
│ └── templates/ <br/>
├── .github/ # PR 템플릿, 이슈 템플릿, CODEOWNERS <br/>
│ ├── PULL_REQUEST_TEMPLATE.md <br/>
│ └── ISSUE_TEMPLATE/ <br/>
├── README.md <br/>
├── CODE_OF_CONDUCT.md <br/>
├── CONTRIBUTING.md <br/>
├── SECURITY.md <br/>
├── LICENSE <br/>
└── requirements.txt <br/>


---

## 파일 및 폴더 명명 규칙 (Naming Rules)

- **소문자 + 언더스코어**(`snake_case`)를 사용합니다.
  - 예시: `forecast_service.py`, `user_api.py`
- **클래스명**은 **파스칼 표기법**(`PascalCase`)을 사용합니다.
  - 예시: `ForecastService`, `SettlementManager`
- 폴더명도 소문자와 언더스코어를 사용합니다.

---

## 브랜치 전략 (Branch Strategy)

- `main`: 항상 배포 가능한 안정된 상태 유지
- 기능 추가: `feature/기능명`
- 버그 수정: `bugfix/버그명`
- 긴급 수정: `hotfix/이슈명`

**브랜치 예시:**

```bash
git checkout -b feature/add-settlement-api
git checkout -b bugfix/fix-reliability-calc
```
---  

## 코드 스타일 가이드 (Python Coding Style)
본 프로젝트는 PEP 8 및 Google Python Style Guide를 준수합니다.

들여쓰기는 4칸 스페이스 사용 (Tab 금지)

한 줄 최대 100자 제한

함수 및 변수명은 snake_case

클래스명은 PascalCase

import 순서는 다음과 같습니다:

표준 라이브러리

서드파티 라이브러리

로컬 모듈

타입 힌트(Type Hint)를 적극적으로 사용합니다.

---

## 테스트 및 문서 작성
새로운 기능 추가 시 반드시 테스트 코드를 함께 작성합니다 (pytest 권장).

주요 함수, 클래스에는 Docstring을 작성합니다.

문서(README.md 등)를 필요한 경우 업데이트합니다.

---

## Pull Request 체크리스트
PR 생성 전 다음 사항을 확인해 주세요:

 코드가 정상적으로 작동합니까?

 기존 기능을 깨뜨리지 않았습니까?

 필요한 문서가 업데이트되었습니까?

 테스트 코드가 작성되었고 모두 통과합니까?

 커밋 메시지가 명확하고 일관성 있습니까?

---
## 감사의 말씀
모든 기여자는 프로젝트를 성장시키는 데 중요한 역할을 합니다.
여러분의 관심과 참여에 진심으로 감사드리며, 함께 높은 품질의 소프트웨어를 만들어 나가길 기대합니다.
