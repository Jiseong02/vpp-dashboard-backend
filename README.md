# VITA for VPP

VITA 플랫폼은 중개사업자를 위한 차세대 가상발전소(VPP) 운영 PaaS 솔루션입니다.  
발전량 예측 제출부터 정산금 지급까지 전체 과정을 자동화하고 최적화합니다.

---

## 주요 기능

### 1. 발전량 예측 데이터 수집
- 중개사업자가 제출한 DER(분산형 에너지 자원)별 발전량 예측 데이터를 수집합니다.

### 2. 실시간 신뢰도 평가
- 제출된 예측값과 실제 발전량 데이터를 비교하여 DER별 신뢰도 점수를 계산합니다.

### 3. 신뢰도 기반 예측 보정 (Trust-aware Adjustment)
- 신뢰도 점수를 기반으로 발전량 예측값을 자동 보정하여 시장 신뢰성을 향상시킵니다.

### 4. 실적 데이터 수신 및 오차율 분석
- KPX로부터 실적 데이터를 수신하고, 각 DER의 오차율 및 정확도를 분석합니다.

### 5. 성과기반 정산금 자동 계산
- 예측 정확도에 따라 보상 또는 패널티를 적용하여 중개사업자별 정산금을 산출합니다.

### 6. 성과 리포트 생성 및 제공
- DER별 신뢰도, 예측 정확도, 정산 결과를 종합한 리포트를 자동 생성하여 제공합니다.

### 7. 플랫폼 운영 실시간 모니터링
- 예측 정확도, 발전 실적, 정산 내역, 시스템 상태를 실시간 대시보드를 통해 모니터링합니다.

---

## 주요 기술

- FastAPI 기반 API 서버
- Celery 비동기 워커 처리
- Streamlit 기반 대시보드
- Kubernetes + Helm 배포
- Prometheus + Grafana 모니터링
- GitHub Actions 기반 CI/CD
- Slack + Alertmanager 기반 알림 시스템

---

## 프로젝트 구조 (수정 필)

```plaintext
프로젝트/
├── app/                  # FastAPI 백엔드 서버
│   ├── main.py
│   ├── api/
│   ├── services/
│   ├── tasks/
│   ├── db/
│   └── config.py
├── streamlit_dashboard/   # Streamlit 대시보드
│   ├── app.py
│   └── pages/
├── helm/                  # Kubernetes 배포용 Helm 차트
│   ├── Chart.yaml
│   ├── values.yaml
│   └── templates/
├── .github/               # PR/이슈 템플릿, CODEOWNERS 등
├── README.md
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
├── SECURITY.md
├── LICENSE
└── requirements.txt
```

## 시스템 워크플로우

[중개사업자 예측 제출]
     ↓
[FastAPI API 서버 수신 및 검증]
     ↓
[Celery 워커 - 신뢰도 기반 예측 보정]
     ↓
[KPX 전송 및 실적 수신]
     ↓
[Celery 워커 - 정산금 계산 로직 실행]
     ↓
[PostgreSQL 데이터베이스 저장]
     ↓
[Streamlit 대시보드 실시간 조회 제공]

- 실시간 데이터는 Prometheus를 통해 수집되고 Grafana 대시보드에서 시각화합니다.

- 주요 이벤트(오류, 이상 상황)는 Slack을 통해 알림이 전송됩니다.

- 서비스별 Canary 배포(Argo Rollouts)를 통해 점진적 배포가 가능합니다.

--- 

## 설치 및 환경설정 (Installation and Setup)



---

## 실행 (How to use it)

---

## 메인 알고리즘 소개

### 1. 신뢰도 기반 발전량 예측 보정 (Trust-aware Adjustment)
VPP 내 DER(분산 에너지 자원)의 신뢰도 기반으로 발전 예측치를 동적으로 조정합니다.


#### 신뢰도 정의
$$
T(r, t) = 
\begin{cases}
\left(1 - \min\left(\left|\dfrac{P^{obs}_{rt} - P^{pre}_{rt}}{P^{obs}_{rt}}\right|, 1\right)\right)^{-1} & \text{if } P^{obs}_{rt} \geq P^{pre}_{rt} \\
1 - \min\left(\left|\dfrac{P^{obs}_{rt} - P^{pre}_{rt}}{P^{obs}_{rt}}\right|, 1\right) & \text{if } P^{obs}_{rt} < P^{pre}_{rt}
\end{cases}
$$

- T(r,t): 시간 t에서 r번째 DER의 신뢰도
- P_obs(r,t): 실제 발전량
- P_pre(r,t): 예측 발전량
- 오차가 작을수록 신뢰도는 1에 가까워짐.


#### 에너지 예측 보정
$$
P(V, t, w) = \dfrac{1}{\left| V \right|} \times \sum_{r \in V} WP(r, t, w)
$$

- V: VPP에 소속된 DER 집합
- WP(r, t, w): 신뢰도 기반 창(window) 가중치가 적용된 에너지 예측값


#### 윈도우 기반 가중 이동 평균
$$
WP(r, t, w) = \dfrac{ \sum_{i = t-w+1}^{t} \alpha^{t-i+1} \times T(r, i) \times P_{pre}(r, i) }{ \sum_{i = t-w+1}^{t} \alpha^{t-i+1} }
$$

- α: 감쇠 계수(decay factor, 기본값 0.9)
- w: 윈도우 크기 (기본 96)
- 최근 데이터일수록 가중치를 높게 부여


### 2. 정산금 계산 
하루 전에 제출된 발전 예측치를 정산 정책에 기반하여 계산합니다.

#### 정규화 평균 절대 오차 (normalized Mean Abolute Error, nMEA)
$$
nMAE(r, t)\ (\%) = \dfrac{ \left| P_{obs}(r, t) - P_{pre}(r, t) \right| }{ r_{max} } \times 100
$$
- r_max: DER r의 최대 발전량
- nMAE가 8% 이하인 경우 보상 대상


#### 신뢰도 미달률 (non-Trust Hit Rate, n-THR)
$$
n\text{-}THR(r, w)\ (\%) = \dfrac{ \mathrm{count}\left(nMAE(r, t) > 8\right) }{ \mathrm{count}\left(nMAE(r, t) \geq 0\right) } \times 100
$$
- n-THR이 낮을수록 높은 예측 신뢰도
- 제안된 방법은 기존 방식 대비 평균 15%의 예측 정확도 향상

---

## 모니터링 대시보드 (이미지 필)


---

## Publication

- Trust-aware adjustment on VPP, Paper:

Jaekyeong Kim, et al, Sejin Chun, and Jungkyu Han,
"A Trust-Aware Adjustment on Energy Prediction of Distributed Renewable Energy Resources Toward Reliable Virtual Power Plant",
Proc. of the International Symposium on Nonlinear Theory and Its Applications (NOLTA), 2024  

- Trust-aware adjustment on VPP, Journal:

Jaekyeong Kim, Sejin Chun, and Jungkyu Han,
"Trust-aware adjustment for accurate prediction of distributed renewable energy resources toward sustainable virtual power plant system",
Nonlinear Theory and Its Applications, IEICE, vol. 2, no. 3, pp. 1101–1108, 2025
