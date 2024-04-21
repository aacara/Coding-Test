N = int(input())
dp = [0] * (N+1)
days = []
prices = []

for i in range(N):
  t, p = map(int, input().split())
  days.append(t)
  prices.append(p)

for i in range(N):
  # 상담을 하는 경우
  if i+days[i] <= N:
    dp[i+days[i]] = max(dp[i]+prices[i], dp[i+days[i]])
  # 상담을 하지 않는 경우 - 이부분 놓침
  dp[i+1] = max(dp[i+1], dp[i])
print(max(dp))
