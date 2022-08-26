#  ((s^n%10)^m%1000000007)

def code(s,n,m):
  a = pow(s,n,10)
  ans = pow(a,m,1000000007)
  return ans
